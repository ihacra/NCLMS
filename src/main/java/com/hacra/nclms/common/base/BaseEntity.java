package com.hacra.nclms.common.base;

import com.hacra.nclms.common.config.Global;
import com.hacra.nclms.common.utils.DateUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * Entity支持类
 *
 * @author Hacra
 * @version 1.0
 * @date 2019-03-02 16:49
 */
public abstract class BaseEntity<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    protected int id;
    protected String remarks;
    protected Date createDate;
    protected Date updateDate;
    protected String delFlag;

    public static final String DEL_FLAG_NORMAL = "0";
    public static final String DEL_FLAG_DELETE = "1";

    public BaseEntity() {
        this.delFlag = DEL_FLAG_NORMAL;
    }

    public BaseEntity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * 插入之前执行方法，需要手动调用
     * @author Hacra
     * @date 2019-03-02 17:54
     **/
    public void preInsert(int id) {
        this.id = id;
        this.createDate = DateUtils.newDate();
        this.updateDate = this.createDate;
    }

    /**
     * 更新之前执行方法，需要手动调用
     * @author Hacra
     * @date 2019-03-02 17:56
     **/
    public void preUpdate() {
        this.updateDate = DateUtils.newDate();
    }

    /**
     * 全局变量对象
     * @author Hacra
     * @date 2019-03-02 16:54
     * @return com.hacra.nclms.common.config.Global
     **/
    public Global getGlobal() {
        return Global.getInstance();
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!getClass().equals(obj.getClass())) {
            return false;
        }
        BaseEntity that = (BaseEntity)obj;
        return this.getId() == that.getId();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
