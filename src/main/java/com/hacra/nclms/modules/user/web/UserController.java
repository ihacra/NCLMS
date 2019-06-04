package com.hacra.nclms.modules.user.web;

import com.hacra.nclms.common.base.BaseController;
import com.hacra.nclms.common.utils.StringUtils;
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

/**
 * 用户管理
 *
 * @author Hacra
 * @version 1.0
 * @date 2019-06-03 0:51
 */
@Controller
@RequestMapping(value = "user")
public class UserController extends BaseController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 参数拦截
     * @author Hacra
     * @date 2019-06-03 0:54
     */
    @ModelAttribute
    public User get(@RequestParam(required = false) String id) {
        if (StringUtils.isNotBlank(id)) {
            return userService.get(id);
        }
        return new User();
    }

    /**
     * 用户信息展示
     * @author Hacra
     * @date 2019-06-03 1:32
     */
    @RequestMapping(value = "view")
    public String view(@ModelAttribute(value = "message") String message, Model model, HttpServletRequest request) {
        model.addAttribute("user", this.getCurrUser(request));
        model.addAttribute("message", message);
        return "modules/user/view";
    }

    /**
     * 保存信息
     * @author Hacra
     * @date 2019-06-03 16:39
     */
    @RequestMapping(value = "save")
    public String save(User user, RedirectAttributes redirectAttributes) {
        userService.save(user);
        redirectAttributes.addFlashAttribute("message", "个人信息保存成功！");
        return "redirect:/user/view";
    }

    /**
     * 获取当前登录用户
     * 简洁信息：id、name、nick
     * @author Hacra
     * @date 2019-06-03 1:02
     */
    public User getCurrUser(HttpServletRequest request) {
        return userService.getCurrUser(request);
    }

    /**
     * 获取当前登录用户
     * 简洁信息：id、name
     * @author Hacra
     * @date 2019-06-03 1:03
     */
    public User getCurrUserSimple(HttpServletRequest request) {
        return userService.getCurrUserSimple(request);
    }

    /**
     * 当前是否为登录状态
     * @author Hacra
     * @date 2019-06-03 1:07
     */
    public boolean getLoginStatus(HttpServletRequest request) {
        return userService.getLoginStatus(request);
    }
}
