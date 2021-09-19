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
			//諛⑷툑 �닔�젙�쓣 �넻�빐�꽌 �삱由� �뙆�씪�쓽 �떆�뒪�뀥�꽕�엫 諛곗뿴
			String[] filename= {multi.getFilesystemName("file1"),multi.getFilesystemName("file2")};
			//諛⑷툑 �닔�젙�쓣 �넻�빐�꽌 �삱由� �뙆�씪�쓽 �썝�옒 �씠由� 諛곗뿴
			String[] realname = {multi.getOriginalFileName("file1"),multi.getOriginalFileName("file2")};
			//�썝�옒 �씠 湲��뿉 �벑濡앸릺�뼱�엳�뜕 �뙆�씪�뱾�쓽 �젙蹂대뱾
			List<FileDTO> files = fdao.getFiles(shareboardnum);
			//�깉濡�寃뚯삱由�(�샊�� �닔�젙�씠 �븞�맂) �뙆�씪�뱾�쓽 �썝�옒 �씠由� 諛곗뿴
			String[] filenames = multi.getParameterValues("shareboardrealname");
			
			
			if(filename == null || realname == null || filenames == null) {
				System.out.println("첨부된 파일이 없습니다.");
			}else {			
				//�삱由� �뙆�씪�뱾�쓽 媛쒖닔瑜� �뙆�븙�븯湲� �쐞�븳 濡쒖쭅
				int cnt=0;
				for(int i=0;i<filenames.length;i++) {
					if(filenames[i] != null && !filenames[i].equals("")) {
						cnt++;
					}
				}
				//�삱由� �뙆�씪�뱾�쓽 媛쒖닔留뚰겮 諛섎났�븯硫댁꽌
				for (int i = 0; i < cnt; i++) {
					if(filename[i] == null) {
					}else {
						if(files.size()>=cnt) {
							//湲곗〈�뿉 議댁옱�븯�뜕 �뙆�씪�쓣 媛앹껜濡� 遺덈윭�삤湲�
							File file = new File(saveFolder,files.get(i).getShareboardfilename());
							//�떎�젣 �쐞移섏뿉 洹� �뙆�씪�씠 議댁옱�븳�떎硫�
							if(file.exists()) {
								//�빐�떦 �뙆�씪 �궘�젣
								file.delete();
							}
							//�떎�젣 �뙆�씪�씠 �궘�젣�릺�뿀�쑝誘�濡� DB�긽�뿉�꽌�룄 �젙蹂대�� 吏��썙以섏빞 �븳�떎.
							fdao.deleteFileByName(files.get(i).getShareboardfilename());
						}
						//DB�뿉 �깉濡�寃� �삱由� �뙆�씪�쓽 �젙蹂대�� �벑濡앺븯�뒗 怨쇱젙
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
