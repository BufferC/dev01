package com.fc.dao;

import com.fc.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
    // 查询全部
    List<Student> findAll();

    // 根据id查询
    Student findById(@Param("id") Integer id);

    // 插入
    int insert(Student student);

    // 删除
    int delete(@Param("id") Integer id);

    // 修改
    int update(Student student);

    // 模糊查询
    List<Student> findByKeyword(@Param("keyword") String keyword);

    // 获取自动生成的主键id
    int getAutoIncrement(Student student);
}
