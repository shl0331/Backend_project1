package com.koreait.app.recipe.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.koreait.mybatis.SqlMapConfig;

public class RecipeDAO {
	SqlSessionFactory factory = SqlMapConfig.getFactory();
	SqlSession sqlsession;
	
	public RecipeDAO() {
		sqlsession = factory.openSession(true);
	}
	//내가 선택한 카테고리의 레시피 가져오기
	public List<RecipeDTO> getCategoryList(String category) {
			List<RecipeDTO> recipeList = sqlsession.selectList("recipe.getList", category);
			return recipeList;
	}
	//레시피 전체 목록 가져오기
	public List<RecipeDTO>  getAllList() {
		List<RecipeDTO> recipeList =sqlsession.selectList("recipe.getAllList");
		return recipeList; 
	}
	
	public int getFileCnt(int recipenum) {
	      return (Integer)sqlsession.selectOne("recipe.getFileCnt", recipenum);
	   }
	   public boolean deleteFileAll(int recipenum) {
	      return 0!=sqlsession.delete("recipe.deleteFileAll",recipenum);
	   }
	   public boolean deleteRecipe(int recipenum) {
	      return 1==sqlsession.delete("recipe.deleteRecipe",recipenum);
	   }
	   //내가 등록한 레시피 가져오기
	   public List<RecipeDTO> getMyRecipeList(String memberId) {
			List<RecipeDTO> recipeList =sqlsession.selectList("recipe.getMyRecipeList", memberId);
			return recipeList;
		}
	   //레시피 등록하기
	public boolean insertRecipe(RecipeDTO recipe) {
		return 1==sqlsession.insert("recipe.insertRecipe",recipe);
	}
	//레시피 번호 가져오기
	public int getseq(String memberId, String recipeName) {
		HashMap<String, String> datas = new HashMap<>();
		datas.put("memberId", memberId);
		datas.put("recipeName", recipeName);
		return (Integer)sqlsession.selectOne("recipe.getseq",datas);
 	
	}
	//내가 선택한 레시피 가져오기
	public RecipeDTO getSelectRecipe(int recipeNum) {
		return sqlsession.selectOne("recipe.getSelectRecipe", recipeNum);
	}
	public boolean insertRecipeStep(RecipeStepDTO recipeStep) {
		return 1==sqlsession.insert("recipe.insertRecipeStep", recipeStep);
	}
	//내가 선택한 레시피가 step이 있는지 확인하는 메소드
	public int getCntStep(int recipeNum) {
		return sqlsession.selectOne("recipe.getCntStep", recipeNum);
	}
	//내가 선택한 레시피의 step전체 가져오기
	public List<RecipeStepDTO> recipeStepAll(int recipeNum) {
			List<RecipeStepDTO> recipeStepList =sqlsession.selectList("recipe.recipeStepAll", recipeNum);
		return recipeStepList;
	}
	

}
