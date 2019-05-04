package com.hacra.nclms.modules.express.service;

import com.hacra.nclms.common.base.BaseService;
import com.hacra.nclms.common.utils.DateUtils;
import com.hacra.nclms.common.utils.StringUtils;
import com.hacra.nclms.modules.express.dao.ExpressDao;
import com.hacra.nclms.modules.express.entity.Express;
import org.springframework.beans.factory.annotation.Autowired;
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

    private ExpressDao expressDao;

    @Autowired
    public void setExpressDao(ExpressDao expressDao) {
        this.expressDao = expressDao;
    }

    /**
     * 通过id获取数据
     * @author Hacra
     * @date 2019-05-03 17:49
     */
    public Express get(String id) {
        return super.get(new Express(id));
    }

    /**
     * 保存方法
     * @author Hacra
     * @date 2019-05-01 11:12
     */
    public void save(Express express) {
        express.setOrderTime(DateUtils.newDate());
        express.setPrice((int)(1+Math.random()*30));
        express.setStatus("");
        express.setCode(getCode());
        super.save(express);
    }

    /**
     * 快递单号生成
     * @author Hacra
     * @date 2019-05-03 17:17
     */
    private String getCode() {
        String code = DateUtils.getDate("yyyyMM") + StringUtils.leftPad(expressDao.getCode(), 4, '0');
        int sum = 0;
        for (char c : code.toCharArray()) {
            sum += Integer.parseInt(String.valueOf(c));
        }
        return  "KD" + code + sum % 10;
    }
}
