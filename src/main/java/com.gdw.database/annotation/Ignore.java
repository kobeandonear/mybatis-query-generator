package com.gdw.database.annotation;

import java.lang.annotation.*;

/**
 * 2019/10/28 - 14:25 by guowenhao6
 * email：guowenhao6@jd.com
 * 不生产代码 做bug的搬运工
 *
 * @author guowenhao6
 *
 * 忽略字段标记，用于在查询类中不与实体类映射的字段
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Ignore {
}
