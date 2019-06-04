package com.hacra.nclms.modules.userAdmin.web;

import com.hacra.nclms.common.base.BaseController;
import com.hacra.nclms.common.config.Global;
import com.hacra.nclms.common.utils.LoginUtils;
import com.hacra.nclms.common.utils.StringUtils;
import com.hacra.nclms.modules.userAdmin.entity.UserAdmin;
import com.hacra.nclms.modules.userAdmin.service.UserAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 用户管理
 *
 * @author Hacra
 * @version 1.0
 * @date 2019-06-04 13:48
 */
@Controller
@RequestMapping(value = "/admin/user")
public class UserAdminController extends BaseController {

    private final UserAdminService userAdminService;

    @Autowired
    public UserAdminController(UserAdminService userAdminService) {
        this.userAdminService = userAdminService;
    }

    /**
     * 参数拦截
     * @author Hacra
     * @date 2019-06-04 13:50
     */
    @ModelAttribute
    public UserAdmin get(@RequestParam(required = false) String id) {
        if (StringUtils.isNotBlank(id)) {
            return userAdminService.get(id);
        }
        return new UserAdmin();
    }

    /**
     * 用户列表
     * @author Hacra
     * @date 2019-06-04 13:52
     */
    @RequestMapping(value = {"list", ""})
    public String list(UserAdmin userAdmin, @ModelAttribute(value = "message") String message, Model model, HttpServletRequest request) {
        String view = LoginUtils.validate(Global.USER_TYPE_ADMIN, request);
        if (StringUtils.isNotBlank(view)) {
            return view;
        }
        List<UserAdmin> userAdminList = userAdminService.getAllList(userAdmin);
        model.addAttribute("userAdminList", userAdminList);
        model.addAttribute("message", message);
        return "modules/userAdmin/list";
    }

    /**
     * 用户查看
     * @author Hacra
     * @date 2019-06-04 14:26
     */
    @RequestMapping(value = "view")
    public String view(UserAdmin userAdmin, Model model, HttpServletRequest request) {
        String view = LoginUtils.validate(Global.USER_TYPE_ADMIN, request);
        if (StringUtils.isNotBlank(view)) {
            return view;
        }
        model.addAttribute("userAdmin", userAdmin);
        return "modules/userAdmin/view";
    }

    /**
     * 用户修改
     * @author Hacra
     * @date 2019-06-04 14:37
     */
    @RequestMapping(value = "edit")
    public String edit(UserAdmin userAdmin, Model model, HttpServletRequest request) {
        String view = LoginUtils.validate(Global.USER_TYPE_ADMIN, request);
        if (StringUtils.isNotBlank(view)) {
            return view;
        }
        model.addAttribute("userAdmin", userAdmin);
        return "modules/userAdmin/edit";
    }

    /**
     * 保存信息
     * @author Hacra
     * @date 2019-06-04 14:40
     */
    @RequestMapping(value = "save")
    public String save(UserAdmin userAdmin, RedirectAttributes redirectAttributes, HttpServletRequest request) {
        String view = LoginUtils.validate(Global.USER_TYPE_ADMIN, request);
        if (StringUtils.isNotBlank(view)) {
            return view;
        }
        userAdminService.save(userAdmin);
        redirectAttributes.addFlashAttribute("message", "用户信息修改成功！");
        return "redirect:/admin/user/list";
    }

    /**
     * 删除用户
     * @author Hacra
     * @date 2019-06-04 14:50
     */
    @RequestMapping(value = "delete")
    public String delete(UserAdmin userAdmin, RedirectAttributes redirectAttributes, HttpServletRequest request) {
        String view = LoginUtils.validate(Global.USER_TYPE_ADMIN, request);
        if (StringUtils.isNotBlank(view)) {
            return view;
        }
        userAdminService.delete(userAdmin);
        redirectAttributes.addFlashAttribute("message", "用户信息删除成功！");
        return "redirect:/admin/user/list";
    }
}
