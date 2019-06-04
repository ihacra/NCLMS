package com.hacra.nclms.common.config;

/**
 * 全局配置类
 *
 * @author Hacra
 * @version 1.0
 * @date 2019-03-02 16:43
 */
public class Global {

    private static Global global = new Global();

    public static String USER_TYPE_ADMIN =  "管理员";
    public static String USER_TYPE_NORMAL = "普通用户";

    /**
     * 获取当前对象实例
     * @author Hacra
     * @date 2019-03-02 16:46
     * @return com.hacra.nclms.common.config.Global
     **/
    public static Global getInstance() {
        return global;
    }
}
