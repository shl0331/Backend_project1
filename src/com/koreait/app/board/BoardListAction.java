package com.koreait.app.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.board.dao.BoardDAO;

public class BoardListAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String temp = request.getParameter("page");
		BoardDAO bdao = new BoardDAO();
		// 받아온 페이지(보고있던 페이지)
		int page = temp == null?1:Integer.parseInt(temp);
		//1개의 페이지에 띄워줄 게시글 개수
		int pageSize = 10;
		// 전체 게시글
		int totalCnt = bdao.getBoardCnt();
		// 현재 페이지의 마지막 번호(rownum) 
		int endRow = page*pageSize;
		// 현재 페이지의 첫번째 번호(rownum)
		int startRow = endRow-(pageSize-1);
		
		// 현재 페이지에서 보여줄 페이지네이션의 첫번째 페이지
		int startPage = ((page-1)/pageSize)*pageSize+1;
		// 현재 페이지에서 보여줄 페이지네이션의 마지막 페이지
		int endPage = startPage+9;
		// 전체 페이지 수
		int totalPage = (totalCnt-1)/pageSize+1;
		endPage = endPage>totalPage?totalPage:endPage;
		
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("totalCnt", totalCnt);
		request.setAttribute("page", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("boardList", bdao.getBoardList(startRow,endRow));
		ActionForward forward = new ActionForward(false,"/app/board/shareBoard.jsp");
		return forward;
	}
}
