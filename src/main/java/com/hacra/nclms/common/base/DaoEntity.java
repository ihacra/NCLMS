package com.hacra.nclms.common.base;

/**
 * 数据库处理类
 *
 * @author Hacra
 * @version 1.0
 * @date 2019-03-11 13:09
 */
public class DaoEntity {

    private String orderBy;

    public DaoEntity() {
        super();
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
}
