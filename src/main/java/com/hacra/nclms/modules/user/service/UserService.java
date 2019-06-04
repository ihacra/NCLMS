package com.hacra.nclms.modules.user.service;

import com.hacra.nclms.common.base.BaseService;
import com.hacra.nclms.common.utils.DateUtils;
import com.hacra.nclms.common.utils.StringUtils;
import com.hacra.nclms.modules.user.dao.UserDao;
import com.hacra.nclms.modules.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 用户管理
 *
 * @author Hacra
 * @version 1.0
 * @date 2019-06-02 20:19
 */
@Service
public class UserService extends BaseService<UserDao, User> {

    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * 通过id获取User
     * @author Hacra
     * @date 2019-06-02 21:04
     */
    public User get(String id) {
        return super.get(new User(id));
    }

    /**
     * 登录验证
     * @author Hacra
     * @date 2019-06-02 20:29
     */
    public User validate(User user) {
        User u = userDao.getUserByName(user);
        if (u == null || StringUtils.isBlank(u.getName()) || StringUtils.isBlank(u.getPassword())) {
            return null;
        }
        if (u.getPassword().equals(user.getPassword())) {
            return u;
        }
        return null;
    }

    /**
     * 注册信息
     * @author Hacra
     * @date 2019-06-04 16:28
     */
    public void saveRegister(User user) {
        user.setBirth(DateUtils.getDate("yyyy-MM-dd"));
        user.setGender("男");
        super.save(user);
    }

    /**
     * 获取当前登录用户
     * 全部信息：all
     * @author Hacra
     * @date 2019-06-03 0:46
     */
    public User getCurrUser(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            String id = (String) session.getAttribute("userid");
            return this.get(id);
        }
        return null;
    }

    /**
     * 获取当前登录用户
     * 简洁信息：id、name
     * @author Hacra
     * @date 2019-06-03 0:49
     */
    public User getCurrUserSimple(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            User user = new User();
            user.setId((String) session.getAttribute("userid"));
            user.setName((String) session.getAttribute("username"));
            user.setType((String) session.getAttribute("usertype"));
            return user;
        }
        return null;
    }

    /**
     * 当前是否为登录状态
     * @author Hacra
     * @date 2019-06-03 1:07
     */
    public boolean getLoginStatus(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        return session != null && StringUtils.isNotBlank((String) session.getAttribute("userid"));
    }

    /**
     * 保存登录状态
     * @author Hacra
     * @date 2019-06-02 20:32
     */
    public void saveStatus(User user, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.setAttribute("userid", user.getId());
        session.setAttribute("username", user.getName());
        session.setAttribute("usertype", user.getType());
    }

    /**
     * 清除登录状态
     * @author Hacra
     * @date 2019-06-03 0:43
     */
    public void clearStatus(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute("userid");
            session.removeAttribute("username");
            session.removeAttribute("usertype");
        }
    }
}
