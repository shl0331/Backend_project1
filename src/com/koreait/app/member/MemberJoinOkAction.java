package com.koreait.app.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.member.dao.UserDAO;
import com.koreait.app.member.dao.UserDTO;

public class MemberJoinOkAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		UserDAO udao = new UserDAO();
		UserDTO user = new UserDTO();
		user.setMemberid(request.getParameter("memberid"));
		user.setMemberpw(request.getParameter("memberpw"));
		user.setMembername(request.getParameter("membername"));
		user.setMemberage(Integer.parseInt(request.getParameter("memberage")));
		user.setMemberphone(request.getParameter("memberphone"));
		user.setMembernickname(request.getParameter("membernickname"));
		user.setMemberemail(request.getParameter("memberemail"));
		user.setZipcode(request.getParameter("zipcode"));
		user.setUseraddr(request.getParameter("useraddr"));
		user.setUseraddrdetail(request.getParameter("useraddrdetail"));
		user.setUseraddretc(request.getParameter("useraddretc"));
		ActionForward forward=null;
		if(udao.join(user)) {
			
			forward = new ActionForward(true, request.getContextPath()+"/app/member/loginview.jsp");
		}
		return forward;
	}

}
