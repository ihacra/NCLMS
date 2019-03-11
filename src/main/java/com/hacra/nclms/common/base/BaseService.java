package com.hacra.nclms.common.base;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Service基类
 *
 * @author Hacra
 * @version 1.0
 * @date 2019-03-02 18:29
 */
public abstract class BaseService<D extends BaseDao<T>, T extends BaseEntity<T>> {

    /**
     * 持久层对象
     * @date 2019-03-02 18:32
     */
    @Autowired
    protected D dao;

    /**
     * 获取单条数据
     * @author Hacra
     * @date 2019-03-02 18:33
     * @param id id
     * @return T
     */
    public T get(String id) {
        return dao.get(id);
    }

    /**
     * 获取单条数据
     * @author Hacra
     * @date 2019-03-02 18:35
     * @param entity entity
     * @return T
     */
    public T get(T entity) {
        return dao.get(entity);
    }

    /**
     * 获取所有数据列表
     * @author Hacra
     * @date 2019-03-02 18:37
     * @param entity entity
     * @return java.util.List<T>
     */
    public List<T> getAllList(T entity) {
        return dao.getAllList(entity);
    }

    /**
     * 插入数据
     * @author Hacra
     * @date 2019-03-02 18:51
     * @param entity entity
     */
    @Deprecated
    public void insert(T entity) {
        String id = dao.getNextId(entity);
        entity.preInsert(id);
        dao.insert(entity);
    }

    /**
     * 更新数据
     * @author Hacra
     * @date 2019-03-02 18:52
     * @param entity entity
     */
    @Deprecated
    public void update(T entity) {
        entity.preUpdate();
        dao.update(entity);
    }

    /**
     * 保存数据
     * @author Hacra
     * @date 2019-03-05 15:46
     * @param entity entity
     */
    public void save(T entity) {
        if (entity.isNewRecord()) {
            entity.preInsert(dao.getNextId(entity));
            dao.insert(entity);
        } else {
            entity.preUpdate();
            dao.update(entity);
        }
    }

    /**
     * 删除数据
     * @author Hacra
     * @date 2019-03-02 18:53
     * @param entity entity
     */
    public void delete(T entity) {
        entity.preUpdate();
        dao.delete(entity);
    }
}
