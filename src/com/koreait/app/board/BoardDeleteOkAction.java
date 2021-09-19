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
		// �빐�떦 寃뚯떆湲��뿉 �삱�씪�� �엳�뒗 �뙆�씪�뱾�쓽 �젙蹂대�� �떞�� DTO�뱾 �떎 寃��깋�빐�삤湲�
		List<FileDTO> files = fdao.getFiles(shareboardnum);
		if (files.size() > 0) {
			// 寃��깋�맂 臾댁뼵媛�媛� �엳�떎硫�
			for (FileDTO f : files) {
				// �빐�떦 DTO�뱾 �븯�굹�뵫 爰쇰궡�삤硫댁꽌, �떎議댄븯�뒗 �뙆�씪 媛앹껜 留뚮뱾湲�
				File file = new File(saveFolder, f.getShareboardfilename());
				if (file.exists()) {
					// �떎�젣 �뙆�씪�씠 �엳�떎硫� 吏��썙二쇨린
					file.delete();
				}
				// 爰쇰궡�삩 DTO�쓽 �떎議댄뙆�씪�� �궘�젣�릺�뿀�쑝誘�濡� DB�뿉�꽌�룄 �궘�젣�빐二쇨린
				fflag = fdao.deleteFileByName(f.getShareboardfilename());
				if (!fflag) {
					// DB�뿉�꽌 File�젙蹂� 吏��슦湲� �떎�뙣�뻽�떎硫� for臾� �깉異� �썑 �궘�젣 吏꾪뻾 硫덉텛湲�
					break;
				}
			}
		}
		if (!flag) {
			flag = true;
		}
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
