package com.henu.dao;

import java.util.List;

import com.henu.bean.Teacher;

public interface ITeacherDao {
	/**
	 * 教师/管理员登录
	 * @param username 用户名
	 * @param password 密码
	 * @return 返回登陆结果 管理登陆成功为admin , 教师登陆成功为teacher 否则为""
	 */
	public String login(String username,String password);
	/**
	 * 添加教师
	 * @param Student 学生信息
	 * @return 更改数据库受影响的行数
	 */
	public int add(Teacher teacher);
	/**
	 * 删除教师
	 * @param username 教师主键
	 * @return 更改数据库受影响的行数
	 */
	public int delete(String username);
	/**
	 * 查询单个教师信息
	 * 
	 */
	public Teacher search(String username);
	/**
	 * 查询所有教师信息
	 * @return List<Student> 所有教师的信息
	 */
	public List<Teacher> search();
	/**
	 * 更改教师信息
	 * @param username 根据主键用户名查询教师信息
	 * @param Student 更改后的教师信息
	 */
	public int update(Teacher teacher,String username);
	
}
