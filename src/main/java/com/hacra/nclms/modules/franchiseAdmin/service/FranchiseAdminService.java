package com.hacra.nclms.modules.franchiseAdmin.service;

import com.hacra.nclms.common.base.BaseService;
import com.hacra.nclms.modules.franchise.entity.Franchise;
import com.hacra.nclms.modules.franchiseAdmin.dao.FranchiseAdminDao;
import com.hacra.nclms.modules.franchiseAdmin.entity.FranchiseAdmin;
import com.hacra.nclms.modules.user.entity.User;
import com.hacra.nclms.modules.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * 加盟合作
 *
 * @author Hacra
 * @version 1.0
 * @date 2019-05-01 17:55
 */
@Service
public class FranchiseAdminService extends BaseService<FranchiseAdminDao, FranchiseAdmin> {

    /**
     * 通过id获取数据
     * @author Hacra
     * @date 2019-05-03 17:50
     */
    public FranchiseAdmin get(String id) {
        return super.get(new FranchiseAdmin(id));
    }

}
