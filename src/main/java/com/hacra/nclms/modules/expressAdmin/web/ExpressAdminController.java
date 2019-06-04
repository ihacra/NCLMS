package com.hacra.nclms.modules.expressAdmin.web;

import com.hacra.nclms.common.base.BaseController;
import com.hacra.nclms.common.config.Global;
import com.hacra.nclms.common.utils.LoginUtils;
import com.hacra.nclms.common.utils.StringUtils;
import com.hacra.nclms.modules.expressAdmin.entity.ExpressAdmin;
import com.hacra.nclms.modules.expressAdmin.service.ExpressAdminService;
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
 * 快递管理
 *
 * @author Hacra
 * @version 1.0
 * @date 2019-06-03 19:52
 */
@Controller
@RequestMapping("/admin/express")
public class ExpressAdminController extends BaseController {

    private final ExpressAdminService expressAdminService;

    @Autowired
    public ExpressAdminController(ExpressAdminService expressAdminService) {
        this.expressAdminService = expressAdminService;
    }

    /**
     * 参数拦截
     * @author Hacra
     * @date 2019-06-03 20:29
     */
    @ModelAttribute
    public ExpressAdmin get(@RequestParam(required = false) String id) {
        if (StringUtils.isNotBlank(id)) {
            return expressAdminService.get(id);
        }
        return new ExpressAdmin();
    }

    /**
     * 快递列表
     * @author Hacra
     * @date 2019-06-03 19:59
     */
    @RequestMapping(value = {"list", ""})
    public String list(ExpressAdmin expressAdmin, @ModelAttribute(value = "message") String message, Model model, HttpServletRequest request) {
        String view = LoginUtils.validate(Global.USER_TYPE_ADMIN, request);
        if (StringUtils.isNotBlank(view)) {
            return view;
        }
        List<ExpressAdmin> expressAdminList = expressAdminService.getAllList(expressAdmin);
        model.addAttribute("expressAdminList", expressAdminList);
        model.addAttribute("message", message);
        return "modules/expressAdmin/list";
    }

    /**
     * 快递查看
     * @author Hacra
     * @date 2019-06-03 20:28
     */
    @RequestMapping(value = "view")
    public String view(ExpressAdmin expressAdmin, Model model, HttpServletRequest request) {
        String view = LoginUtils.validate(Global.USER_TYPE_ADMIN, request);
        if (StringUtils.isNotBlank(view)) {
            return view;
        }
        model.addAttribute("expressAdmin", expressAdmin);
        return "modules/expressAdmin/view";
    }

    /**
     * 快递修改
     * @author Hacra
     * @date 2019-06-03 21:42
     */
    @RequestMapping(value = "edit")
    public String edit(ExpressAdmin expressAdmin, Model model, HttpServletRequest request) {
        String view = LoginUtils.validate(Global.USER_TYPE_ADMIN, request);
        if (StringUtils.isNotBlank(view)) {
            return view;
        }
        model.addAttribute("expressAdmin", expressAdmin);
        return "modules/expressAdmin/edit";
    }

    /**
     * 保存信息
     * @author Hacra
     * @date 2019-06-03 21:49
     */
    @RequestMapping(value = "save")
    public String save(ExpressAdmin expressAdmin, RedirectAttributes redirectAttributes, HttpServletRequest request) {
        String view = LoginUtils.validate(Global.USER_TYPE_ADMIN, request);
        if (StringUtils.isNotBlank(view)) {
            return view;
        }
        expressAdminService.save(expressAdmin);
        redirectAttributes.addFlashAttribute("message", "快递信息修改成功！");
        return "redirect:/admin/express/list";
    }

    /**
     * 删除快递
     * @author Hacra
     * @date 2019-06-03 22:01
     */
    @RequestMapping(value = "delete")
    public String delete(ExpressAdmin expressAdmin, RedirectAttributes redirectAttributes, HttpServletRequest request) {
        String view = LoginUtils.validate(Global.USER_TYPE_ADMIN, request);
        if (StringUtils.isNotBlank(view)) {
            return view;
        }
        expressAdminService.delete(expressAdmin);
        redirectAttributes.addFlashAttribute("message", "快递信息删除成功！");
        return "redirect:/admin/express/list";
    }
}
