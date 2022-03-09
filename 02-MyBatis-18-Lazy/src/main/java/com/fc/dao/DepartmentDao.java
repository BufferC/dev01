package com.fc.dao;

import com.fc.entity.Department;
import org.apache.ibatis.annotations.Param;

public interface DepartmentDao {
    // 根据部门id获取部门的对象（包含所有的员工信息）
    Department findByDepartmentId(@Param("id") Integer id);
}
