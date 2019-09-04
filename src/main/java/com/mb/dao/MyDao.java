package com.mb.dao;

import java.util.List;

import com.mb.bean.DianYing;

public interface MyDao {

	List list();

	List toadd();

	int add(DianYing dianying);

	DianYing toupd(int id);

	int upd(DianYing dianying);

}
