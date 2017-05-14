package dao.impl;

import dao.AdminDao;
import entity.Admin;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by pc on 17-5-13.
 */
public class AdminDaoImpl implements AdminDao {
    public boolean QueryAdmin(Admin admin) {
        Connection conn = DBConnection.getConn();
        String sql = "select * from admin where username = ? and pwd = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, admin.getUsername());
            ps.setString(2, admin.getPwd());
            ResultSet rs = ps.executeQuery();
            while (!rs.next()) {
                return true;
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConn(conn);
        }

        return false;
    }

    public void SaveAdmin(Admin admin) {
        Connection conn = DBConnection.getConn();
        String sql = "insert into admin(username,pwd) values(?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, admin.getUsername());
            ps.setString(2, admin.getPwd());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConn(conn);
        }
    }

    public boolean LoginAdmin(Admin admin) {
        Connection conn = DBConnection.getConn();
        String sql = "select * from admin where username = ? and pwd = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, admin.getUsername());
            ps.setString(2, admin.getPwd());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
