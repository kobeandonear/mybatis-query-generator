package com.gdw.database.annotation;

import java.lang.annotation.*;

/**
 * 2019/10/28 - 16:40 by guowenhao6
 * email：guowenhao6@jd.com
 * 不生产代码 做bug的搬运工
 *
 * @author guowenhao6
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface CriteriaInfo {
    String criteriaInitMethodName() default "createCriteria";
    String fieldPrefix() default "";
    String fieldSuffix() default "";
}
