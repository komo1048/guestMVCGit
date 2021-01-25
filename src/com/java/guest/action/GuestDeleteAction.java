package com.java.guest.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.command.CommandAction;
import com.java.guest.dao.GuestDao;

public class GuestDeleteAction implements CommandAction {

	@Override
	public String actionDo(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		int num = Integer.parseInt(request.getParameter("num"));
		System.out.println(num);
		
		int check=GuestDao.getInstance().delete(num);
		System.out.println("check : "+ check);
		
		request.setAttribute("check", check);
		return "/WEB-INF/views/guest/delete.jsp";
	}

}
