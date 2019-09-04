package com.mb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mb.bean.DianYing;
import com.mb.service.MyService;
import com.mb.utils.PageHelpUtil;

@Controller
public class MyController {
	
	@Autowired
	private MyService service;
	
	
	//列表
	@RequestMapping("list")
	public String list(Model m,@RequestParam(defaultValue="1")int page){
			
		PageHelper.startPage(page,3);
		
		List list= service.list();
		PageInfo<DianYing> pageInfo=new PageInfo<DianYing>(list);
		String page2 = PageHelpUtil.page("list", pageInfo, null);
		
		/*for (Object object : list) {
			System.out.println(object);
		}*/
		m.addAttribute("list", list);
		m.addAttribute("pageInfo", pageInfo);
		m.addAttribute("page2", page2);
		return "list";
	}
	
	//查找类型
	@RequestMapping("toadd.do")
	@ResponseBody
	public Object toadd(){
		List list= service.toadd();
		
		/*for (Object object : list) {
			System.out.println(object);
		}*/
		return list;
	}
	
	//添加
	@RequestMapping("add.do")
	@ResponseBody
	public Object add(DianYing dianying){
		int i= service.add(dianying);
		return i;
	}
	
	@RequestMapping("toupd.do")
	@ResponseBody
	public Object toupd(int id){
		System.out.println("111"+id);
		DianYing  dainying= service.toupd(id);
		System.out.println(dainying);
		return dainying;
	}
	
	@RequestMapping("upd.do")
	@ResponseBody
	public Object upd(DianYing dianying){
		System.out.println(dianying);
		int  i= service.upd(dianying);
		System.out.println(i);
		return i;
	}
	
	
	
	
}
