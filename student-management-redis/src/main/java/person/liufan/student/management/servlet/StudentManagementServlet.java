package person.liufan.student.management.servlet;

import person.liufan.student.management.vo.StudentVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/26
 */
public class StudentManagementServlet extends HttpServlet {
    /*private StudentService studentService = new StudentServiceImpl();*/
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
        if (TYPE_SAVE.equals(type)) {
            System.out.println(toStudentVO(request));
        }
        if (TYPE_UPDATE.equals(type)) {
            System.out.println(toStudentVO(request));
        }
        if (TYPE_DELETE.equals(type)) {
            System.out.println(toStudentVO(request));
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter(TYPE);
        if (TYPE_QUERY_BY_ID.equals(type)) {
            System.out.println(toStudentVO(request));
        }
        if (TYPE_LIST_DETAIL.equals(type)) {
            System.out.println(toStudentVO(request));
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
