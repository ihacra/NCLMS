package com.hacra.nclms.modules.sysindex.web;

import com.hacra.nclms.common.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 首页
 *
 * @author Hacra
 * @version 1.0
 * @date 2019-03-03 1:50
 */
@Controller
@RequestMapping(value = "${default.prefix}/sysindex")
public class SysIndexController extends BaseController {

    /**
     * 首页
     * @author Hacra
     * @date 2019-03-03 1:56
     */
    @RequestMapping(value = "index")
    public String index(HttpServletRequest request, HttpServletResponse response, Model model) {
        return "modules/sysindex/sysIndexIndex";
    }
}
