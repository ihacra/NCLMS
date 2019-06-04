package com.hacra.nclms.modules.userAdmin.service;

import com.hacra.nclms.common.base.BaseService;
import com.hacra.nclms.modules.userAdmin.dao.UserAdminDao;
import com.hacra.nclms.modules.userAdmin.entity.UserAdmin;
import org.springframework.stereotype.Service;

/**
 * 用户管理
 *
 * @author Hacra
 * @version 1.0
 * @date 2019-06-04 13:43
 */
@Service
public class UserAdminService extends BaseService<UserAdminDao, UserAdmin> {

    /**
     * 通过id获取userAdmin
     * @author Hacra
     * @date 2019-06-04 13:51
     */
    public UserAdmin get(String id) {
        return super.get(new UserAdmin(id));
    }
}
