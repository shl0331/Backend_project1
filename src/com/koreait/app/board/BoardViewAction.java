package com.koreait.app.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.board.dao.BoardDAO;
import com.koreait.app.board.dao.BoardDTO;
import com.koreait.app.board.dao.FileDAO;
import com.koreait.app.member.dao.UserDTO;

public class BoardViewAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDAO bdao = new BoardDAO();
		FileDAO fdao = new FileDAO();
		int shareboardnum = Integer.parseInt(request.getParameter("shareboardnum"));
		HttpSession session = request.getSession();
		UserDTO userinfo = (UserDTO)session.getAttribute("session");
		BoardDTO board = bdao.getDetail(shareboardnum);
		if(!board.getMemberid().equals(userinfo.getMemberid())) {
			bdao.updateReadCount(shareboardnum);
//			board.setReadcount(board.getReadcount()+1);
			board = bdao.getDetail(shareboardnum);
		}
		request.setAttribute("files", fdao.getFiles(shareboardnum));
		request.setAttribute("replys", bdao.getReplys(shareboardnum));
		request.setAttribute("board", board);
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/app/board/boardview.jsp");
		return forward;
	}
}
