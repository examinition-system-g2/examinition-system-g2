package com.henu.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.henu.bean.Exam;

public class ExamDaoImplTest {

	public static ExamDaoImpl e = new ExamDaoImpl();
	public static Exam exam = new Exam();
	public List<Exam> list = new ArrayList<>();
	@Before
	public void setUp() throws Exception {
		exam.setE_name("123");
		exam.setE_starttime("2017-9-9");
		exam.setE_teacher("admin");
		exam.setE_autostart(false);
		exam.setE_isend(false);
		exam.setE_file(false);
		exam.setE_clear(false);
		exam.setE_isstart(false);
	}

	@Test
	public void testAdd() {
		assertEquals(1, e.add(exam));
	}

	@Test
	public void testDelete() {
		assertEquals(1, e.delete(exam.getE_name()));
	}
	
	@Test
	public void testUpdate() {
		assertEquals(1, e.update(exam, "111"));
	}

	@Test
	public void testSearchString() {
		Exam exam1 = new Exam();
		exam1.setE_name("111");
		exam1.setE_starttime("2017-12-30 07:20");
		exam1.setE_teacher("admin");
		exam1.setE_examination("null");
		exam1.setE_isend(false);
		exam1.setE_autostart(false);
		exam1.setE_file(false);
		exam1.setE_clear(false);
		exam1.setE_isstart(false);
		assertEquals(exam1, e.search("111"));
	}

}
