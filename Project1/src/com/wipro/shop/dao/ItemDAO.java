package com.wipro.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.wipro.shop.bean.ItemBean;
import com.wipro.shop.util.DBUtil;

public class ItemDAO {
	
	public List<ItemBean> findAll()
	{
		Connection con = DBUtil.getDBConnection();
		ItemBean ib = new ItemBean();
		List<ItemBean> list = new ArrayList<ItemBean>();
		try {
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from items_tbl");
			while(rs.next())
			{
				ib = new ItemBean();
				ib.setItemCode(rs.getString(1));
				ib.setName(rs.getString(2));
				ib.setQuantity(rs.getInt(3));
				ib.setCost(rs.getFloat(4));
				list.add(ib);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(list.isEmpty())
			return null;
		
		return list;
	}
	
	public ItemBean findItemByItemCode(String itemCode)
	{
		Connection con = DBUtil.getDBConnection();
		ItemBean ib = new ItemBean();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from items_tbl where itemcode=?");
			ps.setString(1, itemCode);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				ib.setItemCode(rs.getString(1));
				ib.setName(rs.getString(2));
				ib.setQuantity(rs.getInt(3));
				ib.setCost(rs.getFloat(4));
				return ib;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
