package com.henu.utils;

import com.henu.dao.IExamDao;
import com.henu.dao.IStudentDao;
import com.henu.dao.ITeacherDao;
import com.henu.impl.ExamDaoImpl;
import com.henu.impl.StudentDaoImpl;
import com.henu.impl.TeacherDaoImpl;
public class DaoFactory {

	public static IExamDao getExamDaoInstance() {
		// TODO Auto-generated method stub
		return new ExamDaoImpl();
	}
	public static IStudentDao getStudentDaoInstance() {
		// TODO Auto-generated method stub
		return new StudentDaoImpl();
	}
	public static ITeacherDao getTeacherDaoInstance() {
		// TODO Auto-generated method stub
		return new TeacherDaoImpl();
	}
}
