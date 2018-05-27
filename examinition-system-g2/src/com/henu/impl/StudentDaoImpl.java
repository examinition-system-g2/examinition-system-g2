package com.henu.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.henu.bean.Student;
import com.henu.bean.Teacher;
import com.henu.dao.IStudentDao;
import com.henu.utils.DbUtil;

public class StudentDaoImpl implements IStudentDao {

	@Override
	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		boolean login = false;
		Student student = search(username);
		if (student.getStu_name().equals(password)) {
			
			login = true;
		}
		return login;
	}

	@Override
	public int add(Student student) {
		// TODO Auto-generated method stub
		int result = 0;
		String insert = "insert into student (stu_id,stu_name,stu_class,stu_exam) values(?,?,?,?)";
		PreparedStatement ps = DbUtil.executePreparedStatement(insert);
		try {
			ps.setString(1, student.getStu_id());
			ps.setString(2, student.getStu_name());
			ps.setString(3, student.getStu_class());
			ps.setString(4, student.getStu_exam());
			result = ps.executeUpdate();
			ps.close();
			DbUtil.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int delete(String username) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			String sql = "delete from student where stu_id='" + username + "'";
			result = DbUtil.executeUpdate(sql);
			DbUtil.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Student search(String username) {
		// TODO Auto-generated method stub
		Student student = new Student();
		String sql = "select * from student where stu_id = ?";
		PreparedStatement ps = DbUtil.executePreparedStatement(sql);
		try {
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				student.setStu_id(rs.getString("stu_id"));
				student.setStu_name(rs.getString("stu_name"));
				student.setStu_class(rs.getString("stu_class"));
				student.setStu_exam(rs.getString("stu_exam"));
				student.setStu_ip(rs.getString("stu_ip"));
				student.setStu_submit(rs.getString("stu_submit"));
			} else {
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public List<Student> search() {
		// TODO Auto-generated method stub
		List<Student> list = new ArrayList<Student>();
		String sql = "SELECT * FROM student";
		try {
			ResultSet rs = DbUtil.executeQuery(sql);
			while (rs.next()) {
				Student student = new Student();
				student.setStu_id(rs.getString("stu_id"));
				student.setStu_name(rs.getString("stu_name"));
				student.setStu_class(rs.getString("stu_class"));
				student.setStu_exam(rs.getString("stu_exam"));
				student.setStu_ip(rs.getString("stu_ip"));
				student.setStu_submit(rs.getString("stu_submit"));
				list.add(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int update(Student student, String username) {
		// TODO Auto-generated method stub
		String spl = "update student set stu_name= '" + student.getStu_name() + 
				"',stu_class= '"+ student.getStu_class() + 
				"',stu_submit= '" + student.getStu_submit() + 
				"',stu_ip= '"+ student.getStu_ip() + 
				"',stu_exam= '" + student.getStu_exam() + 
				"' where stu_id='" + username + "'";
		int result = 0;
		try {
			result = DbUtil.executeUpdate(spl);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
