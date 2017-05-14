package com.zhihu.mlw.entity;

/**
 * Created by pc on 17-5-13.
 */



/**
 * +---------+--------------+------+-----+---------+----------------+
 | Field   | Type         | Null | Key | Default | Extra          |
 +---------+--------------+------+-----+---------+----------------+
 | id      | int(11)      | NO   | PRI | NULL    | auto_increment |
 | title   | varchar(255) | YES  |     | NULL    |                |
 | content | longtext     | YES  |     | NULL    |                |
 | userId  | int(11)      | YES  |     | NULL    |                |
 | addTime | datetime     | YES  |     | NULL    |                |
 +---------+--------------+------+-----+---------+----------------+

 */
public class ZhProblem {
    private int id;
    private String title;
    private String content;
    private int userId;
    private String addTime;


    public ZhProblem(String title, String content, int userId, String addTime) {
        this.title = title;
        this.content = content;
        this.userId = userId;
        this.addTime = addTime;
    }



    @Override
    public java.lang.String toString() {
        return "ZhProblem{" +
                "id=" + id +
                ", title=" + title +
                ", content=" + content +
                ", userId=" + userId +
                ", addTime=" + addTime +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZhProblem zhProblem = (ZhProblem) o;

        if (id != zhProblem.id) return false;
        if (userId != zhProblem.userId) return false;
        if (!title.equals(zhProblem.title)) return false;
        if (!content.equals(zhProblem.content)) return false;
        return addTime.equals(zhProblem.addTime);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + title.hashCode();
        result = 31 * result + content.hashCode();
        result = 31 * result + userId;
        result = 31 * result + addTime.hashCode();
        return result;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }
}
