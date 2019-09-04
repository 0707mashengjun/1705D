package com.mb.service;

import java.util.List;

import com.mb.bean.DianYing;

public interface MyService {

	List list();

	List toadd();

	int add(DianYing dianying);

	DianYing toupd(int id);

	int upd(DianYing dianying);

}
