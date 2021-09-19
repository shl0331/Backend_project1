package com.koreait.app.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.board.dao.BoardDAO;
import com.koreait.app.board.dao.ReplyDTO;
import com.koreait.app.member.dao.UserDTO;

public class ReplyWriteOkAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		BoardDAO bdao = new BoardDAO();
		int shareboardnum = Integer.parseInt(request.getParameter("shareboardnum"));
		System.out.println(shareboardnum);
		String sharereplycontents = request.getParameter("sharereplycontents");
		HttpSession session = request.getSession();
		UserDTO userinfo = (UserDTO)session.getAttribute("session");
		ReplyDTO reply = new ReplyDTO();
		reply.setShareboardnum(shareboardnum);
		reply.setSharereplycontents(sharereplycontents);
		reply.setMemberid(userinfo.getMemberid());
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		if(bdao.insertReply(reply)) {
			forward.setPath(request.getContextPath()+"/app/board/BoardView.bo?shareboardnum="+shareboardnum);
		}else {
			forward.setPath(request.getContextPath()+"/app/board/BoardView.bo?reply=false&shareboardnum="+shareboardnum);
		}
		return forward;
	
	}
}
