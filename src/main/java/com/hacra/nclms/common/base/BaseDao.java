package com.hacra.nclms.common.base;

import java.util.List;

/**
 * DAO支持类
 *
 * @author Hacra
 * @version 1.0
 * @date 2019-03-02 18:10
 */
public interface BaseDao<T extends BaseEntity<T>> {

    /**
     * 获取单条数据
     * @author Hacra
     * @date 2019-03-02 18:18
     * @param id id
     * @return T
     **/
    T get(String id);

    /**
     * 获取单条数据
     * @author Hacra
     * @date 2019-03-02 18:18
     * @param entity entity
     * @return T
     **/
    T get(T entity);

    /**
     * 获取所有数据列表
     * @author Hacra
     * @date 2019-03-02 18:20
     * @param entity entity
     * @return java.util.List<T>
     **/
    List<T> getAllList(T entity);

    /**
     * 插入数据
     * @author Hacra
     * @date 2019-03-02 18:21
     * @param entity entity
     * @return int
     **/
    int insert(T entity);

    /**
     * 更新数据
     * @author Hacra
     * @date 2019-03-02 18:24
     * @param entity entity
     * @return int
     */
    int update(T entity);

    /**
     * 删除数据
     * @author Hacra
     * @date 2019-03-02 18:26
     * @param entity entity
     * @return int
     */
    int delete(T entity);

    /**
     * 获取下一序列值
     * @author Hacra
     * @date 2019-03-02 20:22
     * @param entity entity
     * @return int
     */
    String getNextId(T entity);
}
