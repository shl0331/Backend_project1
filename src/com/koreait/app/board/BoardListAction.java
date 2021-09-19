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
		//由ъ뒪�듃�뿉�꽌 蹂댁뿬�떖�씪怨� �슂泥��븳 �럹�씠吏�
		int page = temp == null?1:Integer.parseInt(temp);
		//�븳 �럹�씠吏��뿉 蹂댁뿬吏� 寃뚯떆湲��쓽 媛쒖닔
		int pageSize = 10;
		//�쟾泥� 寃뚯떆湲� 媛쒖닔
		int totalCnt = bdao.getBoardCnt();
		//蹂댁뿬以섏빞�릺�뒗 留덉�留� 寃뚯떆湲��쓽 rownum
		int endRow = page*pageSize;
		//蹂댁뿬以섏빞�릺�뒗 泥ル쾲吏� 寃뚯떆湲��쓽 rownum
		int startRow = endRow-(pageSize-1);
		
		//�븘�옒履� �럹�씠吏뺤쿂由ъ쓽 蹂댁뿬吏��뒗 泥ル쾲吏� �럹�씠吏� 踰덊샇
		int startPage = ((page-1)/pageSize)*pageSize+1;
		//�븘�옒履� �럹�씠吏뺤쿂由ъ쓽 蹂댁뿬吏��뒗 留덉�留� �럹�씠吏� 踰덊샇
		int endPage = startPage+9;
		//媛��옣 留덉�留� �럹�씠吏� 踰덊샇
		int totalPage = (totalCnt-1)/pageSize+1;
		//媛��옣 留덉�留� �럹�씠吏� 踰덊샇蹂대떎 �뿰�궛�쑝濡� 援ы빐吏� endPage媛� �뜑 �겙 寃쎌슦�룄 �엳�떎.
		//洹몃븣�뒗 endPage瑜� 媛��옣 留덉�留� �럹�씠吏�濡� 諛붽씀�뼱以��떎.
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
