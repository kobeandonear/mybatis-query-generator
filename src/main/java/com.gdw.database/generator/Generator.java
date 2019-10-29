package com.gdw.database.generator;

import com.gdw.database.annotation.CriteriaInfo;
import com.gdw.database.annotation.Ignore;
import com.gdw.database.annotation.Operationype;
import com.gdw.database.annotation.PropertyName;
import com.gdw.database.operation.Operation;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * 2019/10/28 - 14:22 by guowenhao6
 * email：guowenhao6@jd.com
 * 不生产代码 做bug的搬运工
 *
 * @author guowenhao6
 */
public class Generator<T> {
    private static final List<String> types = Arrays.asList("java.lang.Integer",
            "java.lang.Double",
            "java.lang.Float",
            "java.lang.Long",
            "java.lang.Short",
            "java.lang.Byte",
            "java.lang.Boolean",
            "java.lang.String",
            "java.lang.Enum");
    private String createCriteriaMethodName = "createCriteria";
    private String prefix = "";
    private String suffix = "";


    public T generate(Object obj,Class<T> CriteriaClass) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        CriteriaInfo criteriaInfoAnnotation = obj.getClass().getAnnotation(CriteriaInfo.class);
        if(criteriaInfoAnnotation!=null){
            createCriteriaMethodName = criteriaInfoAnnotation.criteriaInitMethodName();
            prefix = criteriaInfoAnnotation.fieldPrefix();
            suffix = criteriaInfoAnnotation.fieldSuffix();
        }
        T instance = CriteriaClass.newInstance();
        Method createCriteria = CriteriaClass.getDeclaredMethod(createCriteriaMethodName);
        createCriteria.setAccessible(true);
        Object criteria = createCriteria.invoke(instance);

        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields){
            field.setAccessible(true);
            Object value = field.get(obj);
            if(value==null){
                continue;
            }
            if(!types.contains(value.getClass().getName())&&!(value instanceof List)){
                continue;
            }
            ////////////////////////////////
            Ignore ignore = field.getAnnotation(Ignore.class);
            if(ignore!=null){
                continue;
            }
            PropertyName propertyNameAnnotation = field.getAnnotation(PropertyName.class);
            String propertyName = field.getName();
            if(propertyNameAnnotation!=null){
                propertyName = propertyNameAnnotation.value();
            }
            Operation operation = Operation.EQUAL;
            Operationype operationTypeAnnotation = field.getAnnotation(Operationype.class);
            if(operationTypeAnnotation!=null){
                operation = operationTypeAnnotation.value();
            }
            String ConditionMethod = "";
            com.gdw.database.annotation.ConditionMethod conditionMethodAnnotation = field.getAnnotation(com.gdw.database.annotation.ConditionMethod.class);
            if(conditionMethodAnnotation!=null){
                ConditionMethod = conditionMethodAnnotation.value();
            }

            MetaData metaData = new MetaData(propertyName,operation,ConditionMethod,value,criteria,prefix,suffix);
            metaData.execute();
        }
        return instance;
    }
}
