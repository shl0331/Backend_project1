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
		
		//파일 경로
		String saveFolder = "C:\\file";
		int size = 5*1024*1024;
		System.out.println(saveFolder);
		
		//form에서 enctype를 multipart/form-data 로 보냈다면 필요한 객체
		MultipartRequest multi = new MultipartRequest(request, saveFolder,
				size,"UTF-8",new DefaultFileRenamePolicy());
		
		boolean fcheck1 = false;
		boolean fcheck2 = false;
		
		// 파일을 올렸을 때 이름이 바껴서 저장된 이름 가져오기
		String filename1 = multi.getFilesystemName("file1");
		if(filename1 == null) {
			fcheck1 = true;
		}
		// 파일을 올렸을 때 원본으로 저장된 이름 가져오기
		String orgname1 = multi.getOriginalFileName("file1");
		
		String filename2 = multi.getFilesystemName("file2");
		if(filename2 == null) {
			fcheck2 = true;
		}
		String orgname2 = multi.getOriginalFileName("file2");
		
		//form에서 multipart/form-data로 보냈다면 request.~~을 할 수 없고 위에서 만들어준 MultipartRequest 객체로 데이터들을 받아야 한다. 
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
			// 현재 추가된 게시글 번호
			int shareboardnum = bdao.getSeq(memberid);
			
			if(!fcheck1) {
				FileDTO file = new FileDTO();
				file.setShareboardnum(shareboardnum);
				file.setShareboardfilename(filename1);
				file.setShareboardrealname(orgname1);

				fcheck1 = fdao.insertFile(file);
			}
			if(!fcheck2) {
				FileDTO file = new FileDTO();
				file.setShareboardnum(shareboardnum);
				file.setShareboardfilename(filename2);
				file.setShareboardrealname(orgname2);

				fcheck2 = fdao.insertFile(file);
			}
			
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
