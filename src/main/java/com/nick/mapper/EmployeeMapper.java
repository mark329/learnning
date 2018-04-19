package com.nick.mapper;

import org.apache.ibatis.annotations.Param;

import com.nick.model.Employee;

public interface EmployeeMapper {

	public Employee getById(Long id);

	public Employee getByAttributes(String gender, String email);

	public Long insert(Employee employee);

	public Integer update(Employee employee);

	public void deleteById(Long id);
}
