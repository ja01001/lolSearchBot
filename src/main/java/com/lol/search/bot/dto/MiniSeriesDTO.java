package com.lol.search.bot.dto;

public class MiniSeriesDTO {
	// 진수 
	int losses;		
	// 진행사항 Y : 이김 ,X : 짐 , N: 수행 안함
	// target : 총 게임 수 (  3 or 5 ) 
	String progress;		
	int target;		
	int wins;
	public int getLosses() {
		return losses;
	}
	public void setLosses(int losses) {
		this.losses = losses;
	}
	public String getProgress() {
		return progress;
	}
	public void setProgress(String progress) {
		this.progress = progress;
	}
	public int getTarget() {
		return target;
	}
	public void setTarget(int target) {
		this.target = target;
	}
	public int getWins() {
		return wins;
	}
	public void setWins(int wins) {
		this.wins = wins;
	}
	@Override
	public String toString() {
		return "MiniSeriesDTO [losses=" + losses + ", progress=" + progress + ", target=" + target + ", wins=" + wins
				+ "]";
	}
	
	
	
}
