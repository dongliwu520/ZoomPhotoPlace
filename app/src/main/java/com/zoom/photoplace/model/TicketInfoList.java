package com.zoom.photoplace.model;

import java.io.Serializable;

public class TicketInfoList implements Serializable{
//  "hallName": "钱宝厅",
//  "hallNo": "22907",
//  "duration": "137分钟",
//  "ticketNo": "19076483",
//  "showTimeEnd": null,
//  "seqNo": "19076483",
//  "cinemaPrice": 130,
//  "showType": "3D",
//  "salePrice": 72,
//  "seatNum": 192,
//  "language": "英语",
//  "showTimeBegin": "23:30:00"
	
	private String hallName;
	private String hallNo;
	
	private String duration;
	private String ticketNo;
	private String showTimeEnd;
	private String seqNo;
	private String cinemaPrice;
	
	private String showType;
	private String salePrice;
	private String seatNum;
	private String language;
	private String showTimeBegin;
	private String overtime;
	
	public String getOvertime() {
		return overtime;
	}
	public void setOvertime(String overtime) {
		this.overtime = overtime;
	}
	public String getHallName() {
		return hallName;
	}
	public void setHallName(String hallName) {
		this.hallName = hallName;
	}
	public String getHallNo() {
		return hallNo;
	}
	public void setHallNo(String hallNo) {
		this.hallNo = hallNo;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getTicketNo() {
		return ticketNo;
	}
	public void setTicketNo(String ticketNo) {
		this.ticketNo = ticketNo;
	}
	public String getShowTimeEnd() {
		return showTimeEnd;
	}
	public void setShowTimeEnd(String showTimeEnd) {
		this.showTimeEnd = showTimeEnd;
	}
	public String getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}
	public String getCinemaPrice() {
		return cinemaPrice;
	}
	public void setCinemaPrice(String cinemaPrice) {
		this.cinemaPrice = cinemaPrice;
	}
	public String getShowType() {
		return showType;
	}
	public void setShowType(String showType) {
		this.showType = showType;
	}
	public String getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(String salePrice) {
		this.salePrice = salePrice;
	}
	public String getSeatNum() {
		return seatNum;
	}
	public void setSeatNum(String seatNum) {
		this.seatNum = seatNum;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getShowTimeBegin() {
		return showTimeBegin;
	}
	public void setShowTimeBegin(String showTimeBegin) {
		this.showTimeBegin = showTimeBegin;
	}
	
	
	

	
	

	
	

}
