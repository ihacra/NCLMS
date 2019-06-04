package com.hacra.nclms.modules.index.web;

import com.hacra.nclms.common.base.BaseController;
import com.hacra.nclms.common.config.Global;
import com.hacra.nclms.common.utils.LoginUtils;
import com.hacra.nclms.common.utils.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 首页
 *
 * @author Hacra
 * @version 1.0
 * @date 2019-03-03 1:50
 */
@Controller
@RequestMapping(value = "/index")
public class IndexController extends BaseController {

    /**
     * 首页
     * @author Hacra
     * @date 2019-03-03 1:56
     */
    @RequestMapping(value = "index")
    public String index(HttpServletRequest request) {
        String view = LoginUtils.validate(Global.USER_TYPE_NORMAL, request);
        if (StringUtils.isNotBlank(view)) {
            return view;
        }
        return "modules/index/index";
    }
}
