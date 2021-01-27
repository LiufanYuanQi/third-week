package person.liufan.student.management.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/13
 *
 * 封装响应网页的工具类
 */
public class MyPrintOut {
    /**
     * 将object对象转换为json数据输出
     * @param response 浏览器响应对象
     * @param object 转换为json对象
     */
    public static void printJson(HttpServletResponse response, Object object) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        ObjectMapper om = new ObjectMapper();
        String json = "{}";
        try {
            json = om.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        writer.println(json);
    }

}
