package com.koreait.app.recipe.dao;


public class RecipeDTO {
	private int recipeNum; 
	private String recipeName;
	private String recipeInfo;
	private String recipeCategory;
	private String recipeTime;
	private String  memberId;
	private String recipeMainImg;
	public RecipeDTO() {;	}
	public RecipeDTO(int recipeNum, String recipeName, String recipeInfo, String recipeCategory, String recipeTime,
			String memberId) {
		super();
		this.recipeNum = recipeNum;
		this.recipeName = recipeName;
		this.recipeInfo = recipeInfo;
		this.recipeCategory = recipeCategory;
		this.recipeTime = recipeTime;
		this.memberId = memberId;
	}
	
	
	public RecipeDTO(String recipeName, String recipeInfo, String ecipeCategory, String recipeTime, String memberId,
			String recipeMainImg) {
		super();
		this.recipeName = recipeName;
		this.recipeInfo = recipeInfo;
		this.recipeCategory = ecipeCategory;
		this.recipeTime = recipeTime;
		this.memberId = memberId;
		this.recipeMainImg = recipeMainImg;
	}
	public RecipeDTO(int recipeNum, String recipeName, String recipeInfo, String recipeCategory, String recipeTime,
			String memberId, String recipeMainImg) {
		super();
		this.recipeNum = recipeNum;
		this.recipeName = recipeName;
		this.recipeInfo = recipeInfo;
		this.recipeCategory = recipeCategory;
		this.recipeTime = recipeTime;
		this.memberId = memberId;
		this.recipeMainImg = recipeMainImg;
	}
	public int getRecipeNum() {
		return recipeNum;
	}
	public void setRecipeNum(int recipeNum) {
		this.recipeNum = recipeNum;
	}
	public String getRecipeName() {
		return recipeName;
	}
	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}
	public String getRecipeInfo() {
		return recipeInfo;
	}
	public void setRecipeInfo(String recipeInfo) {
		this.recipeInfo = recipeInfo;
	}
	public String getRecipeCategory() {
		return recipeCategory;
	}
	public void setRecipeCategory(String recipeCategory) {
		this.recipeCategory = recipeCategory;
	}
	public String getRecipeTime() {
		return recipeTime;
	}
	public void setRecipeTime(String recipeTime) {
		this.recipeTime = recipeTime;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getRecipeMainImg() {
		return recipeMainImg;
	}
	public void setRecipeMainImg(String recipeMainImg) {
		this.recipeMainImg = recipeMainImg;
	}
	
	
	
}
