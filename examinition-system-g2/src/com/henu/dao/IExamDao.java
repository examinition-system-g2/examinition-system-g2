package com.henu.dao;

import java.util.List;

import com.henu.bean.Exam;



public interface IExamDao {
	/**
	 * 添加考试
	 * @param exam 考试信息
	 * @return 更改数据库受影响的行数
	 */
	public int add(Exam exam);
	/**
	 * 删除考试
	 * @param examname 删除信息主键
	 * @return 更改数据库受影响的行数
	 */
	public int delete(String examname);
	/**
	 * 查询单个考试信息
	 * @param examname
	 * @return
	 */
	public Exam search(String examname);
	/**
	 * 查询所有考试信息
	 * @return List<Exam> 所有考试的信息
	 */
	public List<Exam> search();
	/**
	 * 更改考试信息
	 * @param username 根据主键用户名查询教考试信息
	 * @param Student 更改后的考试信息
	 */
	public int update(Exam exam,String examname);
}
