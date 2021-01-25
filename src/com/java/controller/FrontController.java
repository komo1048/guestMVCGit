package com.java.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.command.CommandAction;
import com.java.guest.action.GuestDeleteAction;
import com.java.guest.action.GuestUpdateAction;
import com.java.guest.action.GuestWriteAction;
import com.java.guest.action.GuestWriteOkAction;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Object> commandMap = new HashMap<String,Object>();
       
	
	@Override
	public void init() throws ServletException {
		GuestWriteAction guestWrite = new GuestWriteAction();
		commandMap.put("/guest/write.do", guestWrite);
		
		GuestWriteOkAction guestWriteOk = new GuestWriteOkAction();
		commandMap.put("/guest/writeOK.do", guestWriteOk);
		
		GuestDeleteAction guestDelete = new GuestDeleteAction();
		commandMap.put("/guest/delete.do", guestDelete); // 주소값이 들어오면 해당 클래스를 찾아주는 함수
		
		GuestUpdateAction guestUpdate = new GuestUpdateAction();
		commandMap.put("/guest/update.do", guestUpdate);
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getServletPath();
		System.out.println(cmd);
		
		String viewPage=null;
		try {
			CommandAction command = (CommandAction) commandMap.get(cmd);
			
			viewPage = command.actionDo(request, response);
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
		if(viewPage!=null) {
			RequestDispatcher dis = request.getRequestDispatcher(viewPage);
			dis.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
