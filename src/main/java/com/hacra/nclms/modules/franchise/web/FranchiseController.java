package com.hacra.nclms.modules.franchise.web;

import com.hacra.nclms.common.base.BaseController;
import com.hacra.nclms.common.config.Global;
import com.hacra.nclms.common.utils.LoginUtils;
import com.hacra.nclms.common.utils.StringUtils;
import com.hacra.nclms.modules.franchise.entity.Franchise;
import com.hacra.nclms.modules.franchise.service.FranchiseService;
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
 * 加盟合作
 *
 * @author Hacra
 * @version 1.0
 * @date 2019-05-01 17:56
 */
@Controller
@RequestMapping(value = "/franchise")
public class FranchiseController extends BaseController {

    private final UserService userService;
    private final FranchiseService franchiseService;

    @Autowired
    public FranchiseController(FranchiseService franchiseService, UserService userService) {
        this.franchiseService = franchiseService;
        this.userService = userService;
    }

    /**
     * 参数拦截
     * @author Hacra
     * @date 2019-05-01 18:01
     */
    @ModelAttribute
    public Franchise get(@RequestParam(required = false) String id) {
        if (StringUtils.isNotBlank(id)) {
            return franchiseService.get(id);
        }
        return new Franchise();
    }

    /**
     * 加盟列表
     * @author Hacra
     * @date 2019-06-03 15:48
     */
    @RequestMapping(value = "list")
    public String list(Franchise franchise, Model model, HttpServletRequest request) {
        String view = LoginUtils.validate(Global.USER_TYPE_NORMAL, request);
        if (StringUtils.isNotBlank(view)) {
            return view;
        }
        User user = userService.getCurrUserSimple(request);
        franchise.setUserId(user.getId());
        List<Franchise> franchiseList = franchiseService.getAllList(franchise);
        model.addAttribute("franchiseList", franchiseList);
        return "modules/franchise/list";
    }

    /**
     * 加盟合作
     * @author Hacra
     * @date 2019-05-01 18:03
     */
    @RequestMapping(value = {"form", ""})
    public String form(Franchise franchise, Model model, HttpServletRequest request) {
        String view = LoginUtils.validate(Global.USER_TYPE_NORMAL, request);
        if (StringUtils.isNotBlank(view)) {
            return view;
        }
        model.addAttribute("franchise", franchise);
        return "modules/franchise/form";
    }

    /**
     * 查看信息
     * @author Hacra
     * @date 2019-05-01 18:04
     */
    @RequestMapping(value = "view")
    public String view(Franchise franchise, @ModelAttribute(value = "message") String message, Model model, HttpServletRequest request) {
        String view = LoginUtils.validate(Global.USER_TYPE_NORMAL, request);
        if (StringUtils.isNotBlank(view)) {
            return view;
        }
        model.addAttribute("franchise", franchise);
        model.addAttribute("message", message);
        return "modules/franchise/view";
    }

    /**
     * 保存方法
     * @author Hacra
     * @date 2019-05-01 18:19
     */
    @RequestMapping(value = "save")
    public String save(Franchise franchise, RedirectAttributes redirectAttributes, HttpServletRequest request) {
        String view = LoginUtils.validate(Global.USER_TYPE_NORMAL, request);
        if (StringUtils.isNotBlank(view)) {
            return view;
        }
        franchiseService.save(franchise, request);
        redirectAttributes.addFlashAttribute("franchise", franchise);
        redirectAttributes.addFlashAttribute("message", "加盟信息提交成功！");
        return "redirect:/franchise/view";
    }

    /**
     * 删除方法
     * @author Hacra
     * @date 2019-05-01 18:22
     */
    @RequestMapping(value = "delete")
    public String delete(Franchise franchise, HttpServletRequest request) {
        String view = LoginUtils.validate(Global.USER_TYPE_NORMAL, request);
        if (StringUtils.isNotBlank(view)) {
            return view;
        }
        franchiseService.delete(franchise);
        return "redirect:/franchise/form";
    }
}
