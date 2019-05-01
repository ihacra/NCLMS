package com.hacra.nclms.modules.express.service;

import com.hacra.nclms.common.base.BaseService;
import com.hacra.nclms.common.utils.DateUtils;
import com.hacra.nclms.common.utils.StringUtils;
import com.hacra.nclms.modules.express.dao.ExpressDao;
import com.hacra.nclms.modules.express.entity.Express;
import org.springframework.stereotype.Service;

/**
 * 快递信息
 *
 * @author Hacra
 * @version 1.0
 * @date 2019-04-30 11:38
 */
@Service
public class ExpressService extends BaseService<ExpressDao, Express> {

    /**
     * 保存方法
     * @author Hacra
     * @date 2019-05-01 11:12
     */
    public void save(Express express) {
        express.setOrderTime(DateUtils.newDate());
        express.setPrice((int)(1+Math.random()*30));
        express.setStatus("");
        express.setCode(DateUtils.getDate("yyyyMMddHHmm")+ StringUtils.leftPad(String.valueOf(express.getGoodsWeight()), 4, '0'));
        super.save(express);
    }
}
