package com.hacra.nclms.common.utils;

import com.hacra.nclms.common.config.Global;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 登录用户类型验证
 *
 * 普通用户 - /index/index
 * 管理员 - /admin/index/index
 *
 * @author Hacra
 * @version 1.0
 * @date 2019-06-04 12:05
 */
public class LoginUtils {

    /**
     * 验证登录用户类型并跳转至相应页面
     * @author Hacra
     * @date 2019-06-04 12:08
     */
    public static String validate(String type, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            String userType = (String) session.getAttribute("usertype");
            if (Global.USER_TYPE_NORMAL.equals(type) && Global.USER_TYPE_ADMIN.equals(userType)){
                return "redirect:/admin/index/index";
            } else if (Global.USER_TYPE_ADMIN.equals(type) && Global.USER_TYPE_NORMAL.equals(userType)) {
                return "redirect:/index/index";
            }
        } else {
            if (Global.USER_TYPE_ADMIN.equals(type)) {
                return "redirect:/index/index";
            }
        }
        return null;
    }
}
