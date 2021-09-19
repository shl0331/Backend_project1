package com.koreait.app.board.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.koreait.mybatis.SqlMapConfig;

public class BoardDAO {
	SqlSessionFactory factory = SqlMapConfig.getFactory();
	SqlSession sqlsession;
	public BoardDAO() {
		sqlsession=factory.openSession(true);
	}
	//寃뚯떆湲� 媛��닔 媛��졇�삤湲�
	public int getBoardCnt() {
		return sqlsession.selectOne("Board.getBoardCnt");
	}
	//�쟾泥닿쾶�떆湲� 戮묒븘�삤湲�
	public List<BoardDTO> getBoardList(int startRow, int endRow) {
		HashMap<String, Integer> datas = new HashMap<>();
		datas.put("startRow", startRow);
		datas.put("endRow", endRow);
		List<BoardDTO> boardList = sqlsession.selectList("Board.getBoardList",datas);
		return boardList;
	}
	//寃뚯떆湲� �벑濡앺븯湲�
	public boolean insertBoard(BoardDTO board) {
		return 1==sqlsession.insert("Board.insertBoard",board);
	}
	//寃뚯떆湲� �긽�꽭蹂닿린
	public BoardDTO getDetail(int shareboardnum) {
		return sqlsession.selectOne("Board.getDetail",shareboardnum);
	}
	//寃뚯떆湲� 議고쉶�닔
	public void updateReadCount(int shareboardnum) {
		sqlsession.update("Board.updateReadCount",shareboardnum);
	}
	//寃뚯떆湲� �닔�젙�븯湲�
	public boolean updateBoard(BoardDTO board) {
		return 1 == sqlsession.update("Board.updateBoard",board);
	}
	//寃뚯떆湲� �뙎湲� �엯�젰
	public boolean insertReply(ReplyDTO reply) {
		return 1==sqlsession.insert("Board.insertReply",reply);
	}
	//寃뚯떆湲��뿉�꽌 �뙎湲� �쟾泥� 媛��졇�삤湲�
	public List<ReplyDTO> getReplys(int shareboardnum) {
		List<ReplyDTO> replys = sqlsession.selectList("Board.getReplys",shareboardnum);
		return replys;
	}
	//�뙎湲� �닔�젙�븯湲�
	public boolean modifyReply(int sharereplynum, String sharereplycontents) {
		HashMap<String, Object> datas = new HashMap<>();
		datas.put("sharereplynum", sharereplynum);
		datas.put("sharereplycontents", sharereplycontents);
		return 1==sqlsession.update("Board.modifyReply",datas);
	}
	//�뙎湲� �궘�젣�븯湲�
	public boolean deleteReply(int sharereplynum) {
		return 1 == sqlsession.delete("Board.deleteReply",sharereplynum);
	}
	//�뙎湲� �쟾泥� �궘�젣�븯湲�
	public boolean deleteReplyAll(int shareboardnum) {
		return 0!=sqlsession.delete("Board.deleteReplyAll",shareboardnum);
	}
	//�뙎湲� 媛��닔 
	public int getReplyCnt(int shareboardnum) {
		return (Integer)sqlsession.selectOne("Board.getReplyCnt", shareboardnum);
	}
	//寃뚯떆�뙋 �궘�젣�븯湲�
	public boolean deleteBoard(int shareboardnum) {
		return 1==sqlsession.delete("Board.deleteBoard",shareboardnum);
	}
	//
	public int getSeq(String memberid) {
		return (Integer)sqlsession.selectList("Board.getSeq",memberid).get(0);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
