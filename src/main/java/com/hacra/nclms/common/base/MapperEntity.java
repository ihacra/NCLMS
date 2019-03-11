package com.hacra.nclms.common.base;

/**
 * 数据库处理类
 *
 * @author Hacra
 * @version 1.0
 * @date 2019-03-11 13:09
 */
public class MapperEntity {

    private String orderBy;

    public MapperEntity() {
        super();
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
}
