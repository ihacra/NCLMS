package com.hacra.nclms.modules.sysmenu.entity;

import com.hacra.nclms.common.base.BaseEntity;
import org.springframework.stereotype.Component;

/**
 * 系统菜单
 *
 * @author Hacra
 * @version 1.0
 * @date 2019-03-02 16:38
 */
@Component
public class SysMenu extends BaseEntity<SysMenu> {

    private static final long serialVersionUID = 1L;
    private SysMenu parent;
    private String name;
    private int sort;
    private String href;
    private char isShow;

    public SysMenu() {
        super();
        this.sort = 10;
        this.isShow = '1';
    }

    public SysMenu(int id) {
        super(id);
    }

    public SysMenu getParent() {
        return parent;
    }

    public void setParent(SysMenu parent) {
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
