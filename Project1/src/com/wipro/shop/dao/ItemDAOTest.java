package com.wipro.shop.dao;

import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.wipro.shop.bean.ItemBean;

class ItemDAOTest {

	@Test
	void test() {
		List<ItemBean> l = new ItemDAO().findAll();
		Iterator<ItemBean> i = l.iterator();
		while(i.hasNext())
			System.out.println(i.next().toString());
		
	}

}
