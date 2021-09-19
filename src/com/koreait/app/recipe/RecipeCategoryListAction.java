package com.koreait.app.recipe;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.recipe.dao.RecipeDAO;
import com.koreait.app.recipe.dao.RecipeDTO;

public class RecipeCategoryListAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String memberId = (String)request.getSession().getAttribute("memberid");
		RecipeDAO rdao =new RecipeDAO();
		String category = request.getParameter("recipeCategory");
		System.out.println(memberId);
		ActionForward forward = new ActionForward();
			if(category != null) {
				request.setAttribute("recipeList", rdao.getCategoryList(category));
			}
		else {
			request.setAttribute("recipeList", rdao.getAllList());
		}
			forward.setRedirect(false);
			forward.setPath("/app/recipe/recipeList.jsp");
		return forward;
	}
}
