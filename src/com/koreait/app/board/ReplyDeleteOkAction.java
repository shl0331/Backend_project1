package com.koreait.app.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.board.dao.BoardDAO;

public class ReplyDeleteOkAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDAO bdao = new BoardDAO();
		int sharereplynum = Integer.parseInt(request.getParameter("sharereplynum"));
		String shareboardnum = request.getParameter("shareboardnum");
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		if (bdao.deleteReply(sharereplynum)) {
			forward.setPath(request.getContextPath() + "/app/board/BoardView.bo?shareboardnum=" + shareboardnum);
		} else {
			forward.setPath(request.getContextPath() + "/app/board/BoardView.bo?delete=false&shareboardnum=" + shareboardnum);
		}
		return forward;
	}
}