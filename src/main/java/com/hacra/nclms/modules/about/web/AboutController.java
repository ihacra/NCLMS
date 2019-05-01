package com.hacra.nclms.modules.about.web;

import com.hacra.nclms.common.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String view() {
        return "modules/about/view";
    }
}
