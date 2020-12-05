package com.lol.search.bot.dto;

import java.util.List;

public class Perks {
	List<Long> perkIds;
	long perkStyle;
	long perkSubStyle;
	public List<Long> getPerkIds() {
		return perkIds;
	}
	public void setPerkIds(List<Long> perkIds) {
		this.perkIds = perkIds;
	}
	public long getPerkStyle() {
		return perkStyle;
	}
	public void setPerkStyle(long perkStyle) {
		this.perkStyle = perkStyle;
	}
	public long getPerkSubStyle() {
		return perkSubStyle;
	}
	public void setPerkSubStyle(long perkSubStyle) {
		this.perkSubStyle = perkSubStyle;
	}
	@Override
	public String toString() {
		return "Perks [perkIds=" + perkIds + ", perkStyle=" + perkStyle + ", perkSubStyle=" + perkSubStyle + "]";
	}
	
	
}
