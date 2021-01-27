package person.liufan.student.management.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import person.liufan.student.management.entity.Student;
import person.liufan.student.management.vo.StudentVO;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/27
 */
public interface StudentService {

    /**

     *
     */
    /**
     * 保存前端发来的数据
     * type: save
     * name: 刘凡
     * description: liufanTest
     * avgScore: 150
     * birthday: 2020-01-27
     * @param vo 数据
     * @return 保存结果
     * @throws ParseException 日期解析异常
     * @throws JsonProcessingException json转换异常
     */
    Boolean save(StudentVO vo) throws ParseException, JsonProcessingException;

    /**
     * 根据分页数据返回结果
     * type: listDetail
     * pageNum: 1
     * pageSize: 3
     * @param vo 数据
     * @return 保存结果
     * @throws IOException 连接redis异常
     */
    List<Student> listStudent(StudentVO vo) throws IOException;

    /**
     * 查询总数
     * @return 总数
     */
    String queryCount();

    /**
     * 通过分页定位，通过id查询记录
     * @param vo 条件
     * @return 结果
     * @throws IOException io异常
     */
    Student queryById(StudentVO vo) throws IOException;

    /**
     * 通过id进行更新数据，先删除，再插入
     * @param vo 记录
     * @return 结果
     * @throws IOException io异常
     * @throws ParseException 解析异常
     */
    Boolean updateById(StudentVO vo) throws IOException, ParseException;

    /**
     * 通过ids进行删除
     * @param vo 数据
     * @return 操作结果
     * @throws IOException io异常
     */
    Boolean deleteById(StudentVO vo) throws IOException;
}
