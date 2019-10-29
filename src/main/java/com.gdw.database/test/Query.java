package com.gdw.database.test;

import lombok.Getter;
import lombok.Setter;

/**
 * 2019/10/28 - 18:47 by guowenhao6
 * email：guowenhao6@jd.com
 * 不生产代码 做bug的搬运工
 *
 * @author guowenhao6
 */
@Getter
@Setter
public class Query {
    private Long id;

    private DataTypeEnum dataType;

    private Long instanceId;

    private Long bwLibId;

    private Long geoBlack;

    private String memo;
}
