package person.liufan.student.management.entity;

import java.util.Date;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/26
 * Id 字符串类型长度 40,
 * 姓名 (name)字符串类型长度 40,
 * 出生日期(birthday) 日期类型,
 * 备注 (description)字符串类型长度 255,
 * 平均分(avgscore) 整数类型,
 */
public class Student {
    /**
     * 学生id
     */
    private String id;
    /**
     * 学生姓名
     */
    private String name;
    /**
     * 学生生日
     */
    private Date birthday;
    /**
     * 学生备注
     */
    private String description;
    /**
     * 学生平均分
     */
    private Integer avgScore;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(Integer avgScore) {
        this.avgScore = avgScore;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", description='" + description + '\'' +
                ", avgScore=" + avgScore +
                '}';
    }
}
