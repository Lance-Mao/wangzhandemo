package com.zhihu.mlw.dao.impl;

import com.zhihu.mlw.dao.ZhUserDao;
import com.zhihu.mlw.entity.ZhUser;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by pc on 17-5-13.
 */
public class ZhUserDaoImpl implements ZhUserDao {
    public List<ZhUser> findByUserName(ZhUser zhUser) throws Exception {
        Connection conn = DBConnection.getConn();
        String findSql = "select * from zh_user where userName='" + zhUser.getUsername() + "'";
        PreparedStatement stmt = conn.prepareStatement(findSql);
        ResultSet rs = stmt.executeQuery();
        List<ZhUser> zhUserList = new ArrayList<ZhUser>();
        if (rs.next()) {
            ZhUser user = new ZhUser(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            zhUserList.add(user);
        }
        return zhUserList;
    }

    public boolean saveUser(ZhUser zhUser) {
        Connection conn = DBConnection.getConn();
        String sql = "insert into zh_user(userName,password,createTime,address) values(?,?,?,?)";
        String sql1 = "select * from zh_user where userName = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql1);
            stmt.setString(1, zhUser.getUsername());
            ResultSet rs = stmt.executeQuery();
            if (!rs.next()) {
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, zhUser.getUsername());
                stmt.setString(2, zhUser.getPassword());
                stmt.setString(3,zhUser.getCreateTime());
                stmt.setString(4,zhUser.getAddress());
                stmt.executeUpdate();
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
