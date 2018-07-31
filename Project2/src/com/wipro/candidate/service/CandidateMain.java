package com.wipro.candidate.service;

import java.util.ArrayList;

import com.wipro.candidate.bean.CandidateBean;
import com.wipro.candidate.dao.CandidateDAO;
import com.wipro.candidate.util.WrongDataException;

public class CandidateMain {
	
	public static void main(String[] args)
	{
		
	}
	
	//***********************METHOD 1**************************************//
	//*********************************************************************//
	
	public String addCandidate(CandidateBean candBean)
	{
		String msg=null;
		try
		{
			if(candBean==null||candBean.getName().isEmpty()||candBean.getName().length()<2)
				throw new WrongDataException();
			if(candBean.getM1()<0||candBean.getM2()<0||candBean.getM3()<0||candBean.getM1()>100||candBean.getM2()>100||candBean.getM3()>100)
				throw new WrongDataException();
		}
		catch(WrongDataException e)
		{
			return e.toString();
		}
		candBean.setId(new CandidateDAO().generateCandidateId(candBean.getName()));
		int tot = candBean.getM1()+candBean.getM2()+candBean.getM3();
		if(tot>=240)
		{
			candBean.setResult("PASS");
			candBean.setGrade("Distinction");
		}
		else if(tot>=240)
		{
			candBean.setResult("PASS");
			candBean.setGrade("Distinction");
		}
		else if(tot>=180)
		{
			candBean.setResult("PASS");
			candBean.setGrade("First Class");
		}
		else if(tot>=150)
		{
			candBean.setResult("PASS");
			candBean.setGrade("Second Class");
		}
		else if(tot>=105)
		{
			candBean.setResult("PASS");
			candBean.setGrade("Third Class");
		}
		else
		{
			candBean.setResult("FAIL");
			candBean.setGrade("No Grade");
		}
		msg=new CandidateDAO().addCandidate(candBean);
		if(msg.equals("SUCCESS"))
			return (candBean.getId()+":"+candBean.getResult());
		else return "Error";
	}
	
	//*******************************METHOD 2***************************************//
	//******************************************************************************//
	
	public ArrayList<CandidateBean> displayAll(String criteria)
	{
			try {
				if(!criteria.equals("PASS")&&!criteria.equals("FAIL")&&!criteria.equals("ALL"))
				throw new WrongDataException();
			} catch (WrongDataException e) {
				// TODO Auto-generated catch block
				return null;
			}
			ArrayList<CandidateBean> al = new CandidateDAO().getByResult(criteria);
		return al;
	}

}
