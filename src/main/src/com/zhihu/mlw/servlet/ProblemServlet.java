package com.zhihu.mlw.servlet;


import com.zhihu.mlw.dao.ZhProblemDao;
import com.zhihu.mlw.dao.impl.ZhProblemDaoImpl;
import com.zhihu.mlw.entity.ZhProblem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by pc on 17-5-14.
 */
@WebServlet("/problem")
public class ProblemServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        int op = Integer.parseInt(req.getParameter("op"));
        switch (op) {
            case 1:
                question_add(req, resp);
                break;
            case 2:
                question_rep(req, resp);
                break;
        }

    }

    /**
     * 添加问题
     *
     * @param req
     * @param resp
     */
    public void question_add(HttpServletRequest req, HttpServletResponse resp) {
        String title = req.getParameter("title");
        System.out.println(title);
        String content = req.getParameter("content");
        int userId = req.getIntHeader("userId");
        String addTime = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss").format(new Date());
        ZhProblem zhProblem = new ZhProblem(title, content, userId, addTime);
        ZhProblemDao zhProblemDao = new ZhProblemDaoImpl();
        zhProblemDao.saveProblem_add(zhProblem);

    }

    /**
     * 添加问题答案
     *
     * @param req
     * @param resp
     */
    public void question_rep(HttpServletRequest req, HttpServletResponse resp) {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
