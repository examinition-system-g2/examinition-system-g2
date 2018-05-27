package com.henu.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.henu.bean.Teacher;

public class TeacherDaoImplTest {

	public TeacherDaoImpl t = new TeacherDaoImpl();
	Teacher teacher = new Teacher();
	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testLogin() {
		assertEquals("admin", t.login("admin", "ff0ad942f3afc7a5"));
	}

	@Test
	public void testAdd() {
		teacher.setT_username("111");
		teacher.setT_pwd("111");
		teacher.setT_name("111");
		teacher.setT_manager(false);
		assertEquals(1, t.add(teacher));
	}

	@Test
	public void testDelete() {
		assertEquals(1, t.delete("111"));
	}

	@Test
	public void testUpdate() {
		teacher.setT_pwd("c190dfa091101962");
		teacher.setT_name("321");
		teacher.setT_manager(true);
		assertEquals(1, t.update(teacher, "123"));
	}
}
