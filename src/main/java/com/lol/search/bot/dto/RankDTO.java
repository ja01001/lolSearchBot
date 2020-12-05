package com.lol.search.bot.dto;

public class RankDTO {
	String queueType;
	String tier; // tier
	String rank; // rank
	int leaguePoints; // rank point
	int wins; // win games
	int losses; // loss games
	MiniSeriesDTO miniSeriesDto;

	public String getQueueType() {
		return queueType;
	}

	public void setQueueType(String queueType) {
		this.queueType = queueType;
	}

	public String getTier() {
		return tier;
	}

	public void setTier(String tier) {
		this.tier = tier;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public int getLeaguePoints() {
		return leaguePoints;
	}

	public void setLeaguePoints(int leaguePoints) {
		this.leaguePoints = leaguePoints;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public int getLosses() {
		return losses;
	}

	public void setLosses(int losses) {
		this.losses = losses;
	}

	public MiniSeriesDTO getMiniSeriesDto() {
		return miniSeriesDto;
	}

	public void setMiniSeriesDto(MiniSeriesDTO miniSeriesDto) {
		this.miniSeriesDto = miniSeriesDto;
	}

	@Override
	public String toString() {
		return "RankDTO [queueType = " + queueType + ", tier=" + tier + ", rank=" + rank + ", leaguePoints="
				+ leaguePoints + ", wins=" + wins + ", losses=" + losses + ", miniSeriesDto=" + miniSeriesDto + "]";
	}

}
