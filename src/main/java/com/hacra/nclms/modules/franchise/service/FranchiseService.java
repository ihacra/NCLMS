package com.hacra.nclms.modules.franchise.service;

import com.hacra.nclms.common.base.BaseService;
import com.hacra.nclms.modules.franchise.dao.FranchiseDao;
import com.hacra.nclms.modules.franchise.entity.Franchise;
import org.springframework.stereotype.Service;

/**
 * 加盟合作
 *
 * @author Hacra
 * @version 1.0
 * @date 2019-05-01 17:55
 */
@Service
public class FranchiseService extends BaseService<FranchiseDao, Franchise> {

    /**
     * 通过id获取数据
     * @author Hacra
     * @date 2019-05-03 17:50
     */
    public Franchise get(String id) {
        return super.get(new Franchise(id));
    }
}
