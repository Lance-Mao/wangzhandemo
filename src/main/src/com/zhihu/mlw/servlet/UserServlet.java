package com.zhihu.mlw.servlet;

import com.zhihu.mlw.dao.ZhUserDao;
import com.zhihu.mlw.dao.impl.ZhUserDaoImpl;
import com.zhihu.mlw.entity.ZhUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pc on 17-5-13.
 */
@WebServlet("/user")
public class UserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        res.setContentType("text/html;charset=utf-8");
        int op = Integer.parseInt(req.getParameter("op"));
        switch (op) {
            case 1:
                login(req, res);
                break;
            case 2:
                register(req, res);
                break;
        }


    }

    /**
     * 登录
     */
    private void login(HttpServletRequest req, HttpServletResponse res) {
        Map<String, Object> result = new HashMap<String, Object>();
        ZhUserDao userDao = new ZhUserDaoImpl();
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        ZhUser zhUser = new ZhUser(userName, password);
        try {
            List<ZhUser> userList = userDao.findByUserName(zhUser);
            if (!userList.isEmpty()) {
                if (userList.get(0).getPassword().equals(zhUser.getPassword())) {
                    req.getSession().setAttribute("user", userList.get(0));
                    result.put("\"success\"", true);
                    result.put("\"msg\"", "\"登录成功！\"");
                } else {
                    result.put("\"success\"", false);
                    result.put("\"msg\"", "\"密码错误！\"");

                }
            } else {
                result.put("\"success\"", false);
                result.put("\"msg\"", "\"用户不存在！\"");
            }
            res.getWriter().write(String.valueOf(result));
        } catch (Exception e) {
            result.put("\"success\"", false);
            result.put("\"msg\"", "登录出错！");
            try {
                res.getWriter().print(result);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }

    }

    /**
     * 注册
     */
    private void register(HttpServletRequest req, HttpServletResponse res) {

        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        String address = req.getParameter("address");
        String createTime = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss").format(new Date());
        ZhUser zhUser = new ZhUser(userName, password,createTime, address);
        ZhUserDao zhUserDao = new ZhUserDaoImpl();
        Map<String, Object> result = new HashMap<String, Object>();
        if (zhUserDao.saveUser(zhUser)) {
            result.put("\"success\"", true);
            result.put("\"msg\"", "\"注册成功！\"");
        } else {
            result.put("\"success\"", false);
            result.put("\"msg\"", "\"注册失败,用户名已经存在！\"");
        }
        try {
            res.getWriter().write(String.valueOf(result));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        this.doPost(req, res);
    }
}
