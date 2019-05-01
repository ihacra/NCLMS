package com.hacra.nclms.modules.freight.service;

import com.hacra.nclms.modules.freight.entity.Freight;
import org.springframework.stereotype.Service;

/**
 * 运费查询
 *
 * @author Hacra
 * @version 1.0
 * @date 2019-05-01 16:34
 */
@Service
public class FreightService {

    /**
     * 运费计算
     * @author Hacra
     * @date 2019-05-01 16:36
     */
    public Freight count(Freight freight) {
        freight.setPrice((int)(1+Math.random()*30));
        return freight;
    }
}
