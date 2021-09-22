package com.koreait.app.board;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.board.dao.BoardDAO;
import com.koreait.app.board.dao.FileDAO;
import com.koreait.app.board.dao.FileDTO;

public class BoardDeleteOkAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDAO bdao = new BoardDAO();
		FileDAO fdao = new FileDAO();
		int shareboardnum = Integer.parseInt(request.getParameter("shareboardnum"));
		int replyCnt = bdao.getReplyCnt(shareboardnum);
		boolean flag = false;
		boolean fflag = false;
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		String saveFolder = "C:\\file";
		if (replyCnt != 0) {
			flag = bdao.deleteReplyAll(shareboardnum);
		}
		// 해당 게시글에 올라온 파일들의 정보를 담은 dto 가져오기
		List<FileDTO> files = fdao.getFiles(shareboardnum);
		if (files.size() > 0) {
			for (FileDTO f : files) {
				// dto에서 파일 꺼내오기
				File file = new File(saveFolder, f.getShareboardfilename());
				if (file.exists()) {
					file.delete();
				}
				// db에서도 삭제해오기
				fflag = fdao.deleteFileByName(f.getShareboardfilename());
				if (!fflag) {
					// db에서 파일 삭제 실패
					break;
				}
			}
		}
		//댓글 없을 경우
		if (!flag) {
			flag = true;
		}
		//파일 없을 경우
		if (!fflag) {
			fflag = true;
		}

		if (!flag || !fflag) {
			forward.setPath(request.getContextPath() + "/app/board/BoardList.bo?delete=false");
			return forward;
		}
		if (bdao.deleteBoard(shareboardnum)) {
			forward.setPath(request.getContextPath() + "/app/board/BoardList.bo");
		} else {
			forward.setPath(request.getContextPath() + "/app/board/BoardList.bo?delete=false");
		}
		return forward;
	}
}
