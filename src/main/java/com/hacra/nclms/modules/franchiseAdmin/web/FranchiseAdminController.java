package com.hacra.nclms.modules.franchiseAdmin.web;

import com.hacra.nclms.common.base.BaseController;
import com.hacra.nclms.common.config.Global;
import com.hacra.nclms.common.utils.LoginUtils;
import com.hacra.nclms.common.utils.StringUtils;
import com.hacra.nclms.modules.franchiseAdmin.entity.FranchiseAdmin;
import com.hacra.nclms.modules.franchiseAdmin.service.FranchiseAdminService;
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
 * 加盟管理
 *
 * @author Hacra
 * @version 1.0
 * @date 2019-06-03 22:56
 */
@Controller
@RequestMapping(value = "/admin/franchise")
public class FranchiseAdminController extends BaseController {

    private final FranchiseAdminService franchiseAdminService;

    @Autowired
    public FranchiseAdminController(FranchiseAdminService franchiseAdminService) {
        this.franchiseAdminService = franchiseAdminService;
    }

    /**
     * 参数拦截
     * @author Hacra
     * @date 2019-06-03 22:58
     */
    @ModelAttribute
    public FranchiseAdmin get(@RequestParam(required = false) String id) {
        if (StringUtils.isNotBlank(id)) {
            return franchiseAdminService.get(id);
        }
        return new FranchiseAdmin();
    }

    /**
     * 加盟列表
     * @author Hacra
     * @date 2019-06-03 22:59
     */
    @RequestMapping(value = {"list", ""})
    public String list(FranchiseAdmin franchiseAdmin, @ModelAttribute(value = "message") String message, Model model, HttpServletRequest request) {
        String view = LoginUtils.validate(Global.USER_TYPE_ADMIN, request);
        if (StringUtils.isNotBlank(view)) {
            return view;
        }
        List<FranchiseAdmin> franchiseAdminList = franchiseAdminService.getAllList(franchiseAdmin);
        model.addAttribute("franchiseAdminList", franchiseAdminList);
        model.addAttribute("message", message);
        return "modules/franchiseAdmin/list";
    }

    /**
     * 加盟查看
     * @author Hacra
     * @date 2019-06-03 23:16
     */
    @RequestMapping(value = "view")
    public String view(FranchiseAdmin franchiseAdmin, Model model, HttpServletRequest request) {
        String view = LoginUtils.validate(Global.USER_TYPE_ADMIN, request);
        if (StringUtils.isNotBlank(view)) {
            return view;
        }
        model.addAttribute("franchiseAdmin", franchiseAdmin);
        return "modules/franchiseAdmin/view";
    }

    /**
     * 加盟审核
     * @author Hacra
     * @date 2019-06-03 23:18
     */
    @RequestMapping(value = "audit")
    public String audit(FranchiseAdmin franchiseAdmin, Model model, HttpServletRequest request) {
        String view = LoginUtils.validate(Global.USER_TYPE_ADMIN, request);
        if (StringUtils.isNotBlank(view)) {
            return view;
        }
        model.addAttribute("franchiseAdmin", franchiseAdmin);
        return "modules/franchiseAdmin/audit";
    }

    /**
     * 审核保存
     * @author Hacra
     * @date 2019-06-03 23:23
     */
    @RequestMapping(value = "auditSave")
    public String auditSave(FranchiseAdmin franchiseAdmin, RedirectAttributes redirectAttributes, HttpServletRequest request) {
        String view = LoginUtils.validate(Global.USER_TYPE_ADMIN, request);
        if (StringUtils.isNotBlank(view)) {
            return view;
        }
        franchiseAdminService.save(franchiseAdmin);
        redirectAttributes.addFlashAttribute("message", "加盟信息审核成功！");
        return "redirect:/admin/franchise/list";
    }

    /**
     * 删除信息
     * @author Hacra
     * @date 2019-06-03 23:26
     */
    @RequestMapping(value = "delete")
    public String delete(FranchiseAdmin franchiseAdmin, RedirectAttributes redirectAttributes, HttpServletRequest request) {
        String view = LoginUtils.validate(Global.USER_TYPE_ADMIN, request);
        if (StringUtils.isNotBlank(view)) {
            return view;
        }
        franchiseAdminService.delete(franchiseAdmin);
        redirectAttributes.addFlashAttribute("message", "加盟信息删除成功！");
        return "redirect:/admin/franchise/list";
    }
}
