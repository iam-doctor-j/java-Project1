package com.wipro.candidate.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.jupiter.api.Test;

import com.wipro.candidate.bean.CandidateBean;

@SuppressWarnings("unused")
class CandidateMainTest {

	@Test
	void test() {
//		ArrayList<CandidateBean> al=new ArrayList<CandidateBean>();
//		al.addAll(new CandidateMain().displayAll("ALL"));
//		Iterator i = al.iterator();
//		while(i.hasNext())
//		{
//			System.out.println(i.next().toString());
//		}
		
//		assertEquals("Data Incorrect",new CandidateMain().addCandidate(new CandidateBean("a",10,56,45)));
		
		assertNull(new CandidateMain().displayAll("B"));
	}

}
