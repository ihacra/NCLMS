package com.hacra.nclms.modules.library.web;

import com.hacra.nclms.common.base.BaseController;
import com.hacra.nclms.common.config.Global;
import com.hacra.nclms.common.utils.StringUtils;
import com.hacra.nclms.modules.library.entity.Library;
import com.hacra.nclms.modules.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 第三方库Controller
 *
 * @author Hacra
 * @version 1.0
 * @date 2019-03-06 15:57
 */
@Controller
@RequestMapping(value = "${managePath}/library")
public class LibraryController extends BaseController {

    @Autowired
    private LibraryService libraryService;

    /**
     * 参数拦截
     * @author Hacra
     * @date 2019-03-09 22:33
     */
    @ModelAttribute
    public Library get(@RequestParam(required = false) String id) {
        if (StringUtils.isNotBlank(id)) {
            return libraryService.get(id);
        }
        return new Library();
    }

    /**
     * 查询列表
     * @author Hacra
     * @date 2019-03-06 16:02
     */
    @RequestMapping(value = {"list", ""})
    public String list(Library library, HttpServletRequest request, HttpServletResponse response, Model model) {
        model.addAttribute("libraryList", libraryService.getAllList(library));
        return "modules/library/libraryList";
    }

    /**
     * 添加修改方法
     * @author Hacra
     * @date 2019-03-09 18:50
     */
    @RequestMapping(value = "form")
    public String form(Library library, Model model) {
        model.addAttribute("library", library);
        return "modules/library/libraryForm";
    }

    /**
     * 保存方法
     * @author Hacra
     * @date 2019-03-09 19:04
     */
    @RequestMapping(value = "save")
    public String save(Library library, HttpServletRequest request, HttpServletResponse response, Model model) {
        libraryService.save(library);
        return "redirect:" + Global.getManagePath() + "/library/list";
    }

    /**
     * 删除方法
     * @author Hacra
     * @date 2019-03-09 21:27
     */
    @RequestMapping(value = "delete")
    public String delete(Library library, HttpServletRequest request, HttpServletResponse response, Model model) {
        libraryService.delete(library);
        return "redirect:" + Global.getManagePath() + "/library/list";
    }
}
