package com.lol.search.bot.dto;

public class LeagueEntryDTO {
	String leagueId;
	String	summonerId;
	String	summonerName;
	String queueType;
	String	tier;
	String	rank;
	int	leaguePoints;
	int	wins;
	int	losses;
	boolean	hotStreak;
	boolean	veteran;
	boolean freshBlood;
	boolean	inactive;
	MiniSeriesDTO miniSeries;
	public String getLeagueId() {
		return leagueId;
	}
	public void setLeagueId(String leagueId) {
		this.leagueId = leagueId;
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
	public boolean isHotStreak() {
		return hotStreak;
	}
	public void setHotStreak(boolean hotStreak) {
		this.hotStreak = hotStreak;
	}
	public boolean isVeteran() {
		return veteran;
	}
	public void setVeteran(boolean veteran) {
		this.veteran = veteran;
	}
	public boolean isFreshBlood() {
		return freshBlood;
	}
	public void setFreshBlood(boolean freshBlood) {
		this.freshBlood = freshBlood;
	}
	public boolean isInactive() {
		return inactive;
	}
	public void setInactive(boolean inactive) {
		this.inactive = inactive;
	}
	public MiniSeriesDTO getMiniSeries() {
		return miniSeries;
	}
	public void setMiniSeries(MiniSeriesDTO miniSeries) {
		this.miniSeries = miniSeries;
	}
	@Override
	public String toString() {
		return "LeagueEntryDTO [leagueId=" + leagueId + ", summonerId=" + summonerId + ", summonerName=" + summonerName
				+ ", queueType=" + queueType + ", tier=" + tier + ", rank=" + rank + ", leaguePoints=" + leaguePoints
				+ ", wins=" + wins + ", losses=" + losses + ", hotStreak=" + hotStreak + ", veteran=" + veteran
				+ ", freshBlood=" + freshBlood + ", inactive=" + inactive + ", miniSeries=" + miniSeries + "]";
	}
	
	
}
