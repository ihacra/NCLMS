package com.hacra.nclms.modules.expressAdmin.service;

import com.hacra.nclms.common.base.BaseService;
import com.hacra.nclms.modules.expressAdmin.dao.ExpressAdminDao;
import com.hacra.nclms.modules.expressAdmin.entity.ExpressAdmin;
import org.springframework.stereotype.Service;

/**
 * 快递管理
 *
 * @author Hacra
 * @version 1.0
 * @date 2019-06-03 19:48
 */
@Service
public class ExpressAdminService extends BaseService<ExpressAdminDao, ExpressAdmin>{

    /**
     * 通过id获取expressAdmin
     * @author Hacra
     * @date 2019-06-03 20:32
     */
    public ExpressAdmin get(String id) {
        return super.get(new ExpressAdmin(id));
    }
}
