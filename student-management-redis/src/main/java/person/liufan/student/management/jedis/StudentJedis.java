package person.liufan.student.management.jedis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import person.liufan.student.management.entity.Student;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/26
 */
public class StudentJedis {
    private Jedis jedis = new Jedis("39.102.34.91", 6379);
    private ObjectMapper om = new ObjectMapper();

    public Boolean insertStudent(Student student) throws JsonProcessingException {
        jedis.zadd("student", student.getAvgScore(), om.writeValueAsString(student));
        return true;
    }

    public List<Student> listStudent(Integer pageSize,Integer pageNum) throws IOException {
        List<Student> students = new ArrayList<>();
        Set set = jedis.zrevrangeByScore("student", 100, 0, pageSize * (pageNum - 1), pageSize * pageNum);
        for (Object obj : set) {
            Student student = om.readValue(obj.toString(), Student.class);
            students.add(student);
        }
        return students;
    }

}
