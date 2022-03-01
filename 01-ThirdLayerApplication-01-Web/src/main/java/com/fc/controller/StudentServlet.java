package com.fc.controller;

import com.fc.entity.Student;
import com.fc.service.StudentService;
import com.fc.service.impl.StudentServiceImpl;
import com.fc.vo.PageInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/page")
public class StudentServlet extends HttpServlet {
    // 获取业务层接口的实现类对象【BO】
    StudentService studentService = new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求参数
        String parameter = req.getParameter("pageNo");

        // 默认访问第一页
        int pageNo = 1;

        // 类型转换
        if (parameter != null) {
            pageNo = Integer.parseInt(parameter);
        }

        // 每页显示多少条内容
        int pageSize = 5;

        // 通过业务层对象获取分页数据对象
        PageInfo<Student> pageInfo = studentService.getPageInfo(pageNo, pageSize);

        req.setAttribute("pageInfo", pageInfo);

        req.getRequestDispatcher("page.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
