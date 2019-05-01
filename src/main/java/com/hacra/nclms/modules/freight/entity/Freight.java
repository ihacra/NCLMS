package com.hacra.nclms.modules.freight.entity;

/**
 * 运费查询
 *
 * @author Hacra
 * @version 1.0
 * @date 2019-05-01 16:22
 */
public class Freight {

    private String senderAddress;
    private String consigneeAddress;
    private Integer goodsWeight;
    private String orderTime;
    private float price;

    public Freight() {
        super();
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public String getConsigneeAddress() {
        return consigneeAddress;
    }

    public void setConsigneeAddress(String consigneeAddress) {
        this.consigneeAddress = consigneeAddress;
    }

    public Integer getGoodsWeight() {
        return goodsWeight;
    }

    public void setGoodsWeight(Integer goodsWeight) {
        this.goodsWeight = goodsWeight;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
