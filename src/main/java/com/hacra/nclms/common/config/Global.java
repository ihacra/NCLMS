package com.hacra.nclms.common.config;

/**
 * 全局配置类
 *
 * @author Hacra
 * @version 1.0
 * @date 2019-03-02 16:43
 */
public class Global {

    private static final String DEFAULT_PREFIX = "/cms";
    private static final String MANAGE_PREFIX = "/sys";
    private static Global global = new Global();

    /**
     * 获取当前对象实例
     * @author Hacra
     * @date 2019-03-02 16:46
     * @return com.hacra.nclms.common.config.Global
     **/
    public static Global getInstance() {
        return global;
    }

    /**
     * 获取前端根路径
     * @author Hacra
     * @date 2019-03-04 19:24
     */
    public static String getDefaultPrefix() {
        return DEFAULT_PREFIX;
    }

    /**
     * 获取管理根路径
     * @author Hacra
     * @date 2019-03-04 19:24
     */
    public static String getManagePrefix() {
        return MANAGE_PREFIX;
    }
}
