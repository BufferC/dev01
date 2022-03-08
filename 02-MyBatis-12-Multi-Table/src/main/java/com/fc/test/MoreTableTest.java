package com.fc.test;

import com.fc.dao.DepartmentDao;
import com.fc.dao.EmployeeDao;
import com.fc.dao.StudentDao;
import com.fc.dao.SubjectDao;
import com.fc.entity.Department;
import com.fc.entity.Employee;
import com.fc.entity.Student;
import com.fc.entity.Subject;
import com.fc.util.MyBatisUtil;
import org.junit.Test;
import java.util.List;

public class MoreTableTest {
    @Test
    public void testEmployee() {
        EmployeeDao employeeDao = MyBatisUtil.getMapper(EmployeeDao.class);

        List<Employee> employees = employeeDao.findAll();

        for (Employee employee : employees) {
            System.out.println(employee);
        }

        MyBatisUtil.commit();
    }

    @Test
    public void testDepartment() {
        DepartmentDao departmentDao = MyBatisUtil.getMapper(DepartmentDao.class);

        Department department = departmentDao.findById(1);

        System.out.println(department);

        MyBatisUtil.commit();
    }

    @Test
    public void testSubject() {
        SubjectDao subjectDao = MyBatisUtil.getMapper(SubjectDao.class);

        List<Subject> subjects = subjectDao.findAllWithStudent();

        for (Subject subject : subjects) {
            System.out.println(subject);
        }

        MyBatisUtil.commit();
    }

    @Test
    public void testStudent() {
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

        List<Student> students = studentDao.findAllWithSubject();

        for (Student student : students) {
            System.out.println(student);
        }

        MyBatisUtil.commit();
    }
}
