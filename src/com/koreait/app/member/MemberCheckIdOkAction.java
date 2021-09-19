package com.koreait.app.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.member.dao.UserDAO;

public class MemberCheckIdOkAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		UserDAO udao = new UserDAO();
		String memberid = request.getParameter("memberid");
		PrintWriter out = response.getWriter();
		if(udao.checkId(memberid)) {
			out.write("O");
		}else {
			out.write("X");
		}
		out.close();
		return null;
	}
}
