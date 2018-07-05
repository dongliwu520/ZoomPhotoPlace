package com.zoom.photoplace.model;


public class TResult {
	String message;
	String timestamp;
	int code;
	int bonus;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	@Override
	public String toString() {
		return "TResult [message=" + message + ", timestamp=" + timestamp
				+ ", code=" + code + ", bonus=" + bonus + "]";
	}

}
