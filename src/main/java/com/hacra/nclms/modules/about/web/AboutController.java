package com.hacra.nclms.modules.about.web;

import com.hacra.nclms.common.base.BaseController;
import com.hacra.nclms.common.config.Global;
import com.hacra.nclms.common.utils.LoginUtils;
import com.hacra.nclms.common.utils.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 关于我们
 *
 * @author Hacra
 * @version 1.0
 * @date 2019-05-01 21:14
 */
@Controller
@RequestMapping(value = "/about")
public class AboutController extends BaseController {

    /**
     * 关于我们
     * @author Hacra
     * @date 2019-05-01 21:15
     */
    @RequestMapping(value = {"view"})
    public String view(HttpServletRequest request) {
        String view = LoginUtils.validate(Global.USER_TYPE_NORMAL, request);
        if (StringUtils.isNotBlank(view)) {
            return view;
        }
        return "modules/about/view";
    }
}
