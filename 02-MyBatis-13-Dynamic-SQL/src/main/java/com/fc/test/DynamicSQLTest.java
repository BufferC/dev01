package com.fc.test;

import com.fc.dao.StudentDao;
import com.fc.entity.Student;
import com.fc.util.MyBatisUtil;
import org.junit.Test;

import java.util.List;

public class DynamicSQLTest {
    @Test
    public void testDeleteMore() {
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

        int affectedRows = studentDao.deleteMore(5, 6, 7, 8);

        System.out.println(affectedRows);

        MyBatisUtil.commit();
    }

    @Test
    public void testUpdateOnTrim() {
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

        Student student = new Student();
        student.setId(9);
        student.setInfo("123");

        int affectedRows = studentDao.updateOnTrim(student);

        System.out.println("受影响的行数：" + affectedRows);

        MyBatisUtil.commit();
    }

    @Test
    public void testUpdate() {
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

        Student student = new Student();
        student.setId(15);
        student.setInfo("123");

        int affectedRows = studentDao.update(student);

        System.out.println("受影响的行数：" + affectedRows);

        MyBatisUtil.commit();
    }

    @Test
    public void testFindByStudent() {
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
        Student student = new Student();
        student.setId(3);
        student.setName("易烊千玺");
        student.setGender("女");

        List<Student> students = studentDao.findByStudent(student);

        for (Student temp : students) {
            System.out.println(temp);
        }

        MyBatisUtil.commit();
    }

    @Test
    public void testFindByStudentOnTrim() {
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
        Student student = new Student();
        student.setId(3);
        student.setName("易烊千玺");
        student.setGender("女");

        List<Student> students = studentDao.findByStudentOnTrim(student);

        for (Student temp : students) {
            System.out.println(temp);
        }

        MyBatisUtil.commit();
    }

    @Test
    public void testFindAllByKeyword() {
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
        List<Student> students = studentDao.findByKeyword("%鹏%", "%大%");

        for (Student student : students) {
            System.out.println(student);
        }

        MyBatisUtil.commit();
    }

    @Test
    public void testFindAll() {
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
        List<Student> students = studentDao.findAll();

        for (Student student : students) {
            System.out.println(student);
        }

        MyBatisUtil.commit();
    }


}
