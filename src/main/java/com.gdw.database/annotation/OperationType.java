package com.gdw.database.annotation;

import com.gdw.database.operation.Operation;

import java.lang.annotation.*;

/**
 * 2019/10/28 - 15:29 by guowenhao6
 * email：guowenhao6@jd.com
 * 不生产代码 做bug的搬运工
 *
 * @author guowenhao6
 * 修饰字段的查询条件
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface OperationType {
    /**
     * 查询条件，默认为等于（完全匹配）
     * @return
     */
    Operation value() default Operation.EQUAL;
}
