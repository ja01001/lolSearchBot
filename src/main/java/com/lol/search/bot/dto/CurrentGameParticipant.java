package com.lol.search.bot.dto;

import java.util.List;

public class CurrentGameParticipant {
	long championId;
	long profileIconId;
	Perks perks;
	boolean bot;
	long teamId;
	String summonerName;
	String summonerId;
	long spell1Id;
	long spell2Id;
	List<GameCustomizationObject> gameCustomizationObjects;
	
	public long getChampionId() {
		return championId;
	}
	public void setChampionId(long championId) {
		this.championId = championId;
	}
	
	
	public Perks getPerks() {
		return perks;
	}
	public void setPerks(Perks perks) {
		this.perks = perks;
	}
	public long getProfileIconId() {
		return profileIconId;
	}
	public void setProfileIconId(long profileIconId) {
		this.profileIconId = profileIconId;
	}
	public boolean isBot() {
		return bot;
	}
	public void setBot(boolean bot) {
		this.bot = bot;
	}
	public long getTeamId() {
		return teamId;
	}
	public void setTeamId(long teamId) {
		this.teamId = teamId;
	}
	public String getSummonerName() {
		return summonerName;
	}
	public void setSummonerName(String summonerName) {
		this.summonerName = summonerName;
	}
	public String getSummonerId() {
		return summonerId;
	}
	public void setSummonerId(String summonerId) {
		this.summonerId = summonerId;
	}
	public long getSpell1Id() {
		return spell1Id;
	}
	public void setSpell1Id(long spell1Id) {
		this.spell1Id = spell1Id;
	}
	public long getSpell2Id() {
		return spell2Id;
	}
	public void setSpell2Id(long spell2Id) {
		this.spell2Id = spell2Id;
	}
	public List<GameCustomizationObject> getGameCustomizationObjects() {
		return gameCustomizationObjects;
	}
	public void setGameCustomizationObjects(List<GameCustomizationObject> gameCustomizationObjects) {
		this.gameCustomizationObjects = gameCustomizationObjects;
	}
	@Override
	public String toString() {
		return "CurrentGameParticipant [championId=" + championId + ", profileIconId=" + profileIconId + ", perks="
				+ perks + ", bot=" + bot + ", teamId=" + teamId + ", summonerName=" + summonerName + ", summonerId="
				+ summonerId + ", spell1Id=" + spell1Id + ", spell2Id=" + spell2Id + ", gameCustomizationObjects="
				+ gameCustomizationObjects + "]";
	}
	
	
	
	
}
