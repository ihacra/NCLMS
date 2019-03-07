package com.hacra.nclms.modules.menu.web;

import com.hacra.nclms.common.base.BaseController;
import com.hacra.nclms.modules.menu.entity.Menu;
import com.hacra.nclms.modules.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 菜单Controller
 *
 * @author Hacra
 * @version 1.0
 * @date 2019-03-06 17:56
 */
@Controller
@RequestMapping(value = "${manage.prefix}/menu")
public class MenuController extends BaseController {

    @Autowired
    private MenuService menuService;

    /**
     * 菜单列表
     * @author Hacra
     * @date 2019-03-06 17:58
     */
    @RequestMapping(value = {"list", ""})
    public String list(Menu menu, HttpServletRequest request, HttpServletResponse response, Model model) {
        return "modules/menu/list";
    }
}
