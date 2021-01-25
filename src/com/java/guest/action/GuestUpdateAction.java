package com.java.guest.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.command.CommandAction;
import com.java.guest.dao.GuestDao;
import com.java.guest.dto.GuestDto;

public class GuestUpdateAction implements CommandAction {

	@Override
	public String actionDo(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		int num = Integer.parseInt(request.getParameter("num"));
		System.out.println(num);
		
		GuestDto guestDto = GuestDao.getInstance().upSelect(num);
		System.out.println(guestDto.toString());
		
		request.setAttribute("guestDto", guestDto);
		
		return "/WEB-INF/views/guest/update.jsp";
	}

}
