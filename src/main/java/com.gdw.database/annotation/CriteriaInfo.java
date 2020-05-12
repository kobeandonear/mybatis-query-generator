package com.gdw.database.annotation;

import java.lang.annotation.*;

/**
 * 2019/10/28 - 16:40 by guowenhao6
 * email：guowenhao6@jd.com
 * 不生产代码 做bug的搬运工
 *
 * @author guowenhao6
 * 修饰查询类，用于查询类生成Criteria的配置
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface CriteriaInfo {
    /**
     * Criteria中生成内部Criteria的方法，通常默认为createCriteria()，版本变化时可修改为指定值
     * @return
     */
    String criteriaInitMethodName() default "createCriteria";

    /**
     * 实体类中的统一前缀，用于查询类和实体类不一致的情况
     * @return
     */
    String fieldPrefix() default "";

    /**
     * 实体类中的统一后缀，用于查询类和实体类不一致的情况
     * @return
     */
    String fieldSuffix() default "";
}
