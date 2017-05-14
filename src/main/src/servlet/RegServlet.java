package servlet;

import dao.AdminDao;
import dao.impl.AdminDaoImpl;
import entity.Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by pc on 17-5-13.
 */
@WebServlet("/RegServlet")
public class RegServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置字符编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String username = req.getParameter("username");
        String pwd = req.getParameter("pwd");
        Admin admin = new Admin();
        admin.setUsername(username);
        admin.setPwd(pwd);
        AdminDao adminDao = new AdminDaoImpl();
        if (adminDao.QueryAdmin(admin)) {
            adminDao.SaveAdmin(admin);
            req.setAttribute("info", "注册成功，请登录。");
            req.getRequestDispatcher("/admin/login.jsp");
        }else {
            req.setAttribute("info", "请按正确格式填写！");
            req.getRequestDispatcher("/admin/reg.jsp");
        }
    }
}
