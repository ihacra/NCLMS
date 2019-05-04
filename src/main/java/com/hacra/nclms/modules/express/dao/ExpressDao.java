package com.hacra.nclms.modules.express.dao;

import com.hacra.nclms.common.base.BaseDao;
import com.hacra.nclms.modules.express.entity.Express;

/**
 * 快递信息
 *
 * @author Hacra
 * @version 1.0
 * @date 2019-04-30 11:37
 */
public interface ExpressDao extends BaseDao<Express> {

    /**
     * 获取快递单号的下一编号
     * @author Hacra
     * @date 2019-05-03 17:07
     * @return String
     */
    String getCode();
}
