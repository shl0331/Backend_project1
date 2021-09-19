package com.koreait.app.recipe.dao;

public class RecipeStepDTO {
	private int recipeStepSeq;
	private int recipeNum;
	private String recipeStepImg;
	private String recipeStepText;
	
	
	public RecipeStepDTO() {
	}


	public RecipeStepDTO(int recipeStepSeq, int recipeNum, String recipeStepImg, String recipeStepText) {
		super();
		this.recipeStepSeq = recipeStepSeq;
		this.recipeNum = recipeNum;
		this.recipeStepImg = recipeStepImg;
		this.recipeStepText = recipeStepText;
	}


	public int getRecipeStepSeq() {
		return recipeStepSeq;
	}


	public void setRecipeStepSeq(int recipeStepSeq) {
		this.recipeStepSeq = recipeStepSeq;
	}


	public int getRecipeNum() {
		return recipeNum;
	}


	public void setRecipeNum(int recipeNum) {
		this.recipeNum = recipeNum;
	}


	public String getRecipeStepImg() {
		return recipeStepImg;
	}


	public void setRecipeStepImg(String recipeStepImg) {
		this.recipeStepImg = recipeStepImg;
	}


	public String getRecipeStepText() {
		return recipeStepText;
	}


	public void setRecipeStepText(String recipeStepText) {
		this.recipeStepText = recipeStepText;
	}
	
	
	
}
