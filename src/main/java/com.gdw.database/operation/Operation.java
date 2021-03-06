package com.gdw.database.operation;

import lombok.Getter;

/**
 * 2019/10/28 - 15:28 by guowenhao6
 * email：guowenhao6@jd.com
 * 不生产代码 做bug的搬运工
 *
 * @author guowenhao6
 */
@Getter
public enum Operation {
    /**
     * 查询条件枚举
     */
    EQUAL("equal_to"),
    NOTEQUAL("not_equal_to"),
    LIKE("like"),
    MORETHAN("greater_than"),
    LESSTHAN("less_than"),
    MORETHANOREQUAL("greater_than_or_equal_to"),
    LESSTHANOREQUAL("less_than_or_equal_to"),
    INCOLLECTON("in"),
    BEGIN("like"),
    END("like");
    private String value;

    Operation(String value) {
        this.value = value;
    }
}
