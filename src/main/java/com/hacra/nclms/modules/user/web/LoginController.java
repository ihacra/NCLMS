package com.hacra.nclms.modules.user.web;

import com.hacra.nclms.common.base.BaseController;
import com.hacra.nclms.common.config.Global;
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
import javax.servlet.http.HttpServletResponse;

/**
 * 登录管理
 *
 * @author Hacra
 * @version 1.0
 * @date 2019-06-02 17:29
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController extends BaseController {

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 参数拦截
     * @author Hacra
     * @date 2019-06-02 21:04
     */
    public User get(@RequestParam(required = false) String id) {
        if (StringUtils.isNotBlank(id)) {
            return userService.get(id);
        }
        return new User();
    }

    /**
     * 用户登录
     * @author Hacra
     * @date 2019-06-02 17:33
     */
    @RequestMapping(value = {"login", ""})
    public String login(@ModelAttribute(value = "user") User user, @ModelAttribute(value = "message") String message, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("message", message);
        return "modules/user/login";
    }

    /**
     * 登录验证
     * @author Hacra
     * @date 2019-06-02 20:17
     */
    @RequestMapping(value = "validate")
    public String validate(User user, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
        user = userService.validate(user);
        if (user != null && StringUtils.isNotBlank(user.getId())) {
            userService.saveStatus(user, request, response);
            if (Global.USER_TYPE_ADMIN.equals(user.getType())) {
                return "redirect:/admin/index/index";
            } else {
                return "redirect:/index/index";
            }
        }
        redirectAttributes.addFlashAttribute("message", "账号或密码错误！");
        return "redirect:/login/login";
    }

    /**
     * 退出登录
     * @author Hacra
     * @date 2019-06-03 11:10
     */
    @RequestMapping(value = "out")
    public String out(HttpServletRequest request) {
        userService.clearStatus(request);
        return "redirect:/index/index";
    }
}
