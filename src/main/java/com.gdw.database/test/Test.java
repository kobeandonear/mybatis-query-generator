package com.gdw.database.test;

import com.gdw.database.generator.Generator;

import java.lang.reflect.InvocationTargetException;

/**
 * 2019/10/28 - 18:46 by guowenhao6
 * email：guowenhao6@jd.com
 * 不生产代码 做bug的搬运工
 *
 * @author guowenhao6
 */
public class Test {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Query query = new Query();
        query.setId(1L);
        query.setBwLibId(2L);
        query.setDataType(com.gdw.database.test.DataTypeEnum.BLACK);
        query.setMemo("123");
        Generator<com.gdw.database.test.TpIpAntiInstanceBwGeoCriteria> geoCriteriaGenerator = new Generator<>();
        com.gdw.database.test.TpIpAntiInstanceBwGeoCriteria generate = geoCriteriaGenerator.generate(query, com.gdw.database.test.TpIpAntiInstanceBwGeoCriteria.class);
        generate.setOffset(13);
    }
}
