package com.hacra.nclms.modules.franchise.service;

import com.hacra.nclms.common.base.BaseService;
import com.hacra.nclms.modules.franchise.dao.FranchiseDao;
import com.hacra.nclms.modules.franchise.entity.Franchise;
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
public class FranchiseService extends BaseService<FranchiseDao, Franchise> {

    private final UserService userService;

    @Autowired
    public FranchiseService(UserService userService) {
        this.userService = userService;
    }

    /**
     * 通过id获取数据
     * @author Hacra
     * @date 2019-05-03 17:50
     */
    public Franchise get(String id) {
        return super.get(new Franchise(id));
    }

    /**
     * 保存方法
     * @author Hacra
     * @date 2019-06-03 15:42
     */
    public void save(Franchise franchise, HttpServletRequest request) {
        User user = userService.getCurrUserSimple(request);
        franchise.setUserId(user.getId());
        franchise.setUserName(user.getName());
        super.save(franchise);
    }
}
