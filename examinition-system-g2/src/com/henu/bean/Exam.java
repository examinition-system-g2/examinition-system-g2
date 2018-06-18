package com.henu.bean;
//考试信息
public class Exam {
	private String e_name;//考试名称
	private String e_starttime;//考试开始时间
	private String e_teacher;//考试创建人
	private String e_examination;//考试试卷
	private boolean e_isend;//考试是否已结束
	private boolean e_autostart;//考试是否自动开始
	private boolean e_file;//考试是否已归档
	private boolean e_clear;//考试是否已清理
	private boolean e_isstart;
	/*private int e_id;
	public int getE_id() {
		return e_id;
	}
	public void setE_id(int e_id) {
		this.e_id = e_id;
	}*/
	public boolean getE_isstart() {
		return e_isstart;
	}
	public void setE_isstart(boolean e_isstart) {
		this.e_isstart = e_isstart;
	}
	public String getE_name() {
		return e_name;
	}
	public void setE_name(String e_name) {
		this.e_name = e_name;
	}
	public String getE_starttime() {
		return e_starttime;
	}
	public void setE_starttime(String e_starttime) {
		this.e_starttime = e_starttime;
	}
	public String getE_teacher() {
		return e_teacher;
	}
	public void setE_teacher(String e_teacher) {
		this.e_teacher = e_teacher;
	}
	public String getE_examination() {
		return e_examination;
	}
	public void setE_examination(String e_examination) {
		this.e_examination = e_examination;
	}
	public boolean getE_isend() {
		return e_isend;
	}
	public void setE_isend(boolean e_isend) {
		this.e_isend = e_isend;
	}
	public boolean getE_autostart() {
		return e_autostart;
	}
	public void setE_autostart(boolean e_autostart) {
		this.e_autostart = e_autostart;
	}
	public boolean getE_file() {
		return e_file;
	}
	public void setE_file(boolean e_file) {
		this.e_file = e_file;
	}
	public boolean getE_clear() {
		return e_clear;
	}
	public void setE_clear(boolean e_clear) {
		this.e_clear = e_clear;
	}
	
}
