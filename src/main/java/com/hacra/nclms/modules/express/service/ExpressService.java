package com.hacra.nclms.modules.express.service;

import com.hacra.nclms.common.base.BaseService;
import com.hacra.nclms.common.utils.DateUtils;
import com.hacra.nclms.common.utils.StringUtils;
import com.hacra.nclms.modules.express.dao.ExpressDao;
import com.hacra.nclms.modules.express.entity.Express;
import com.hacra.nclms.modules.user.entity.User;
import com.hacra.nclms.modules.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * 快递信息
 *
 * @author Hacra
 * @version 1.0
 * @date 2019-04-30 11:38
 */
@Service
public class ExpressService extends BaseService<ExpressDao, Express> {

    private final UserService userService;
    private final ExpressDao expressDao;

    @Autowired
    public ExpressService(ExpressDao expressDao, UserService userService) {
        this.expressDao = expressDao;
        this.userService = userService;
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
    public void save(Express express, HttpServletRequest request) {
        User user = userService.getCurrUserSimple(request);
        express.setUserId(user.getId());
        express.setUserName(user.getName());
        express.setOrderTime(DateUtils.newDate());
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

    /**
     * 快递单号格式验证
     * @author Hacra
     * @date 2019-06-02 14:29
     */
    public String validation(String code) {
        code = code.trim();
        char[] codes = code.toCharArray();
        if (codes.length != 13) {
            return "快递单号由“KD”及11位数字组成！";
        }
        if (codes[0] != 'K' || codes[1] != 'D') {
            return "快递单号由“KD”及11位数字组成！";
        }
        int sum = 0;
        for (int i = 2; i < 13; i++) {
            if (codes[i] >= '0' && codes[i] <= '9') {
                sum += Integer.parseInt(String.valueOf(codes[i]));
            }
            else {
                return "快递单号由“KD”及11位数字组成！";
            }
        }
        if (sum % 10 != (2 * Integer.parseInt(String.valueOf(codes[12]))) % 10) {
            return "快递单号数字效验错误！";
        }
        return "";
    }
}
