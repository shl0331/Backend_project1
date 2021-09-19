package com.koreait.app.recipe.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.koreait.mybatis.SqlMapConfig;

public class RecipeFileDAO {
	SqlSessionFactory factory = SqlMapConfig.getFactory();
	SqlSession sqlsession;
	
	public RecipeFileDAO() {
		sqlsession = factory.openSession(true);
	}
	//파일 db에 저장
	public boolean insertFile(RecipeStepDTO recipeFile) {
		return 1 == sqlsession.insert("File.insertRecipeFile",recipeFile);
	}
}
