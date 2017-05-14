package dao;

import entity.Admin;

/**
 * Created by pc on 17-5-13.
 */
public interface AdminDao {
    /**
     * 数据库查询，用户信息查询
     */
    boolean QueryAdmin(Admin admin);

    /**
     * 保存用户注册信息
     */
    void SaveAdmin(Admin admin);

    /**
     * 查询用户与密码是否输入正确
     */
    boolean LoginAdmin(Admin admin);
}
