package com.hacra.nclms.modules.express.web;

import com.hacra.nclms.common.base.BaseController;
import com.hacra.nclms.common.utils.StringUtils;
import com.hacra.nclms.modules.express.entity.Express;
import com.hacra.nclms.modules.express.service.ExpressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 快递信息
 *
 * @author Hacra
 * @version 1.0
 * @date 2019-04-29 14:17
 */
@Controller
@RequestMapping(value = "/express")
public class ExpressController extends BaseController {

    private ExpressService expressService;

    @Autowired
    public ExpressController(ExpressService expressService) {
        this.expressService = expressService;
    }

    /**
     * 参数拦截
     * @author Hacra
     * @date 2019-04-30 11:42
     */
    @ModelAttribute
    public Express get(@RequestParam(required = false) String id) {
        if (StringUtils.isNotBlank(id)) {
            return expressService.get(id);
        }
        return new Express();
    }
    
    /**
     * 快递单号查询
     * @author Hacra
     * @date 2019-04-30 11:42
     */
    @RequestMapping(value = "search")
    public String search(Express express, Model model) {
        if (StringUtils.isBlank(express.getId()) && StringUtils.isNotBlank(express.getCode())) {
            express = expressService.get(express);
        }
        model.addAttribute("express", express);
        return "modules/express/search";
    }

    /**
     * 线上快递申请
     * @author Hacra
     * @date 2019-04-30 11:48
     */
    @RequestMapping(value = {"form", ""})
    public String form(Express express, Model model) {
        model.addAttribute("express", express);
        return "modules/express/form";
    }

    /**
     * 快递信息查看
     * @author Hacra
     * @date 2019-04-30 11:49
     */
    @RequestMapping(value = "view")
    public String view(Express express, Model model) {
        model.addAttribute("express", express);
        return "modules/express/view";
    }

    /**
     * 快递信息保存
     * @author Hacra
     * @date 2019-04-30 11:53
     */
    @RequestMapping(value = "save")
    public String save(Express express) {
        expressService.save(express);
        return "redirect:/express/view?id=" + express.getId();
    }

    /**
     * 快递信息删除
     * @author Hacra
     * @date 2019-04-30 11:53
     */
    @RequestMapping(value = "delete")
    public String delete(Express express) {
        expressService.delete(express);
        return "redirect:/express/form";
    }
}
