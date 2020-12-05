package com.lol.search.bot.dto;

import java.util.List;

public class GameInfoDTO {
	long teamId;
	// quetype은 ?
	String summonerId; // user enc ID
	String summonerName; // user name
	int championId; // championId

	List<RankDTO> rankInfo; // rank 정보
	// promotion games

	public long getTeamId() {
		return teamId;
	}

	public void setTeamId(long teamId) {
		this.teamId = teamId;
	}

	public String getSummonerId() {
		return summonerId;
	}

	public void setSummonerId(String summonerId) {
		this.summonerId = summonerId;
	}

	public String getSummonerName() {
		return summonerName;
	}

	public void setSummonerName(String summonerName) {
		this.summonerName = summonerName;
	}

	public int getChampionId() {
		return championId;
	}

	public void setChampionId(int championId) {
		this.championId = championId;
	}

	public List<RankDTO> getRankInfo() {
		return rankInfo;
	}

	public void setRankInfo(List<RankDTO> rankInfo) {
		this.rankInfo = rankInfo;
	}

	@Override
	public String toString() {
		return "GameInfoDTO [teamId=" + teamId + ", summonerId=" + summonerId + ", summonerName=" + summonerName
				+ ", championId=" + championId + ", rankInfo=" + rankInfo + "]";
	}

}
