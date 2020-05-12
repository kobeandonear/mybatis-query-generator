package com.gdw.database.annotation;

import java.lang.annotation.*;

/**
 * 2019/10/28 - 16:57 by guowenhao6
 * email：guowenhao6@jd.com
 * 不生产代码 做bug的搬运工
 *
 * @author guowenhao6
 * 将修饰的字段值传入指定的Criteria中的方法用于生成条件，用于方法为特殊实现（自定义或重写等）的情况
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface ConditionMethod {
    /**
     * 指定的方法名
     * @return
     */
    String value();
}
