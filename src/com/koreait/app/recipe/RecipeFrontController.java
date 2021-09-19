package com.koreait.app.recipe;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.ActionForward;
import com.koreait.app.member.MyRecipeListAction;

public class RecipeFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	protected void doProcess(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException{
		String requestURI = req.getRequestURI(); // 요청한 URI localhost:9090/user/UserJoin.us
		String contextPath = req.getContextPath(); // 최상위 경로 localhost:9090
		String command = requestURI.substring(contextPath.length());// /user/UserJoin.us
		System.out.println(command);
		ActionForward forward = null;
		switch (command) {
		//레시피 목록 보여주기
		case "/app/recipe/recipeList.rc":
			try {
				forward = new RecipeCategoryListAction().execute(req,resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
			//레시피 등록 페이지로 이동
		case "/app/recipe/RecipeRegister.rc":
			forward = new ActionForward(false, "/app/recipe/recipeRegister.jsp");
			break;
			//레시피 등록하기
		case "/recipe/RecipeRegisterOk.rc":	
			try {
				forward = new RecipeRegisterOkAction().execute(req, resp);
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
			break;
			//레시피 삭제
		case "/recipe/recipeDelete.rc":
	         try {
	            forward = new RecipeDeleteAction().execute(req,resp);
	         } catch (Exception e) {
	            System.out.println("RecipeDelete"+e);
	         }
	         break;
	         //레시피 상세보기
		case  "/app/recipe/recipeView.rc":
			try {
				forward= new RecipeViewAction().execute(req, resp);
			} catch (Exception e) {
				System.out.println("recipeView오류"+e);
				e.printStackTrace();
			}
			break;
		}
		if(forward!=null) {
			if(forward.isRedirect()) {
				//redirect 방식
				resp.sendRedirect(forward.getPath());
			}else {
				//forward 방식
				RequestDispatcher dispatcher = req.getRequestDispatcher(forward.getPath());
				dispatcher.forward(req, resp);
			}
		}
	}

}
