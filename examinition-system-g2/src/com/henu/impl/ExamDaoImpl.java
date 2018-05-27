package com.henu.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.henu.bean.Exam;
import com.henu.dao.IExamDao;
import com.henu.utils.DbUtil;

public class ExamDaoImpl implements IExamDao{

	@Override
	public int add(Exam exam) {
		// TODO Auto-generated method stub
		String sql = "insert into exam(e_name,e_starttime,e_teacher,e_autostart,e_isend,e_file,e_clear,e_isstart) values (?,?,?,?,?,?,?,?)";
		int result = 0;
		// 动态为sql的参数赋值
		try {
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			ps.setString(1, exam.getE_name());
			ps.setString(2, exam.getE_starttime());
			ps.setString(3, exam.getE_teacher());
			ps.setBoolean(4, exam.getE_autostart());
			ps.setBoolean(5, false);
			ps.setBoolean(6, false);
			ps.setBoolean(7, false);
			ps.setBoolean(8, false);
			// 执行sql语句
			result = ps.executeUpdate();
			ps.close();
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
			String sql = "delete from exam where e_name='" + username + "'";
			result = DbUtil.executeUpdate(sql);
			DbUtil.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Exam> search() {
		// TODO Auto-generated method stub
		List<Exam> list=new ArrayList<Exam>();
		String sql="SELECT * FROM exam";
		try {
			ResultSet rs=DbUtil.executeQuery(sql);
			while(rs.next())
			{
				Exam exam=new Exam();
				exam.setE_name(rs.getString("e_name"));
				exam.setE_starttime(rs.getString("e_starttime"));
				exam.setE_teacher(rs.getString("e_teacher"));
				exam.setE_examination(rs.getString("e_examination"));
				exam.setE_isend(rs.getBoolean("e_isend"));
				exam.setE_autostart(rs.getBoolean("e_autostart"));
				exam.setE_file(rs.getBoolean("e_file"));
				exam.setE_clear(rs.getBoolean("e_clear"));
				exam.setE_isstart(rs.getBoolean("e_isstart"));
				list.add(exam);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int update(Exam exam, String examname) {
		// TODO Auto-generated method stub
		String sql="update exam set e_name= '"+exam.getE_name()+
				"',e_starttime= '"+exam.getE_starttime()+
				"',e_teacher= '"+exam.getE_teacher()+
				"',e_examination= '"+exam.getE_examination()+
				"',e_isend= "+exam.getE_isend()+
				",e_autostart= "+exam.getE_autostart()+
				",e_file= "+exam.getE_file()+
				",e_clear= "+exam.getE_clear()+
				",e_isstart= "+exam.getE_isstart()+
				" where e_name='" + examname + "'";
		int result = 0;
		try {
			result = DbUtil.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Exam search(String examname) {
		// TODO Auto-generated method stub
		Exam exam=new Exam();
		String sqlSearch = "select * from exam where e_name='" + examname + "'";
        ResultSet rs = null;
		rs = DbUtil.executeQuery(sqlSearch);
		try {
			while (rs.next()) {
				exam.setE_name(rs.getString("e_name"));
				exam.setE_starttime(rs.getString("e_starttime"));
				exam.setE_teacher(rs.getString("e_teacher"));
				exam.setE_examination(rs.getString("e_examination"));
				exam.setE_isend(rs.getBoolean("e_isend"));
				exam.setE_autostart(rs.getBoolean("e_autostart"));
				exam.setE_file(rs.getBoolean("e_file"));
				exam.setE_clear(rs.getBoolean("e_clear"));
				exam.setE_isstart(rs.getBoolean("e_isstart"));
			}
			DbUtil.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return exam;
	}



	

}
