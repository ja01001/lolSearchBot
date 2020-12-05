package com.lol.search.bot.dto;

public class GameCustomizationObject {
	String category;
	String content;
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "GameCustomizationObject [category=" + category + ", content=" + content + "]";
	}
	
	
}
