package com.java.guest.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.command.CommandAction;
import com.java.guest.dao.GuestDao;
import com.java.guest.dto.GuestDto;

public class GuestWriteAction implements CommandAction {

	@Override
	public String actionDo(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// writeAction --> write.jps 호출 해 줄때 작성/리스트  출력 해 준다
		// 페이지당 게시물 출력 10개 1page 1~10, 2page 11~20
		
		ArrayList<GuestDto> guestList = GuestDao.getInstance().getGuestList();
		
		if(guestList != null) {
			System.out.println("ArrayList 사이즈 : " + guestList.size());
			request.setAttribute("guestList", guestList);
		}
		
		
		return "/WEB-INF/views/guest/write.jsp";
	}

}
