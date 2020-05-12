package com.gdw.database.generator;

import com.google.common.base.CaseFormat;
import com.gdw.database.operation.Operation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * 2019/10/28 - 17:01 by guowenhao6
 * email：guowenhao6@jd.com
 * 不生产代码 做bug的搬运工
 *
 * @author guowenhao6
 */
@Getter
@Setter
@AllArgsConstructor
class MetaData {

    private String name;
    private Operation operation;
    private String methodName;
    private Object value;
    private Object criteria;
    private String prefix;
    private String suffix;
    private Class fieldType;


    void execute() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method;
        if (StringUtils.isNotBlank(methodName)) {
            method = criteria.getClass().getDeclaredMethod(methodName);
        } else {
            if (value instanceof Collection) {
                if (operation == Operation.INCOLLECTON) {
                    String methodNameLocal = "and_" + prefix + "_" + CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, name) + "_" + suffix + "_in";
                    methodNameLocal = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, methodNameLocal);
                    method = criteria.getClass().getDeclaredMethod(methodNameLocal,fieldType);
                } else {
                    throw new NoSuchMethodException("condition is assignableFrom Collection , but operation does not match that, name is " + name);
                }
            } else {
                if (value instanceof Boolean) {
                    if (operation != Operation.EQUAL && operation != Operation.NOTEQUAL) {
                        throw new NoSuchMethodException("condition is assignableFrom Boolean , but operation does not match that, name is " + name);
                    }
                } else if (value instanceof String) {
                    if (operation == Operation.INCOLLECTON) {
                        throw new NoSuchMethodException("condition is assignableFrom String , but operation is in collection, name is " + name);
                    }
                } else {
                    if (operation == Operation.LIKE || operation == Operation.BEGIN || operation == Operation.END || operation == Operation.INCOLLECTON) {
                        throw new NoSuchMethodException("condition is a number , but operation does not match that, name is " + name);
                    }
                }
                String methodNameLocal = "and_" + prefix + "_" + CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, name) + "_" + suffix + "_" + operation.getValue();
                methodNameLocal = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, methodNameLocal);
                method = criteria.getClass().getMethod(methodNameLocal,fieldType);
            }
        }
        if (method==null){
            throw new NoSuchMethodException("no method ,property name is " + name);
        }
        method.setAccessible(true);
        if(operation==Operation.LIKE){
            method.invoke(criteria, "%" + value + "%");
        }else if(operation==Operation.BEGIN){
            method.invoke(criteria, value + "%");
        }else if(operation==Operation.END){
            method.invoke(criteria, "%" + value);
        }else {
            method.invoke(criteria, value);
        }
    }
}
