package com.koreait.app.recipe;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.recipe.dao.RecipeDAO;

public class RecipeDeleteAction implements Action{
   @Override
   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      RecipeDAO rdao = new RecipeDAO();
      int recipenum = Integer.parseInt(request.getParameter("recipenum"));
      int fileCnt = rdao.getFileCnt(recipenum);
      
      boolean flag = false;
      ActionForward forward = new ActionForward();
      forward.setRedirect(true);
      if(fileCnt != 0) {
         flag = rdao.deleteFileAll(recipenum);
      }
      if(!flag) {
         forward.setPath(request.getContextPath()+"/recipe/RecipeList.rc?delete=false");
         return forward;
      }
      if(rdao.deleteRecipe(recipenum)) {
         forward.setPath(request.getContextPath()+"/recipe/RecipeList.rc");
      }else {
         forward.setPath(request.getContextPath()+"/recipe/RecipeList.rc?delete=false");
      }
      return forward;
   }
}