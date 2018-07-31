package com.wipro.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wipro.shop.bean.CouponBean;
import com.wipro.shop.util.DBUtil;

public class CouponDAO {
	
	public CouponBean findCouponByCouponCode(String couponCode)
	{
		Connection con = DBUtil.getDBConnection();
		CouponBean c=null;
		try {
			PreparedStatement st = con.prepareStatement("select * from Coupons_tbl where couponcode =?");
			st.setString(1, couponCode);
			ResultSet rs = st.executeQuery();
			if(rs.next())
			{
				c = new CouponBean();
				c.setCouponCode(rs.getString(1));
				c.setUserID(rs.getString(2));
				c.setStatus(rs.getInt(3));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
		
	}
	
	public boolean updateCouponByCouponCode(String code)
	{
		Connection con = DBUtil.getDBConnection();
		int check;
		try {
			PreparedStatement ps = con.prepareStatement("update Coupons_tbl set status=0 where couponcode = ?");
			ps.setString(1, code);
			check = ps.executeUpdate();
			if(check==1)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	public CouponBean findCouponByUserID(String userID)
	{
		Connection con = DBUtil.getDBConnection();
		CouponBean c = new CouponBean();
		try {
			PreparedStatement st = con.prepareStatement("select * from Coupons_tbl where userid =?");
			st.setString(1, userID);
			ResultSet rs = st.executeQuery();
			if(rs.next())
			{
				c.setCouponCode(rs.getString(1));
				c.setUserID(rs.getString(2));
				c.setStatus(rs.getInt(3));
				return c;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
