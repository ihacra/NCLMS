package com.hacra.nclms.modules.freight.web;

import com.hacra.nclms.common.base.BaseController;
import com.hacra.nclms.common.utils.DateUtils;
import com.hacra.nclms.common.utils.StringUtils;
import com.hacra.nclms.modules.freight.entity.Freight;
import com.hacra.nclms.modules.freight.service.FreightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 运费查询
 *
 * @author Hacra
 * @version 1.0
 * @date 2019-05-01 15:06
 */
@Controller
@RequestMapping(value = "/freight")
public class FreightController extends BaseController {

    private final FreightService freightService;

    @Autowired
    public FreightController(FreightService freightService) {
        this.freightService = freightService;
    }

    /**
     * 运费查询
     * @author Hacra
     * @date 2019-05-01 16:27
     */
    @RequestMapping(value = {"search", ""})
    public String search(Freight freight, Model model) {
        if (StringUtils.isNotBlank(freight.getSenderAddress())
                && StringUtils.isNotBlank(freight.getConsigneeAddress())) {
            freight = freightService.count(freight);
        } else {
            freight.setOrderTime(DateUtils.getDate("yyyy-MM-dd"));
        }
        model.addAttribute("freight", freight);
        return "modules/freight/search";
    }
}
