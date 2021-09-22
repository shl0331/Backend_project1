package com.koreait.app.board;

import java.io.File;
import java.util.List;

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

public class BoardModifyOkAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		BoardDAO bdao = new BoardDAO();
		FileDAO fdao = new FileDAO();
		String saveFolder = "C:\\file";
		int size = 5*1024*1024;
		MultipartRequest multi = new MultipartRequest(request, saveFolder,size,"UTF-8",new DefaultFileRenamePolicy());
		
		String shareboardtitle = multi.getParameter("shareboardtitle");
		String useraddr = multi.getParameter("useraddr");
		String shareboardcontents = multi.getParameter("shareboardcontents");
		int shareboardnum = Integer.parseInt(multi.getParameter("shareboardnum"));
		BoardDTO board = new BoardDTO();
		board.setShareboardnum(shareboardnum);
		board.setShareboardtitle(shareboardtitle);
		board.setUseraddr(useraddr);
		board.setShareboardcontents(shareboardcontents);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		if(bdao.updateBoard(board)) {
			// 수정을 통해서 올린 파일 배열 - 이름 바껴서 저장됨
			String[] filename= {multi.getFilesystemName("file1"),multi.getFilesystemName("file2")};
			// 수정을 통해서 올린 파일 - 원래 이름
			String[] realname = {multi.getOriginalFileName("file1"),multi.getOriginalFileName("file2")};
			// 원래 view에 올라와 있던 파일들
			List<FileDTO> files = fdao.getFiles(shareboardnum);
			// 변경할 파일들 원래 이름
			String[] filenames = multi.getParameterValues("shareboardrealname");
			
			
			if(filename == null || realname == null || filenames == null) {
				System.out.println("첨부된 파일이 없습니다.");
			}else {			
				// 기존에 올린 파일수만큼 반복
				int cnt=0;
				for(int i=0;i<filenames.length;i++) {
					if(filenames[i] != null && !filenames[i].equals("")) {
						cnt++;
					}
				}
				// 기존에 올라와 있던 파일 -> 수정된 파일
				for (int i = 0; i < cnt; i++) {
					if(filename[i] == null) {
					
					}else {
						if(files.size()>=cnt) {
							// 기존에 존재하던 파일을 객체로 불러오기
							File file = new File(saveFolder,files.get(i).getShareboardfilename());
							if(file.exists()) {
								file.delete();
							}
							// db상에서 파일 지우기
							fdao.deleteFileByName(files.get(i).getShareboardfilename());
						}
						// 새롭게 올린 파일 db에  등록
						FileDTO fdto = new FileDTO();
						fdto.setShareboardnum(shareboardnum);
						fdto.setShareboardfilename(filename[i]);
						fdto.setShareboardrealname(realname[i]);
						fdao.insertFile(fdto);
					}
				}
			}
			
			forward.setPath(request.getContextPath()+"/app/board/BoardView.bo?shareboardnum="+shareboardnum);
		}else {
			forward.setPath(request.getContextPath()+"/app/board/BoardList.bo?update=false");
		}
		return forward;
	}
}
