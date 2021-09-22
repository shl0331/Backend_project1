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
	
	public int getBoardCnt() {
		return sqlsession.selectOne("Board.getBoardCnt");
	}
	
	public List<BoardDTO> getBoardList(int startRow, int endRow) {
		HashMap<String, Integer> datas = new HashMap<>();
		datas.put("startRow", startRow);
		datas.put("endRow", endRow);
		List<BoardDTO> boardList = sqlsession.selectList("Board.getBoardList",datas);
		return boardList;
	}
	
	public boolean insertBoard(BoardDTO board) {
		return 1==sqlsession.insert("Board.insertBoard",board);
	}
	
	public BoardDTO getDetail(int shareboardnum) {
		return sqlsession.selectOne("Board.getDetail",shareboardnum);
	}
	
	public void updateReadCount(int shareboardnum) {
		sqlsession.update("Board.updateReadCount",shareboardnum);
	}
	
	public boolean updateBoard(BoardDTO board) {
		return 1 == sqlsession.update("Board.updateBoard",board);
	}
	
	public boolean insertReply(ReplyDTO reply) {
		return 1==sqlsession.insert("Board.insertReply",reply);
	}
	
	public List<ReplyDTO> getReplys(int shareboardnum) {
		List<ReplyDTO> replys = sqlsession.selectList("Board.getReplys",shareboardnum);
		return replys;
	}
	
	public boolean modifyReply(int sharereplynum, String sharereplycontents) {
		HashMap<String, Object> datas = new HashMap<>();
		datas.put("sharereplynum", sharereplynum);
		datas.put("sharereplycontents", sharereplycontents);
		return 1==sqlsession.update("Board.modifyReply",datas);
	}
	
	public boolean deleteReply(int sharereplynum) {
		return 1 == sqlsession.delete("Board.deleteReply",sharereplynum);
	}
	
	public boolean deleteReplyAll(int shareboardnum) {
		return 0!=sqlsession.delete("Board.deleteReplyAll",shareboardnum);
	}
	 
	public int getReplyCnt(int shareboardnum) {
		return (Integer)sqlsession.selectOne("Board.getReplyCnt", shareboardnum);
	}
	
	public boolean deleteBoard(int shareboardnum) {
		return 1==sqlsession.delete("Board.deleteBoard",shareboardnum);
	}
	
	public int getSeq(String memberid) {
		return (Integer)sqlsession.selectList("Board.getSeq",memberid).get(0);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
