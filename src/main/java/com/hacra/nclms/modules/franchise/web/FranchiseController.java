package com.hacra.nclms.modules.franchise.web;

import com.hacra.nclms.common.base.BaseController;
import com.hacra.nclms.common.utils.StringUtils;
import com.hacra.nclms.modules.franchise.entity.Franchise;
import com.hacra.nclms.modules.franchise.service.FranchiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    private FranchiseService franchiseService;

    @Autowired
    public void setFranchiseService(FranchiseService franchiseService) {
        this.franchiseService = franchiseService;
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
     * 加盟合作
     * @author Hacra
     * @date 2019-05-01 18:03
     */
    @RequestMapping(value = {"form", ""})
    public String form(Franchise franchise, Model model) {
        model.addAttribute("franchise", franchise);
        return "modules/franchise/form";
    }

    /**
     * 查看信息
     * @author Hacra
     * @date 2019-05-01 18:04
     */
    @RequestMapping(value = "view")
    public String view(Franchise franchise, Model model) {
        model.addAttribute("franchise", franchise);
        return "modules/franchise/view";
    }

    /**
     * 保存方法
     * @author Hacra
     * @date 2019-05-01 18:19
     */
    @RequestMapping(value = "save")
    public String save(Franchise franchise) {
        franchiseService.save(franchise);
        return "redirect:/franchise/view?id=" + franchise.getId();
    }

    /**
     * 删除方法
     * @author Hacra
     * @date 2019-05-01 18:22
     */
    @RequestMapping(value = "delete")
    public String delete(Franchise franchise) {
        franchiseService.delete(franchise);
        return "redirect:/franchise/form";
    }
}
