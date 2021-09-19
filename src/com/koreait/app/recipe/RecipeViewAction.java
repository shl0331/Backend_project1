package com.koreait.app.recipe;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.member.dao.UserDTO;
import com.koreait.app.recipe.dao.RecipeDAO;
import com.koreait.app.recipe.dao.RecipeDTO;
import com.koreait.app.recipe.dao.RecipeFileDAO;
import com.koreait.app.recipe.dao.RecipeStepDTO;

public class RecipeViewAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		ActionForward forward = new ActionForward();
		RecipeDAO rdao = new RecipeDAO();
		RecipeFileDAO rfdao = new RecipeFileDAO();
		HttpSession session = request.getSession();
		RecipeStepDTO rfdto = new RecipeStepDTO();
		UserDTO user = (UserDTO) session.getAttribute("session");
		System.out.println(user.getMemberid());
		System.out.println("여기");
		//내가 선택한 레시피 번호 가져오기
		int recipeNum= Integer.parseInt(request.getParameter("recipeNum"));
		System.out.println(recipeNum);
		//내거 선택한 레시프 메인 정보 가져오기
		RecipeDTO recipe = rdao.getSelectRecipe(recipeNum);
		System.out.println("레시피 이름 :"+recipe.getRecipeName());
		System.out.println("recipe 카테고리 :"+recipe.getRecipeCategory());
		request.setAttribute("selectRecipe", recipe);
	
		//내가 선택한 레시피의 step가져오기
		//1.내가 선택한 레시피의 step갯수 가져오기
		int recipeStepCnt=rdao.getCntStep(recipeNum);
		System.out.println(recipeStepCnt);
		//레시피 스텝갯수가 0이 아니면 스텝이 있으므로 db에서 스텝가져오기
		if(recipeStepCnt>0) {
			List<RecipeStepDTO> recipeStepList=rdao.recipeStepAll(recipeNum);
			for (RecipeStepDTO recipeStep: recipeStepList) {
				System.out.println(recipeStep.getRecipeStepImg());
				System.out.println(recipeStep.getRecipeStepText());
			}
			request.setAttribute("stepRecipeList",recipeStepList);
		}
		forward.setPath("/app/recipe/recipeView.jsp");
		forward.setRedirect(false);
		return forward;
	}
}
