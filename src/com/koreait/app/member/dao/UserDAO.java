package com.koreait.app.member.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.koreait.app.member.dao.UserDTO;
import com.koreait.mybatis.SqlMapConfig;

public class UserDAO {
	SqlSessionFactory factory = SqlMapConfig.getFactory();
	SqlSession sqlsession;
	
	public UserDAO() {
	sqlsession = factory.openSession(true);
	}
	
	public boolean checkId(String memberid) {
		int result = 0;
		result = sqlsession.selectOne("Member.checkId", memberid);
		return result == 0;
	}
	public boolean join(UserDTO member) {
		return 1==sqlsession.insert("Member.join",member);
	}
	public boolean login(String memberid,String memberpw) {
		HashMap<String, String> datas = new HashMap<>();
		datas.put("memberid", memberid);
		datas.put("memberpw", memberpw);
		
		return 1 == (Integer)sqlsession.selectOne("Member.login",datas);
	}
	
	public UserDTO getDetail(String member_id) {
		return sqlsession.selectOne("Member.getDetail", member_id);
	}
}
