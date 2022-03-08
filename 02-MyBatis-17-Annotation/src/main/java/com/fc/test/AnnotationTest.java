package com.fc.test;

import com.fc.dao.StudentDao;
import com.fc.entity.Student;
import com.fc.util.MyBatisUtil;
import org.junit.Test;

import java.util.Date;

public class AnnotationTest {
    @Test
    public void test() {
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
        studentDao.findAll();

        MyBatisUtil.commit();
    }

    @Test
    public void testFindById() {
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
        studentDao.findById(1);

        MyBatisUtil.commit();
    }

    @Test
    public void testInsert() {
        StudentDao mapper = MyBatisUtil.getMapper(StudentDao.class);

        Student student = new Student();

        student.setName("猪大肠");
        student.setGender("男");
        student.setAge((byte) 21);
        student.setBirthday(new Date());
        student.setInfo("忧郁");

        mapper.insert(student);

        MyBatisUtil.commit();
    }

    @Test
    public void testUpdate() {
        StudentDao mapper = MyBatisUtil.getMapper(StudentDao.class);

        Student student = new Student();
        student.setId(11);
        student.setInfo("刺身");

        mapper.update(student);

        MyBatisUtil.commit();
    }

    @Test
    public void testDelete() {
        StudentDao mapper = MyBatisUtil.getMapper(StudentDao.class);

        mapper.delete(11);

        MyBatisUtil.commit();
    }
}
