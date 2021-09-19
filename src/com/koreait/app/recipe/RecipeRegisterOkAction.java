package com.koreait.app.recipe;

import java.util.Enumeration;

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
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class RecipeRegisterOkAction implements Action {
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
		String memberid=user.getMemberid();
		System.out.println(user.getMemberid());
		System.out.println("여기");
		
		String saveFolder = request.getServletContext().getRealPath("app/file");
		int size = 5 * 1024 * 1024;
		System.out.println(saveFolder);
		MultipartRequest multi = new MultipartRequest(request, saveFolder, size, "UTF-8",
				new DefaultFileRenamePolicy());
		// 레시피 대표이미지 받기
		String recipeMainImg = multi.getFilesystemName("recipeMainImg");
		System.out.println(recipeMainImg);
		// 레시피 제목 받기
		String recipeName = multi.getParameter("recipeName");
		System.out.println("레시피 제목:  " + recipeName);
		// 레시피 전체 설명받기
		String recipeInfo = multi.getParameter("recipeInfo");
		System.out.println("레시피 기본설명:  " + recipeInfo);
		// 레시피 카테고리 recipeCategory
		String recipeCategory = multi.getParameter("recipeCategory");
		System.out.println("레시피 카테고리: " + recipeCategory);
		// 레시피 먹는 시간때recipeTime
		String recipeTime = multi.getParameter("recipeTime");
		System.out.println("시간 때 : " + recipeTime);
		// db에 데이터를 넣기위해 레시피DTO에 세팅중
		RecipeDTO recipe = new RecipeDTO();
		recipe.setRecipeName(recipeName);
		recipe.setRecipeInfo(recipeInfo);
		recipe.setMemberId(user.getMemberid());
		recipe.setRecipeMainImg(recipeMainImg);
		recipe.setRecipeCategory(recipeCategory);
		recipe.setRecipeTime(recipeTime);
		// rdao.insertRecipe(recipe);
		if (rdao.insertRecipe(recipe)) {
			int recipeNum=rdao.getseq(memberid,recipeName);
			System.out.println(recipeNum);
			System.out.println(request.getContextPath());
			//등록시 레시피 step갯수 (count에 넘어온 갯수의 -1 -1을하는 이유는 내가 밑에 추가하지 않아도 기본설정이 1이기때문에 길이를 정할때 -1을 해야한다)
			int count = Integer.parseInt(multi.getParameter("count"));
			System.out.println(count);
			//내가 입력한 스텝별 설명
			String [] recipeStepTextList=multi.getParameterValues("recipeText");
			//내가 입력한 스텝별 사진 
			Enumeration <String> recipeStepImgList=multi.getFileNames();
			RecipeStepDTO recipeStep=new RecipeStepDTO();
			
				for (int i = 0; i < recipeStepTextList.length; i++) {
					//내가 보내준 태그의 이름 받기
					String recipeStepImgName = (String) recipeStepImgList.nextElement();
					//위에서 받은 태그이름으로 파일 받아오기
					System.out.println(recipeStepImgName);
					String recipeStepImg=multi.getFilesystemName(recipeStepImgName);
					System.out.println(recipeStepImg);
					String recipeStepText=recipeStepTextList[i];
					recipeStep.setRecipeNum(recipeNum);
					recipeStep.setRecipeStepImg(recipeStepImg);
					recipeStep.setRecipeStepText(recipeStepText);
					//insertRecipeStep사용시 성공이면 true로 넘어오는데 false로 넘어올시 true바꾸어서 반복문을 종료한다
					if(!rdao.insertRecipeStep(recipeStep)) {
						break;
					};
				}
			forward.setRedirect(true);
			forward.setPath(request.getContextPath() + "/app/recipe/recipeList.rc");
		}
		System.out.println(forward.getPath());
		return forward;
	}
}
