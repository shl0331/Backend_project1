package com.koreait.app.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.board.dao.BoardDAO;
import com.koreait.app.board.dao.BoardDTO;
import com.koreait.app.board.dao.FileDAO;
import com.koreait.app.board.dao.FileDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BoardWriteOkAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDAO bdao = new BoardDAO();
		FileDAO fdao = new FileDAO();
		request.setCharacterEncoding("UTF-8");
		
		//�뙆�씪�씠 ���옣�맆 寃쎈줈
		String saveFolder = "C:\\file";
		int size = 5*1024*1024;
		System.out.println(saveFolder);
		
		//form�뿉�꽌 enctype�쓣 multipart/form-data 濡� 蹂대깉�떎硫� �븘�슂�븳 媛앹껜
		MultipartRequest multi = new MultipartRequest(request, saveFolder,
				size,"UTF-8",new DefaultFileRenamePolicy());
		
		boolean fcheck1 = false;
		boolean fcheck2 = false;
		
		//�뙆�씪�쓣 �삱�졇�쓣 �븣 �떎�젣 �꽌踰꾩뿉 ���옣�릺�뼱 �엳�뒗 �뙆�씪�쓽 �씠由�
		String filename1 = multi.getFilesystemName("file1");
		if(filename1 == null) {
			//file1 �깭洹몄뿉 �븘臾� �뙆�씪�룄 �뾽濡쒕뱶 �븯吏� �븡��寃쎌슦
			fcheck1 = true;
		}
		//�뙆�씪�쓣 �삱由� �븣 �궗�슜�옄媛� �삱�졇�뜕 �씠由�(�떎�슫濡쒕뱶�떆�뿉�뒗 �씠 �씠由꾩쑝濡� �떎�슫濡쒕뱶 �릺寃� �빐�빞�븿)
		String orgname1 = multi.getOriginalFileName("file1");
		
		String filename2 = multi.getFilesystemName("file2");
		if(filename2 == null) {
			//file2 �깭洹몄뿉 �븘臾� �뙆�씪�룄 �뾽濡쒕뱶 �븯吏� �븡��寃쎌슦
			fcheck2 = true;
		}
		String orgname2 = multi.getOriginalFileName("file2");
		
		//fcheck1�씠�굹 fcheck2媛� false濡� �궓�븘�엳�떎硫� �뼱�뼡 �뙆�씪�쓣 �삱�졇�떎�뒗 �쑜
		//multipart/form-data 濡� 蹂대깉�떎硫� request媛� �븘�땲�씪 �쐞�뿉�꽌 留뚮뱾�뼱以� MultipartRequest 媛앹껜濡�
		//蹂대궡以� �뜲�씠�꽣�뱾�쓣 諛쏆븘�빞 �븳�떎.
		String shareboardtitle = multi.getParameter("shareboardtitle");
		String shareboardcontents = multi.getParameter("shareboardcontents");
		String memberid = multi.getParameter("memberid");
		String useraddr = multi.getParameter("useraddr");
		
		BoardDTO board = new BoardDTO();
		board.setShareboardtitle(shareboardtitle);
		board.setShareboardcontents(shareboardcontents);
		board.setMemberid(memberid);
		board.setUseraddr(useraddr);
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		
		if(bdao.insertBoard(board)) {
			//�쁽�옱 異붽��맂 蹂대뱶 踰덊샇(�빐�떦 �뙆�씪�뱾�씠 �삱�씪媛��엳�뒗 寃뚯떆湲� 踰덊샇)
			int shareboardnum = bdao.getSeq(memberid);
			
			if(!fcheck1) {
				FileDTO file = new FileDTO();
				file.setShareboardnum(shareboardnum);
				file.setShareboardfilename(filename1);
				file.setShareboardrealname(orgname1);
				//DB�뿉�떎媛� �뙆�씪 �젙蹂� 異붽�
				//�뙆�씪 �젙蹂대�� �뵒鍮꾩뿉 異붽� �떆�룄(�떎�뙣�뻽�떎硫� fcheck1�씠 false濡� �궓�븘�엳�쓬 / �꽦怨듭씠�씪硫� true濡� 諛붾��)
				fcheck1 = fdao.insertFile(file);
			}
			if(!fcheck2) {
				FileDTO file = new FileDTO();
				file.setShareboardnum(shareboardnum);
				file.setShareboardfilename(filename2);
				file.setShareboardrealname(orgname2);
				//DB�뿉�떎媛� �뙆�씪 �젙蹂� 異붽�
				fcheck2 = fdao.insertFile(file);
			}
			
			//fcheck1怨� fcheck2媛� �몮�떎 true�씪�뒗 �쑜�� �븘臾� �뙆�씪�룄 �븞�삱�졇嫄곕굹, �뙆�씪 �뾽濡쒕뱶瑜� �꽦怨듯븳 寃쎌슦
			if(fcheck1 && fcheck2) {
				forward.setPath(request.getContextPath()+"/app/board/BoardView.bo?shareboardnum="+shareboardnum);
			}else {
				forward.setPath(request.getContextPath()+"/app/board/BoardList.bo?flag=false");
				bdao.deleteBoard(shareboardnum);
			}
		}else {
			forward.setPath(request.getContextPath()+"/app/board/BoardList.bo?flag=false");
		}
		return forward;
	}
}
