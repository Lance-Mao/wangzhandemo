package com.zhihu.mlw.dao.impl;

import com.zhihu.mlw.dao.ZhProblemDao;
import com.zhihu.mlw.entity.ZhProblem;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by pc on 17-5-13.
 */
public class ZhProblemDaoImpl implements ZhProblemDao {

    public void saveProblem_add(ZhProblem zhProblem) {
        Connection conn = DBConnection.getConn();
        String sql = "insert into zh_problem(title,content,userId,addTime) values(?,?,?,?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, String.valueOf(zhProblem.getTitle()));
            stmt.setString(2, String.valueOf(zhProblem.getContent()));
            stmt.setString(3, String.valueOf(zhProblem.getUserId()));
            stmt.setString(4, String.valueOf(zhProblem.getAddTime()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
