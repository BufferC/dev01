package com.fc.dao;

import com.fc.entity.Department;
import org.apache.ibatis.annotations.Param;

public interface DepartmentDao {
    // 根据部门的id查询当前部门下的所有员工
    Department findById(@Param("id") Integer id);
}
