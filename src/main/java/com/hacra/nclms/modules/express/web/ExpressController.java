package com.hacra.nclms.modules.express.web;

import com.hacra.nclms.common.base.BaseController;
import com.hacra.nclms.common.config.Global;
import com.hacra.nclms.common.utils.DateUtils;
import com.hacra.nclms.common.utils.LoginUtils;
import com.hacra.nclms.common.utils.StringUtils;
import com.hacra.nclms.modules.express.entity.Express;
import com.hacra.nclms.modules.express.service.ExpressService;
import com.hacra.nclms.modules.user.entity.User;
import com.hacra.nclms.modules.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    private final UserService userService;
    private final ExpressService expressService;

    @Autowired
    public ExpressController(ExpressService expressService, UserService userService) {
        this.expressService = expressService;
        this.userService = userService;
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
    public String search(Express express, Model model, HttpServletRequest request) {
        String view = LoginUtils.validate(Global.USER_TYPE_NORMAL, request);
        if (StringUtils.isNotBlank(view)) {
            return view;
        }
        if (StringUtils.isBlank(express.getId()) && StringUtils.isNotBlank(express.getCode())) {
            String message = expressService.validation(express.getCode());
            if (StringUtils.isBlank(message)) {
                Express e2 = expressService.get(express);
                if (e2 != null && StringUtils.isNotBlank(e2.getId())) {
                    model.addAttribute("express", e2);
                    model.addAttribute("message", "快递单号查询成功！");
                } else {
                    model.addAttribute("express", express);
                    model.addAttribute("message", "快递单号不存在！");
                }
            } else {
                model.addAttribute("express", express);
                model.addAttribute("message", message);
            }
        }
        return "modules/express/search";
    }

    /**
     * 寄件列表
     * @author Hacra
     * @date 2019-06-03 14:16
     */
    @RequestMapping(value = "list")
    public String list(Express express, Model model, HttpServletRequest request) {
        String view = LoginUtils.validate(Global.USER_TYPE_NORMAL, request);
        if (StringUtils.isNotBlank(view)) {
            return view;
        }
        User user = userService.getCurrUserSimple(request);
        express.setUserId(user.getId());
        List<Express> expressList = expressService.getAllList(express);
        model.addAttribute("expressList", expressList);
        return "modules/express/list";
    }

    /**
     * 线上快递申请
     * @author Hacra
     * @date 2019-04-30 11:48
     */
    @RequestMapping(value = {"form", ""})
    public String form(Express express, Model model, HttpServletRequest request) {
        String view = LoginUtils.validate(Global.USER_TYPE_NORMAL, request);
        if (StringUtils.isNotBlank(view)) {
            return view;
        }
        model.addAttribute("express", express);
        return "modules/express/form";
    }

    /**
     * 支付订单
     * @author Hacra
     * @date 2019-06-03 12:07
     */
    @RequestMapping(value = "pay")
    public String pay(Express express, Model model, HttpServletRequest request) {
        String view = LoginUtils.validate(Global.USER_TYPE_NORMAL, request);
        if (StringUtils.isNotBlank(view)) {
            return view;
        }
        express.setOrderTime(DateUtils.newDate());
        express.setPrice((int)(1+Math.random()*30));
        model.addAttribute("express", express);
        return "modules/express/pay";
    }

    /**
     * 快递信息查看
     * @author Hacra
     * @date 2019-04-30 11:49
     */
    @RequestMapping(value = "view")
    public String view(Express express, Model model, HttpServletRequest request) {
        String view = LoginUtils.validate(Global.USER_TYPE_NORMAL, request);
        if (StringUtils.isNotBlank(view)) {
            return view;
        }
        if (express == null || StringUtils.isBlank(express.getCode())) {
            model.addAttribute("message", "订单已取消！");
        } else {
            model.addAttribute("message", "订单已支付，寄件成功！");
        }
        model.addAttribute("express", express);
        return "modules/express/view";
    }

    /**
     * 快递信息保存
     * @author Hacra
     * @date 2019-04-30 11:53
     */
    @RequestMapping(value = "save")
    public String save(Express express, RedirectAttributes redirectAttributes, HttpServletRequest request) {
        String view = LoginUtils.validate(Global.USER_TYPE_NORMAL, request);
        if (StringUtils.isNotBlank(view)) {
            return view;
        }
        expressService.save(express, request);
        redirectAttributes.addFlashAttribute("express", express);
        return "redirect:/express/view";
    }

    /**
     * 快递信息删除
     * @author Hacra
     * @date 2019-04-30 11:53
     */
    @RequestMapping(value = "delete")
    public String delete(Express express, HttpServletRequest request) {
        String view = LoginUtils.validate(Global.USER_TYPE_NORMAL, request);
        if (StringUtils.isNotBlank(view)) {
            return view;
        }
        expressService.delete(express);
        return "redirect:/express/form";
    }
}
