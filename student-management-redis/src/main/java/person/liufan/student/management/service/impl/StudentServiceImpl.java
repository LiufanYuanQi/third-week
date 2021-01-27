package person.liufan.student.management.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import person.liufan.student.management.entity.Student;
import person.liufan.student.management.jedis.StudentJedis;
import person.liufan.student.management.service.StudentService;
import person.liufan.student.management.vo.StudentVO;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/27
 */
public class StudentServiceImpl implements StudentService {

    private StudentJedis jedis = new StudentJedis();

    @Override
    public Boolean save(StudentVO vo) throws ParseException, JsonProcessingException {
        Student student = toStudent(vo);
        student.setId(String.valueOf(UUID.randomUUID()));
        Boolean flag = jedis.insertStudent(student);
        return flag;
    }

    @Override
    public List<Student> listStudent(StudentVO vo) throws IOException {
        return jedis.listStudent(Integer.valueOf(vo.getPageSize()),Integer.valueOf(vo.getPageNum()));
    }

    @Override
    public String queryCount() {
        return String.valueOf(jedis.queryCount());
    }

    @Override
    public Student queryById(StudentVO vo) throws IOException {
        List<Student> list = listStudent(vo);
        for (Student student : list) {
            if (vo.getId().equals(student.getId())) {
                return student;
            }
        }
        return null;
    }

    @Override
    public Boolean updateById(StudentVO vo) throws IOException, ParseException {
        Student student = queryById(vo);
        jedis.delete(student);
        jedis.insertStudent(toStudent(vo));
        return true;
    }

    @Override
    public Boolean deleteById(StudentVO vo) throws IOException {
        List<Student> list = listStudent(vo);
        String para = vo.getDeleteList();
        String[] ids = para.split("&");
        for (Student student : list) {
            for (int i = 0; i < ids.length; i++) {
                if (ids[i].equals(student.getId())) {
                    jedis.delete(student);
                }
            }
        }
        return true;
    }

    private Student toStudent(StudentVO vo) throws ParseException {
        Student student = new Student();
        if (vo.getId() != null) {
            student.setId(vo.getId());
        }
        if (vo.getName() != null) {
            student.setName(vo.getName());
        }
        if (vo.getDescription() != null) {
            student.setDescription(vo.getDescription());
        }
        if (vo.getAvgScore() != null) {
            student.setAvgScore(Integer.valueOf(vo.getAvgScore()));
        }
        if (vo.getBirthday() != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            student.setBirthday(sdf.parse(vo.getBirthday()));
            student.setBirthdayString(vo.getBirthday());
        }
        return student;
    }
}
