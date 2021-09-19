package com.koreait.app.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.koreait.mybatis.SqlMapConfig;

public class FileDAO {
	SqlSessionFactory factory = SqlMapConfig.getFactory();
	SqlSession sqlsession;
	
	public FileDAO() {
		sqlsession = factory.openSession(true);
	}
	
	public boolean insertFile(FileDTO file) {
		return 1 == sqlsession.insert("File.insertFile",file);
	}

	public List<FileDTO> getFiles(int shareboardnum) {
		List<FileDTO> files = sqlsession.selectList("File.getFiles",shareboardnum);
		return files;
	}

	public boolean deleteFileByName(String shareboardfilename) {
		return 1==sqlsession.delete("File.deleteFileByName",shareboardfilename);
	}
}
