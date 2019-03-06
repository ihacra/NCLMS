package com.hacra.nclms.modules.sysmenu.web;

import com.hacra.nclms.common.base.BaseController;
import com.hacra.nclms.common.config.Global;
import com.hacra.nclms.modules.sysmenu.entity.SysMenu;
import com.hacra.nclms.modules.sysmenu.service.SysMenuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 系统菜单Controller
 *
 * @author Hacra
 * @version 1.0
 * @date 2019-03-02 20:36
 */
@Controller
@RequestMapping(value = "${manage.prefix}/sysmenu")
public class SysMenuController extends BaseController {

    @Resource
    private SysMenuService sysMenuService;

    /**
     * 菜单查看
     * @author Hacra
     * @date 2019-03-02 23:37
     */
    @RequestMapping(value = {"list", ""})
    public String list(SysMenu sysMenu, HttpServletRequest request, HttpServletResponse response, Model model) {
        List<SysMenu> list = sysMenuService.getAllList(sysMenu);
        model.addAttribute("list", list);
        return "modules/sysmenu/sysMenuList";
    }

    /**
     * 菜单添加
     * @author Hacra
     * @date 2019-03-03 2:28
     */
    @RequestMapping(value = "form")
    public String form(SysMenu sysMenu, HttpServletRequest request, HttpServletResponse response, Model model) {
        return "modules/sysmenu/sysMenuForm";
    }

    /**
     * 菜单保存
     * @author Hacra
     * @date 2019-03-03 2:35
     */
    @RequestMapping(value = "save")
    public String save(SysMenu sysMenu, HttpServletRequest request, HttpServletResponse response, Model model) {
        sysMenuService.save(sysMenu);
        return "redirect:" + Global.getManagePrefix() + "/sysmenu/list";
    }
}
