package com.hacra.nclms.modules.franchise.entity;

import com.hacra.nclms.common.base.BaseEntity;

/**
 * 加盟合作
 *
 * @author Hacra
 * @version 1.0
 * @date 2019-05-01 17:49
 */
public class Franchise extends BaseEntity<Franchise> {

    private static final long serialVersionUID = 1L;
    private String name;
    private String address;
    private String mobile;
    private String experience;
    private String amount;
    private String area;
    private String customer;
    private String quantity;

    public Franchise() {
        super();
    }

    public Franchise(String id) {
        super(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
