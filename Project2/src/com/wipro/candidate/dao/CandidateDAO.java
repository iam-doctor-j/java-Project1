package com.wipro.candidate.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.wipro.candidate.bean.CandidateBean;
import com.wipro.candidate.util.DBUtil;

public class CandidateDAO {
// addCandidate(CandidateBean CandidateBean) method
	public String addCandidate(CandidateBean CandidateBean)
	{
		Connection con = DBUtil.getDBConn();
		int val=0;
		String msg="FAIL";
		PreparedStatement pst;
		try {
			pst = con.prepareStatement("insert into CANDIDATE_TBL values(?,?,?,?,?,?,?)");
			pst.setString(1,CandidateBean.getId() );
			pst.setString(2, CandidateBean.getName());
			pst.setInt(3, CandidateBean.getM1());
			pst.setInt(4, CandidateBean.getM2());
			pst.setInt(5, CandidateBean.getM3());
			pst.setString(6, CandidateBean.getResult());
			pst.setString(7, CandidateBean.getGrade());
			val=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return msg;
		}
		if(val==1)
		{
			msg="SUCCESS";
		}
		
		return msg;
	}
	
// public ArrayList<CandidateBean> getByResult(String criteria) method start
	
	public ArrayList<CandidateBean> getByResult(String criteria)
	{
		Connection con = DBUtil.getDBConn();
		ArrayList<CandidateBean> list=null;
		CandidateBean cb=null;
		if(criteria.equals("PASS")||criteria.equals("FAIL"))
		{
			list = new ArrayList<CandidateBean>();
			try {
				PreparedStatement pst = con.prepareStatement("select * from CANDIDATE_TBL where RESULT=?");
				pst.setString(1, criteria);
				ResultSet rs = pst.executeQuery();
				while(rs.next())
				{
					cb = new CandidateBean();
					cb.setId(rs.getString(1));
					cb.setName(rs.getString(2));
					cb.setM1(rs.getInt(3));
					cb.setM2(rs.getInt(4));
					cb.setM3(rs.getInt(5));
					cb.setResult(rs.getString(6));
					cb.setGrade(rs.getString(7));
					list.add(cb);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return list;
			}
			
		}
		else if(criteria.equals("ALL"))
		{
			list = new ArrayList<CandidateBean>();
			try {
				PreparedStatement pst = con.prepareStatement("select * from CANDIDATE_TBL");
				ResultSet rs = pst.executeQuery();
				while(rs.next())
				{
					cb = new CandidateBean();
					cb.setId(rs.getString(1));
					cb.setName(rs.getString(2));
					cb.setM1(rs.getInt(3));
					cb.setM2(rs.getInt(4));
					cb.setM3(rs.getInt(5));
					cb.setResult(rs.getString(6));
					cb.setGrade(rs.getString(7));
					list.add(cb);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				return list;
			}
		}
		
		return list;
	}
	
	public String generateCandidateId(String name)
	{
		Connection conn = DBUtil.getDBConn();
		String key = new String();
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select candid_seq.nextval from dual");
			if(rs.next())
				key = (name.substring(0, 2)+rs.getString(1)).toUpperCase();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return key;
		
	}

}
