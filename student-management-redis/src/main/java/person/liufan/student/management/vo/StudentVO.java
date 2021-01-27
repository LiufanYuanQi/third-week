package person.liufan.student.management.vo;

import person.liufan.student.management.entity.Student;

import java.util.List;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/26
 */
public class StudentVO {
    /**
     * id
     */
    private String id;
    /**
     * name
     */
    private String name;
    /**
     * 备注
     */
    private String description;
    /**
     * 平均成绩
     */
    private String avgScore;
    /**
     * 生日
     */
    private String birthday;
    /**
     * 每页大小
     */
    private String pageSize;
    /**
     * 当前页面
     */
    private String pageNum;
    /**
     * 总数
     */
    private String count;
    /**
     * 删除id
     */
    private String deleteList;
    /**
     * 分页学生列表
     */
    private List<Student> list;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(String avgScore) {
        this.avgScore = avgScore;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getPageNum() {
        return pageNum;
    }

    public void setPageNum(String pageNum) {
        this.pageNum = pageNum;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getDeleteList() {
        return deleteList;
    }

    public void setDeleteList(String deleteList) {
        this.deleteList = deleteList;
    }

    public List<Student> getList() {
        return list;
    }

    public void setList(List<Student> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "StudentVO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", avgScore='" + avgScore + '\'' +
                ", birthday='" + birthday + '\'' +
                ", pageSize='" + pageSize + '\'' +
                ", pageNum='" + pageNum + '\'' +
                ", count='" + count + '\'' +
                ", deleteList='" + deleteList + '\'' +
                ", list=" + list +
                '}';
    }
}
