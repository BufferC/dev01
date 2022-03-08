package com.fc.dao;

import com.fc.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StudentDao {
    @Select("select * from student")
    List<Student> findAll();

    @Select("select * from student where id = #{id}")
    Student findById(@Param("id") Integer id);

    @Insert("insert into student(name, age, gender, birthday, info)" +
            "values (#{name}, #{age}, #{gender}, #{birthday}, #{info})")
    int insert(Student student);

    @Delete("delete from student where id = #{id}")
    int delete(@Param("id") Integer id);

    @Update("update student set info = #{info} where id = #{id}")
    int update(Student student);
}
