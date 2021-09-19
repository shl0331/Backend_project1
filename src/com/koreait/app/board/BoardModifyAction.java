package com.koreait.app.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.board.dao.BoardDAO;
import com.koreait.app.board.dao.BoardDTO;
import com.koreait.app.board.dao.FileDAO;

public class BoardModifyAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDAO bdao = new BoardDAO();
		FileDAO fdao = new FileDAO();
		int shareboardnum = Integer.parseInt(request.getParameter("shareboardnum"));
		BoardDTO board = bdao.getDetail(shareboardnum);
		request.setAttribute("board", board);
		request.setAttribute("files", fdao.getFiles(shareboardnum));
		ActionForward forward = new ActionForward(false, "/app/board/modifyview.jsp");
		return forward;
	}
}
