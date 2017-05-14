package com.zhihu.mlw.entity;

/**
 * Created by pc on 17-5-13.
 */
public class ZhUser {
    public ZhUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * +------------+--------------+------+-----+---------+----------------+
     | Field      | Type         | Null | Key | Default | Extra          |
     +------------+--------------+------+-----+---------+----------------+
     | id         | int(11)      | NO   | PRI | NULL    | auto_increment |
     | userName   | varchar(50)  | YES  |     | NULL    |                |
     | password   | varchar(50)  | YES  |     | NULL    |                |
     | createTime | datetime     | YES  |     | NULL    |                |
     | address    | varchar(255) | YES  |     | NULL    |                |
     +------------+--------------+------+-----+---------+----------------+

     */

    private int id;
    private String username;
    private String password;
    private String createTime;
    private String address;

    public ZhUser() {
    }

    public ZhUser(int id, String username, String password, String createTime, String address) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.createTime = createTime;
        this.address = address;
    }

    public ZhUser(String username, String password, String createTime, String address) {
        this.username = username;
        this.password = password;
        this.createTime = createTime;
        this.address = address;
    }


    @Override
    public String toString() {
        return "ZhUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", createTime='" + createTime + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZhUser zhUser = (ZhUser) o;

        if (id != zhUser.id) return false;
        if (!username.equals(zhUser.username)) return false;
        if (!password.equals(zhUser.password)) return false;
        if (!createTime.equals(zhUser.createTime)) return false;
        return address.equals(zhUser.address);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + username.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + createTime.hashCode();
        result = 31 * result + address.hashCode();
        return result;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
