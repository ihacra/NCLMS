package com.hacra.nclms.modules.user.entity;

import com.hacra.nclms.common.base.BaseEntity;

import java.util.Date;

/**
 * 用户
 *
 * @author Hacra
 * @version 1.0
 * @date 2019-06-02 17:31
 */
public class User extends BaseEntity<User> {

    private static final long serialVersionUID = 1L;
    private String name;
    private String password;
    private String nick;
    private String gender;
    private String mail;
    private String birth;
    private String mobile;
    private String address;
    private String type;

    public User() {
        super();
    }

    public User(String id) {
        super(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
