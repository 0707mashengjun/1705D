package com.mb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb.bean.DianYing;
import com.mb.dao.MyDao;

@Service
public class MyServiceImpl implements MyService {
	
	@Autowired
	private MyDao dao;

	@Override
	public List list() {
		return dao.list();
	}

	@Override
	public List toadd() {
		return dao.toadd();
	}

	@Override
	public int add(DianYing dianying) {
		return dao.add(dianying);
	}

	@Override
	public DianYing toupd(int id) {
		return dao.toupd(id);
	}

	@Override
	public int upd(DianYing dianying) {
		return dao.upd(dianying);
	}
	
	
}
