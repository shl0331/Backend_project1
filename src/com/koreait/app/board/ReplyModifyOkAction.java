package com.koreait.app.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.board.dao.BoardDAO;

public class ReplyModifyOkAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDAO bdao = new BoardDAO();
		request.setCharacterEncoding("UTF-8");
		int shareboardnum = Integer.parseInt(request.getParameter("shareboardnum"));
		String num = request.getParameter("num");
		String sharereplycontents = request.getParameter("reply"+num);
		int sharereplynum = Integer.parseInt(request.getParameter("sharereplynum"));
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		if(bdao.modifyReply(sharereplynum,sharereplycontents)) {
			forward.setPath(request.getContextPath()+"/app/board/BoardView.bo?shareboardnum="+shareboardnum);
		}else {
			forward.setPath(request.getContextPath()+"/app/board/BoardView.bo?update=false&shareboardnum="+shareboardnum);
		}
		return forward;
	}
}
