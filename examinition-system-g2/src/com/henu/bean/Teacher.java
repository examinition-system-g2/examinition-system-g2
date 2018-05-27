package com.henu.bean;
//教师信息
public class Teacher {
	private String t_username;//教师登录用户名
	private String t_pwd;//教师登录密码
	private String t_name;//教师姓名
	private boolean t_manager;//该教师是否为管理员
	public String getT_username() {
		return t_username;
	}
	public void setT_username(String t_username) {
		this.t_username = t_username;
	}
	public String getT_pwd() {
		return t_pwd;
	}
	public void setT_pwd(String t_pwd) {
		this.t_pwd = t_pwd;
	}
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	public boolean getT_manager() {
		return t_manager;
	}
	public void setT_manager(boolean t_manager) {
		this.t_manager = t_manager;
	}
	
}
