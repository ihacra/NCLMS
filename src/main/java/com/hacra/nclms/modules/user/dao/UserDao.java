package com.hacra.nclms.modules.user.dao;

import com.hacra.nclms.common.base.BaseDao;
import com.hacra.nclms.modules.user.entity.User;

/**
 * 用户
 *
 * @author Hacra
 * @version 1.0
 * @date 2019-06-02 20:20
 */
public interface UserDao extends BaseDao<User> {

    /**
     * 通过name获取User
     * @author Hacra
     * @date 2019-06-02 23:49
     */
    User getUserByName(User user);
}
