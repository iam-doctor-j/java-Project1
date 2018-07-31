package com.wipro.shop.util;

@SuppressWarnings("serial")
public class NoSuchCouponException extends Exception {
	
	public String toString()
	{
		return "INVALID COUPON CODE";
	}

}
