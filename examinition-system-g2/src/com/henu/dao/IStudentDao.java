package com.henu.dao;

import java.util.List;

import com.henu.bean.Student;

public interface IStudentDao {
	/**
	 * 学生登录
	 * @param username 用户名
	 * @param password 密码
	 * @return 返回登陆结果 登陆成功为true ,否则为false
	 */
	public boolean login(String username,String password);
	/**
	 * 添加学生
	 * @param Student 学生信息
	 * @return 更改数据库受影响的行数
	 */
	public int add(Student student);
	/**
	 * 删除学生
	 * @param username 学生主键
	 * @return 更改数据库受影响的行数
	 */
	public int delete(String username);
	/**
	 * 查询单个学生信息
	 * @param username 根据主键用户名查询学生信息
	 * @return Student 该学生的信息
	 */
	public Student search(String username);
	/**
	 * 查询所有学生信息
	 * @return List<Student> 所有学生的信息
	 */
	public List<Student> search();
	/**
	 * 更改学生信息
	 * @param username 根据主键用户名查询学生信息
	 * @param Student 更改后的学生信息
	 */
	public int update(Student student,String username);
	
}
