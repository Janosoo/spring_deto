package com.example.demo;

import com.google.cloud.Timestamp;

public class ColdFile {
	
	private String uniqueKey;
	
	private Timestamp date;
	
	private String description;
	
	public ColdFile(String uniqueKey, Timestamp date, String description) {
		super();
		this.uniqueKey = uniqueKey;
		this.date = date;
		this.description = description;
	}

	public String getUniqueKey() {
		return uniqueKey;
	}

	public void setUniqueKey(String uniqueKey) {
		this.uniqueKey = uniqueKey;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ColdFile [uniqueKey=" + uniqueKey + ", date=" + date + ", description=" + description + "]";
	}


	
}
