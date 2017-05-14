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
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String username = req.getParameter("username");
        String pwd = req.getParameter("pwd");
        Admin admin = new Admin();
        admin.setUsername(username);
        admin.setPwd(pwd);
        AdminDao adminDao = new AdminDaoImpl();
        if (adminDao.QueryAdmin(admin)) {
            req.setAttribute("info","登录成功！");
            req.getRequestDispatcher("/admin/message.jsp").forward(req, resp);
        }else {
            req.setAttribute("info","登录失败！");
            req.getRequestDispatcher("/admin/login.jsp").forward(req, resp);
        }
    }
}
