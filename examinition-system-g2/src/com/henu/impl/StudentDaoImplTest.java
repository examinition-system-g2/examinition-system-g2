package com.henu.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.henu.bean.Student;

public class StudentDaoImplTest {

	public StudentDaoImpl s = new StudentDaoImpl();
	Student student = new Student();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testLogin() {
		assertEquals(true,s.login("111", "111") );
	}

	@Test
	public void testAdd() {
		student.setStu_name("222");
		student.setStu_class("222");
		student.setStu_id("222");
		student.setStu_exam("111");
		assertEquals(1, s.add(student));
	}

	@Test
	public void testDelete() {
		assertEquals(1, s.delete("222"));
	}


	@Test
	public void testUpdate() {
		student.setStu_name("555");
		student.setStu_class("555");
		student.setStu_submit("null");
		student.setStu_ip("null");
		student.setStu_exam("null");
		assertEquals(1, s.update(student, "111"));
	}

}
