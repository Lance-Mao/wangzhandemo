package com.zhihu.mlw.entity;

/**
 * Created by pc on 17-5-13.
 */

/**
 * +---------+----------+------+-----+---------+----------------+
 | Field   | Type     | Null | Key | Default | Extra          |
 +---------+----------+------+-----+---------+----------------+
 | id      | int(11)  | NO   | PRI | NULL    | auto_increment |
 | content | longtext | YES  |     | NULL    |                |
 | addTime | datetime | YES  |     | NULL    |                |
 +---------+----------+------+-----+---------+----------------+

 */
public class ZhAnswer {
    private int id;
    private String content;
    private String addTime;

    @Override
    public String toString() {
        return "ZhAnswer{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", addTime='" + addTime + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZhAnswer zhAnswer = (ZhAnswer) o;

        if (id != zhAnswer.id) return false;
        if (content != null ? !content.equals(zhAnswer.content) : zhAnswer.content != null) return false;
        return addTime != null ? addTime.equals(zhAnswer.addTime) : zhAnswer.addTime == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (addTime != null ? addTime.hashCode() : 0);
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }
}
