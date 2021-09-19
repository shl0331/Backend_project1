package com.koreait.app.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.ActionForward;

public class BoardFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String requestURI = req.getRequestURI(); 
		String contextPath = req.getContextPath(); 
		String command = requestURI.substring(contextPath.length());// /user/UserJoin.us
		System.out.println(command);
		ActionForward forward = null;
		switch(command) {
		case "/app/board/BoardList.bo":
			try {
				forward = new BoardListAction().execute(req,resp);
			} catch (Exception e) {
				System.out.println("BoardList : "+e);
			}
			break;
		case "/app/board/BoardWrite.bo":
			forward = new ActionForward(false,"/app/board/writeview.jsp");
			req.setAttribute("page", req.getParameter("page"));
			break;
		case "/app/board/BoardWriteOk.bo":
			try {
				forward = new BoardWriteOkAction().execute(req,resp);
			} catch (Exception e) {
				System.out.println("BoardWriteOk : "+e);
			}
			break;
		case "/app/board/BoardView.bo":
			try {
				forward = new BoardViewAction().execute(req,resp);
			} catch (Exception e) {
				System.out.println("BoardView : "+e);
			}
			break;
		case "/app/board/BoardModify.bo":
			try {
				forward = new BoardModifyAction().execute(req,resp);
			} catch (Exception e) {
				System.out.println("BoardModify : "+e);
			}
			break;
		case "/app/board/BoardModifyOk.bo":
			try {
				forward = new BoardModifyOkAction().execute(req,resp);
			} catch (Exception e) {
				System.out.println("BoardModifyOk : "+e);
			}
			break;
		case "/app/board/ReplyWriteOk.bo":
			try {
				forward = new ReplyWriteOkAction().execute(req,resp);
			} catch (Exception e) {
				System.out.println("ReplyWriteOk : "+e);
				e.printStackTrace();
			}
			break;
		case "/app/board/ReplyModifyOk.bo":
			try {
				forward = new ReplyModifyOkAction().execute(req,resp);
			} catch (Exception e) {
				System.out.println("ReplyModifyOk : "+e);
			}
			break;
		case "/app/board/ReplyDeleteOk.bo":
			try {
				forward = new ReplyDeleteOkAction().execute(req,resp);
			} catch (Exception e) {
				System.out.println("ReplyDeleteOk : "+e);
			}
			break;
		case "/app/board/BoardDeleteOk.bo":
			try {
				forward = new BoardDeleteOkAction().execute(req,resp);
			} catch (Exception e) {
				System.out.println("BoardDeleteOk : "+e);
			}
			break;
		case "/app/board/FileDownload.bo":
			try {
				new FileDownloadAction().execute(req,resp);
			} catch (Exception e) {
				System.out.println("FileDownload : "+e);
			}
			break;
		}
		
		if(forward!=null) {
			if(forward.isRedirect()) {
				//Redirect
				resp.sendRedirect(forward.getPath());
			}else {
				//Forward
				RequestDispatcher disp = req.getRequestDispatcher(forward.getPath());
				disp.forward(req, resp);
			}
		}
	}
}
