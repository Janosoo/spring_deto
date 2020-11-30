package com.example.demo;

import com.google.cloud.Timestamp;

public class ColdFile {
	
	private String uniqueKey;
	
	private Timestamp date;
	
	private String description;
	
	public ColdFile(Object object, Object object2, Object object3) {
		super();
		this.uniqueKey = object;
		this.date = object2;
		this.description = object3;
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
