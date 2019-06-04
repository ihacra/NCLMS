package com.hacra.nclms.modules.user.web;

import com.hacra.nclms.common.base.BaseController;
import com.hacra.nclms.common.utils.StringUtils;
import com.hacra.nclms.modules.user.entity.User;
import com.hacra.nclms.modules.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 注册管理
 *
 * @author Hacra
 * @version 1.0
 * @date 2019-06-02 20:59
 */
@Controller
@RequestMapping(value = "register")
public class RegisterController extends BaseController {

    private final UserService userService;

    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 参数拦截
     * @author Hacra
     * @date 2019-06-02 21:06
     */
    public User get(@RequestParam(required = false) String id) {
        if (StringUtils.isNotBlank(id)) {
            return userService.get(id);
        }
        return new User();
    }

    /**
     * 用户注册
     * @author Hacra
     * @date 2019-06-02 21:07
     */
    @RequestMapping(value = {"register", ""})
    public String register(User user, Model model) {
        model.addAttribute("user", user);
        return "modules/user/register";
    }

    /**
     * 注册保存
     * @author Hacra
     * @date 2019-06-02 21:11
     */
    @RequestMapping(value = "save")
    public String save(User user, RedirectAttributes redirectAttributes) {
        userService.save(user);
        redirectAttributes.addFlashAttribute("user", user);
        redirectAttributes.addFlashAttribute("message", "注册成功！");
        return "redirect:/login/login";
    }
}
