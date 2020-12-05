package com.lol.search.bot.dto;

public class Observer {
	String encryptionKey;

	public String getEncryptionKey() {
		return encryptionKey;
	}

	public void setEncryptionKey(String encryptionKey) {
		this.encryptionKey = encryptionKey;
	}

	@Override
	public String toString() {
		return "Observer [encryptionKey=" + encryptionKey + "]";
	}
	
}
