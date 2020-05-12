package com.gdw.database.annotation;

import java.lang.annotation.*;

/**
 * 2019/10/28 - 14:26 by guowenhao6
 * email：guowenhao6@jd.com
 * 不生产代码 做bug的搬运工
 *
 * @author guowenhao6
 * 修饰字段映射的实体类中的字段名，当查询类中字段名与实体类中不匹配时使用
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface PropertyName {
    /**
     * 映射的实体类中的字段名
     * @return
     */
    String value();
}
