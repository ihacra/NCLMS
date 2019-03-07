package com.hacra.nclms.modules.menu.entity;

import com.hacra.nclms.common.base.BaseEntity;
import org.springframework.stereotype.Component;

/**
 * 系统菜单
 *
 * @author Hacra
 * @version 1.0
 * @date 2019-03-06 17:50
 */
public class Menu extends BaseEntity<Menu> {

    private static final long serialVersionUID = 1L;
    private Menu parent;
    private String name;
    private int sort;
    private String href;
    private char isShow;

    public Menu() {
        super();
        this.sort = 10;
        this.isShow = '1';
    }

    public Menu(int id) {
        super(id);
    }

    public Menu getParent() {
        return parent;
    }

    public void setParent(Menu parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public char getIsShow() {
        return isShow;
    }

    public void setIsShow(char isShow) {
        this.isShow = isShow;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
