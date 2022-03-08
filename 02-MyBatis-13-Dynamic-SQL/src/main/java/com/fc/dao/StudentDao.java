package com.fc.dao;

import com.fc.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
    List<Student> findAll();

    List<Student> findByKeyword(@Param("name") String name, @Param("info") String info);

    // 根据条件查询学生
    List<Student> findByStudent(Student student);

    List<Student> findByStudentOnTrim(Student student);

    // 修改学生内容
    int update(Student student);

    int updateOnTrim(Student student);

    // 不定长参数/可变长参数，可以传递的参数个数为0个、1个或者多个
    // 只能用作形参列表中最后一个参数的位置，并且只能有一个
    int deleteMore(Integer... ids);
}
