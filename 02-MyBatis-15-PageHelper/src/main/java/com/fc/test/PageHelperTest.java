package com.fc.test;

import com.fc.dao.StudentDao;
import com.fc.entity.Student;
import com.fc.util.MyBatisUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;

import java.util.List;

public class PageHelperTest {
    @Test
    public void test() {
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

        // 一行代码搞定，需要声明当前页和每页显示多少条数据
        PageHelper.startPage(100000, 2);

        List<Student> students = studentDao.findAll();

        for (Student student : students) {
            System.out.println(student);
        }

        MyBatisUtil.commit();
    }

    @Test
    public void testPageInfo() {
        StudentDao dao = MyBatisUtil.getMapper(StudentDao.class);

        // 开启分页
        PageHelper.startPage(1, 2);

        List<Student> students = dao.findAll();

        // 封装PageInfo
        PageInfo<Student> pageInfo = new PageInfo<>(students);

        System.out.println(pageInfo);
    }

}
