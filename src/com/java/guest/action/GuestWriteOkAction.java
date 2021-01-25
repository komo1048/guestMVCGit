package com.java.guest.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.command.CommandAction;
import com.java.guest.dao.GuestDao;
import com.java.guest.dto.GuestDto;

public class GuestWriteOkAction implements CommandAction {

	@Override
	public String actionDo(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		GuestDto guestDto = new GuestDto();
		
		guestDto.setName(request.getParameter("name"));
		guestDto.setPassword(request.getParameter("password"));
		guestDto.setMessage(request.getParameter("message"));
		System.out.println(guestDto.toString());
		
		int check = GuestDao.getInstance().insert(guestDto);
		System.out.println("check : " + check);
		
		request.setAttribute("check", check);
		
		return "/WEB-INF/views/guest/writeOk.jsp";
	}

}
