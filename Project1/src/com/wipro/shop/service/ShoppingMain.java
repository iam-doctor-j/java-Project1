package com.wipro.shop.service;

import java.util.List;

import com.wipro.shop.bean.CouponBean;
import com.wipro.shop.bean.ItemBean;
import com.wipro.shop.dao.CouponDAO;
import com.wipro.shop.dao.ItemDAO;
import com.wipro.shop.util.NoSuchCouponException;

public class ShoppingMain {
	static float cost;
	public static void main(String[] args)
	{
		ShoppingMain shopping = new ShoppingMain();
		List<ItemBean> listItems = shopping.viewAllItems();
		for(ItemBean i:listItems)
		{
			System.out.println(i);
			
		}
		String itemCode = "LU1003";
		String userID = "AA1003";
		String couponCode = "AB10CD23";
		String result = shopping.doShopping(itemCode, userID, couponCode);
		System.out.println(result);
	}
	
	public String doShopping(String itemCode,String userID, String couponCode)
	{
		if(itemCode==null||userID==null||couponCode==null)
			return "NULL VALUE";
		ItemBean ib = new ItemDAO().findItemByItemCode(itemCode);
		 
		if(ib==null)
			return "INVALID ITEM CODE";
		CouponBean cb = new CouponDAO().findCouponByCouponCode(couponCode);
		try {
			
			if(cb==null)
				{
					throw new NoSuchCouponException();
				}
			if(!userID.equals(cb.getUserID()))
			{
				return "DATA MISMATCH";
			}
			if(cb.getStatus()==0)
			{
				return "USED COUPON";
			}
			if(!cb.getCouponCode().equals("NO")||!cb.getUserID().equals("G"))
			{
				cost = ib.getCost()-(0.2f*ib.getCost());
				@SuppressWarnings("unused")
				boolean result= new CouponDAO().updateCouponByCouponCode(couponCode);
			}
			else
				cost = ib.getCost();
		}
		catch(NoSuchCouponException e)
		{
			return e.toString();
		}
		
		return String.valueOf(cost);
		
		
		
	}
	
	public List<ItemBean> viewAllItems()
	{
		return new ItemDAO().findAll();
	}

}
