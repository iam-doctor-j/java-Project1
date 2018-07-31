package com.wipro.candidate.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.jupiter.api.Test;

import com.wipro.candidate.bean.CandidateBean;
import com.wipro.candidate.service.CandidateMain;

@SuppressWarnings("unused")
class CandidateDAOTest {

	@Test
	void test() {
//		ArrayList<CandidateBean> al=new ArrayList<CandidateBean>();
//		al.addAll(new CandidateDAO().getByResult("FAIL"));
//		Iterator i = al.iterator();
//		while(i.hasNext())
//		{
//			System.out.println(i.next().toString());
//		}
		
		assertNull(new CandidateDAO().getByResult("SO"));
	}

}
