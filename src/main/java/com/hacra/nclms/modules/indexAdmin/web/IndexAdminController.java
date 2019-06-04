package com.hacra.nclms.modules.indexAdmin.web;

import com.hacra.nclms.common.base.BaseController;
import com.hacra.nclms.common.config.Global;
import com.hacra.nclms.common.utils.LoginUtils;
import com.hacra.nclms.common.utils.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 首页 - 管理员
 * @author Hacra
 * @date 2019-06-03 19:01
 */
@Controller
@RequestMapping(value = "/admin/index")
public class IndexAdminController extends BaseController {

    /**
     * 首页
     * @author Hacra
     * @date 2019-06-03 19:16
     */
    @RequestMapping(value = {"index", ""})
    public String index(HttpServletRequest request) {
        String view = LoginUtils.validate(Global.USER_TYPE_ADMIN, request);
        if (StringUtils.isNotBlank(view)) {
            return view;
        }
        return "modules/indexAdmin/index";
    }
}
