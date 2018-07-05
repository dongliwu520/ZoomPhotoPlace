package com.zoom.photoplace.model;

import java.io.Serializable;

public class FilmDateLists implements Serializable{

//	"seqNo": "111",
//	private String seqNo;
	private String showDate;
	private TicketInfoList [] ticketInfoList;
//	public String getSeqNo() {
//		return seqNo;
//	}
//	public void setSeqNo(String seqNo) {
//		this.seqNo = seqNo;
//	}
	public String getShowDate() {
		return showDate;
	}
	public void setShowDate(String showDate) {
		this.showDate = showDate;
	}
	public TicketInfoList[] getTicketInfoList() {
		return ticketInfoList;
	}
	public void setTicketInfoList(TicketInfoList[] ticketInfoList) {
		this.ticketInfoList = ticketInfoList;
	}
	
}
