package com.koreait.app.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.member.dao.UserDAO;
import com.koreait.app.member.dao.UserDTO;

public class MemberLoginOkAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		ActionForward forward = new ActionForward();
		UserDAO udao = new UserDAO();
		HttpSession session = request.getSession();
		String memberid = request.getParameter("memberid");
		String memberpw = request.getParameter("memberpw");
		
		
		if(udao.login(memberid, memberpw)) {
			System.out.println("1");
			session.setAttribute("session", udao.getDetail(memberid));
			forward = new ActionForward(true, request.getContextPath()+"/app/index.jsp");
		}else {
			System.out.println("2");
			forward = new ActionForward(true, request.getContextPath()+"/app/member/MemberLogin.mb"); 
			System.out.println("123");
		}	
		return forward;
	}
}
