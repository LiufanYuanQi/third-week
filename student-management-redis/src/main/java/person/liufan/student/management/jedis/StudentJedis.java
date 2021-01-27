package person.liufan.student.management.jedis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import person.liufan.student.management.entity.Student;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/26
 */
public class StudentJedis {
    private static final String STUDENT = "student";
    private static final String REDIS_HOST = "39.102.34.91";
    private Jedis jedis = new Jedis(REDIS_HOST, 6379);
    private ObjectMapper om = new ObjectMapper();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public Boolean insertStudent(Student student) throws JsonProcessingException {
        student.setBirthdayString(sdf.format(student.getBirthday()));
        jedis.zadd(STUDENT, student.getAvgScore(), om.writeValueAsString(student));
        return true;
    }
    public List<Student> listStudent(Integer pageSize, Integer pageNum) throws IOException {
        List<Student> students = new ArrayList<>();
        Set set = jedis.zrevrangeByScore(STUDENT, 100, 0, pageSize * (pageNum - 1), pageSize);
        for (Object obj : set) {
            Student student = om.readValue(obj.toString(), Student.class);
            students.add(student);
        }
        return students;
    }

    public Boolean delete(Student student) throws JsonProcessingException {
        jedis.zrem(STUDENT, om.writeValueAsString(student));
        return true;
    }

    public Student queryStudentByIdAndScore(String id, Integer avgScore) throws IOException {
        Set set = jedis.zrange(STUDENT, avgScore, avgScore);
        for (Object obj : set) {
            Student student = om.readValue(obj.toString(), Student.class);
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    public Long queryCount() {
        Long count = jedis.zcard(STUDENT);
        return count;
    }

}
