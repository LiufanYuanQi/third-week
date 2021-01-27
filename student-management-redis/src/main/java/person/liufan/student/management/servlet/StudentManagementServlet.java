package person.liufan.student.management.servlet;

import person.liufan.student.management.entity.Student;
import person.liufan.student.management.service.StudentService;
import person.liufan.student.management.service.impl.StudentServiceImpl;
import person.liufan.student.management.util.MyPrintOut;
import person.liufan.student.management.vo.StudentVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.UUID;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/26
 */
public class StudentManagementServlet extends HttpServlet {
    private StudentService studentService = new StudentServiceImpl();
    private static final String TYPE = "type";
    private static final String TYPE_SAVE = "save";
    private static final String TYPE_QUERY_BY_ID = "queryById";
    private static final String TYPE_UPDATE = "update";
    private static final String TYPE_DELETE = "delete";
    private static final String TYPE_LIST_DETAIL = "listDetail";

    private static final String PARA_ID = "id";
    private static final String PARA_NAME = "name";
    private static final String PARA_DESCRIPTION = "description";
    private static final String PARA_AVG_SCORE = "avgScore";
    private static final String PARA_BIRTHDAY = "birthday";
    private static final String PARA_PAGE_SIZE = "pageSize";
    private static final String PARA_PAGE_NUM = "pageNum";
    private static final String PARA_DELETE_LIST = "deleteList";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter(TYPE);
        StudentVO vo = toStudentVO(request);
        /**
         * type: save
         * name: 刘凡
         * description: liufanTest
         * avgScore: 150
         * birthday: 2020-01-27
         */
        if (TYPE_SAVE.equals(type)) {
            Boolean flag = null;
            try {
                flag = studentService.save(vo);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            MyPrintOut.printJson(response, flag);
        }
        /**
         * type: update
         * id: xxx
         * name: 刘凡
         * description: liufanTest
         * avgScore: 40
         * birthday: 2020-01-27
         * pageSize: 10
         * pageNum: 1
         */
        if (TYPE_UPDATE.equals(type)) {
            Boolean flag = null;
            try {
                flag = studentService.updateById(vo);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            MyPrintOut.printJson(response, flag);
        }
        /**
         * type: delete
         * deleteList: x&x&x
         * pageSize: 10
         * pageNum: 1
         */
        if (TYPE_DELETE.equals(type)) {
            Boolean flag = studentService.deleteById(vo);
            MyPrintOut.printJson(response, flag);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter(TYPE);
        StudentVO vo = toStudentVO(request);
        /**
         * type: queryById
         * id: 403e4e49-2b31-435a-a4d8-882806a81fde
         * pageSize: 10
         * pageNum: 1
         */
        if (TYPE_QUERY_BY_ID.equals(type)) {
            Student student = studentService.queryById(vo);
            MyPrintOut.printJson(response, student);
        }
        /**
         * type: listDetail
         * pageNum: 1
         * pageSize: 3
         */
        if (TYPE_LIST_DETAIL.equals(type)) {
            List<Student> list = studentService.listStudent(vo);
            String count = studentService.queryCount();
            StudentVO rest = new StudentVO();
            rest.setList(list);
            rest.setCount(count);
            MyPrintOut.printJson(response, rest);
        }
    }

    private StudentVO toStudentVO(HttpServletRequest request) {
        StudentVO vo = new StudentVO();
        String para = request.getParameter(PARA_ID);
        if (para != null && para != "") {
            vo.setId(para);
        }
        para = request.getParameter(PARA_NAME);
        if (para != null && para != "") {
            vo.setName(para);
        }
        para = request.getParameter(PARA_DESCRIPTION);
        if (para != null && para != "") {
            vo.setDescription(para);
        }
       para = request.getParameter(PARA_AVG_SCORE);
        if (para != null && para != "") {
            vo.setAvgScore(para);
        }
        para = request.getParameter(PARA_BIRTHDAY);
        if (para != null && para != "") {
            vo.setBirthday(para);
        }
        para = request.getParameter(PARA_PAGE_SIZE);
        if (para != null && para != "") {
            vo.setPageSize(para);
        }
        para = request.getParameter(PARA_PAGE_NUM);
        if (para != null && para != "") {
            vo.setPageNum(para);
        }
        para = request.getParameter(PARA_DELETE_LIST);
        if (para != null && para != "") {
            vo.setDeleteList(para);
        }
        return vo;
    }
}
