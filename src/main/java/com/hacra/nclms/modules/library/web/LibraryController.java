package com.hacra.nclms.modules.library.web;

import com.hacra.nclms.common.base.BaseController;
import com.hacra.nclms.modules.library.entity.Library;
import com.hacra.nclms.modules.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
@RequestMapping(value = "${manage.prefix}/library")
public class LibraryController extends BaseController {

    @Autowired
    private LibraryService libraryService;

    /**
     * 查询列表
     * @author Hacra
     * @date 2019-03-06 16:02
     */
    @RequestMapping(value = {"list", ""})
    public String list(Library library, HttpServletRequest request, HttpServletResponse response, Model model) {
        return "modules/library/list";
    }
}
