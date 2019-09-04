package com.mb.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.github.pagehelper.PageInfo;

public class PageHelpUtil {

	/**
	 * 向前台返回分页字符串信息
	 * 
	 * @param url
	 *            Controller中指定
	 * @param pageInfo
	 * @param paramMap
	 *            各种条件拼接
	 * @return
	 */
	public static String page(String url, PageInfo<?> pageInfo, Map<String, Object> paramMap) {
		StringBuffer sb = new StringBuffer();
		// 需要定义表单中的name属性值为map的key
		String param = "";
		if (paramMap != null) {
			Set<String> keySet = paramMap.keySet();
			for (String key : keySet) {
				param += "&" + key + "=" + paramMap.get(key);
			}
		}
		String first = "<a href=" + url + "?page=1" + param + ">首页</a>";
		// 自定义 上一页
		int prePage = 1;
		// 排除首页情况下点击上一页异常
		if (pageInfo.getPageNum() != 1) {
			prePage = pageInfo.getPrePage();
		}
		// 自定义 下一页
		int nextPage = pageInfo.getNextPage();
		// 排除尾页情况下点击下一页异常
		if (pageInfo.getPageNum() == pageInfo.getPages()) {
			nextPage = pageInfo.getPages();
		}

		String prev = "<a href=" + url + "?page=" + prePage + "" + param + ">上一页</a>";
		sb.append(first).append(prev);

		// 若总页数大于十页
		if (pageInfo.getPages() >= 10) {
			if (pageInfo.getPageNum() <= 6) {
				for (int i = 1; i <= 10; i++) {
					if (i == pageInfo.getPageNum()) {
						sb.append("<a href=" + url + "?page=" + i + "" + param
								+ "><button style='border-style: none; '>" + i + "</button></a>");
					} else {
						sb.append("<a href=" + url + "?page=" + i + "" + param
								+ "><button style='border-color:#E0FFFF; background-color: #E0FFFF;'>" + i
								+ "</button></a>");
					}
				}
			} else if (pageInfo.getPages() - pageInfo.getPageNum() <= 4) {
				for (int i = pageInfo.getPages() - 9; i <= pageInfo.getPages(); i++) {
					if (i == pageInfo.getPageNum()) {
						sb.append("<a href=" + url + "?page=" + i + "" + param
								+ "><button style='border-style: none; '>" + i + "</button></a>");
					} else {
						sb.append("<a href=" + url + "?page=" + i + "" + param
								+ "><button style='border-color:#E0FFFF; background-color: #E0FFFF;'>" + i
								+ "</button></a>");
					}
				}
			} else {
				for (int i = pageInfo.getPageNum() - 5; i <= pageInfo.getPageNum() + 4; i++) {
					if (i == pageInfo.getPageNum()) {
						sb.append("<a href=" + url + "?page=" + i + "" + param
								+ "><button style='border-style: none; '>" + i + "</button></a>");
					} else {
						sb.append("<a href=" + url + "?page=" + i + "" + param
								+ "><button style='border-color:#E0FFFF; background-color: #E0FFFF;'>" + i
								+ "</button></a>");
					}
				}
			}
		}
		// 若总页数不大于十页
		else {
			// 有几页来几页
			for (int i = 1; i <= pageInfo.getPages(); i++) {
				sb.append("<a href=" + url + "?page=" + i + "" + param + "><button >" + i + "</button></a>");
			}
		}
		String next = "<a href=" + url + "?page=" + nextPage + "" + param + ">下一页</a>";
		String last = "<a href=" + url + "?page=" + pageInfo.getPages() + "" + param + ">尾页</a>";
		sb.append(next).append(last);
		return sb.toString();
	}

	/*
	 * 
	 */
	public static String bootStrapPage(String url, PageInfo<?> pageInfo, Map<String, Object> paramMap) {
		StringBuffer sb = new StringBuffer();
		// 需要定义表单中的name属性值为map的key
		String param = "";
		if (paramMap != null) {
			Set<String> keySet = paramMap.keySet();
			for (String key : keySet) {
				param += "&" + key + "=" + paramMap.get(key);
			}
		}
		sb.append("<nav aria-label=Page navigation><ul class=pagination><li>");
		String first = "<a aria-label=Previous href=" + url + "?page=1" + param + ">"
				+ "<span aria-hidden=true>&laquo;</span></a>";
		sb.append(first);
		// 若总页数大于十页
				if (pageInfo.getPages() >= 10) {
					if (pageInfo.getPageNum() <= 6) {
						for (int i = 1; i <= 10; i++) {
							if (i == pageInfo.getPageNum()) {
								sb.append("<li class=active><a href=" + url + "?page=" + i + "" + param
										+ ">" + i + "</a></li>");
							} else {
								sb.append("<li><a href=" + url + "?page=" + i + "" + param
										+ ">" + i
										+ "</a></li>");
							}
						}
					} else if (pageInfo.getPages() - pageInfo.getPageNum() <= 4) {
						for (int i = pageInfo.getPages() - 9; i <= pageInfo.getPages(); i++) {
							if (i == pageInfo.getPageNum()) {
								sb.append("<li class=active><a href=" + url + "?page=" + i + "" + param
										+ ">" + i + "</a></li>");
							} else {
								sb.append("<li><a href=" + url + "?page=" + i + "" + param
										+ ">" + i
										+ "</a></li>");
							}
						}
					} else {
						for (int i = pageInfo.getPageNum() - 5; i <= pageInfo.getPageNum() + 4; i++) {
							if (i == pageInfo.getPageNum()) {
								sb.append("<li class=active><a  href=" + url + "?page=" + i + "" + param
										+ ">" + i + "</a></li>");
							} else {
								sb.append("</li><a href=" + url + "?page=" + i + "" + param
										+ ">" + i
										+ "</a></li>");
							}
						}
					}
				}
				// 若总页数不大于十页
				else {
					// 有几页来几页
					for (int i = 1; i <= pageInfo.getPages(); i++) {
						sb.append("<li><a href=" + url + "?page=" + i + "" + param + "><button ></li>" + i + "</button></a>");
					}
				}
		String last = "<a aria-label=Next href=" + url + "?page=" + pageInfo.getNextPage() + "" + param + ""
				+ "><span aria-hidden=true>&raquo;</span></a>";
		sb.append(last);
		return sb.toString();
	}

	/***
	 * 需要定义表单中的name属性值为paramMap的key
	 * 
	 * @param url
	 * @param cpage
	 * @param pageSize
	 * @param count
	 * @param paramMap
	 * @return
	 */
	public static Map<String, Object> pageMap(String url, PageInfo<?> pageInfo, Map<String, Object> paramMap) {
		// 需要定义表单中的name属性值为map的key
		String param = "";
		Set<String> keySet = paramMap.keySet();
		for (String key : keySet) {
			param += "&" + key + "=" + paramMap.get(key);
		}

		String first = "<a href=" + url + "?cpage=1" + param + ">首页</a>";
		String prev = "<a href=" + url + "?cpage=" + pageInfo.getPrePage() + param + ">上一页</a>";
		String next = "<a href=" + url + "?cpage=" + pageInfo.getNextPage() + param + ">下一页</a>";
		String last = "<a href=" + url + "?cpage=" + pageInfo.getLastPage() + param + ">尾页</a>";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cpage", pageInfo.getPageNum());
		map.put("count", pageInfo.getTotal());
		map.put("pagecount", pageInfo.getPages());
		map.put("page", first + " " + prev + " " + next + " " + last);
		return map;
	}

}
