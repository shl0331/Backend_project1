package com.koreait.app.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.ActionForward;

public class MemberFrontController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req,resp);
	}
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = requestURI.substring(contextPath.length());
		System.out.println(command);
		ActionForward forward = null;
		
		switch(command) {
		case "/app/member/MemberJoinOk.mb":
			//�쉶�썝媛��엯
			try {
				forward = new MemberJoinOkAction().execute(req, resp);
			} catch (Exception e) {
				System.out.println("MemberJoinOk : "+e);
			}
			break;
		case "/app/member/CheckIdOk.mb":
			try {
				forward = new MemberCheckIdOkAction().execute(req,resp);
			} catch (Exception e) {
				System.out.println("CheckIdOk : "+e);
			}
			break;
		case "/app/member/MemberLoginOk.mb":
			try {
				forward = new MemberLoginOkAction().execute(req,resp);
			} catch (Exception e) {
				System.out.println("MemberLoginOk : "+e);
			}
			break;
		case "/app/member/MemberLogin.mb":
			forward = new ActionForward(false, "/app/member/loginview.jsp");
			break;
		case "/app/member/MemberJoin.mb":
			forward = new ActionForward(false, "/app/member/joinview.jsp");
			break;
		case "/app/member/MemberLogoutOk.mb":
			req.getSession().setAttribute("login_id", null);
			forward = new ActionForward(false, "/app/member/index.jsp");
			break;
		case "/app/user/userMyPage.mb":
			forward= new ActionForward(false, "/app/member/mypageview.jsp");
			break;
		case "/app/member/MemberLogOut.mb":
			req.getSession().invalidate(); 
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath(req.getContextPath()+"/app/index.jsp");
			break;
		case "/app/member/myRecipeList.mb":
			try {
				forward= new MyRecipeListAction().execute(req, resp);
			} catch (Exception e) {
				System.out.println("MyRecipeListAction"+e);
				e.printStackTrace();
			}
			break;
		}
		
		if(forward!=null) { 
			if(forward.isRedirect()) {
				resp.sendRedirect(forward.getPath());
			}else {
				RequestDispatcher disp = req.getRequestDispatcher(forward.getPath());
				disp.forward(req, resp);
			}
		}
	}
	
	
}
