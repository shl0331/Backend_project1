package com.koreait.app.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.recipe.dao.RecipeDAO;

public class MyRecipeListAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String memberId = (String)request.getSession().getAttribute("memberid");
		RecipeDAO rdao =new RecipeDAO();
		request.setAttribute("recipeList", rdao.getMyRecipeList(memberId));
		
		ActionForward forward = new ActionForward(false, "/app/member/myRecipeList.jsp");
		return forward;
	}
}
