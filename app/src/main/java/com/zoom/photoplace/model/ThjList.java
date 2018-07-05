package com.zoom.photoplace.model;

import java.io.Serializable;

public class ThjList implements Serializable{
//  "TicketName": "耀莱国际影城（慈云寺店）3D通兑票",
//  "CinemaPrice": 120,
//  "HotSellEnd": "90",
//  "cinemaNo": "M101211078",
//  "SalePrice": 72,
//  "ProductType": 5,
//  "TicketNo": 3973,
//  "WebMemo": "有效期内可
	
	private String TicketName; 
	private String CinemaPrice;
	private String HotSellEnd;
	private String cinemaNo;
	private String SalePrice;
	private String ProductType;
	private String TicketNo;
	private String WebMemo;
	public String getTicketName() {
		return TicketName;
	}
	public void setTicketName(String ticketName) {
		TicketName = ticketName;
	}
	public String getCinemaPrice() {
		return CinemaPrice;
	}
	public void setCinemaPrice(String cinemaPrice) {
		CinemaPrice = cinemaPrice;
	}
	public String getHotSellEnd() {
		return HotSellEnd;
	}
	public void setHotSellEnd(String hotSellEnd) {
		HotSellEnd = hotSellEnd;
	}
	public String getCinemaNo() {
		return cinemaNo;
	}
	public void setCinemaNo(String cinemaNo) {
		this.cinemaNo = cinemaNo;
	}
	public String getSalePrice() {
		return SalePrice;
	}
	public void setSalePrice(String salePrice) {
		SalePrice = salePrice;
	}
	public String getProductType() {
		return ProductType;
	}
	public void setProductType(String productType) {
		ProductType = productType;
	}
	public String getTicketNo() {
		return TicketNo;
	}
	public void setTicketNo(String ticketNo) {
		TicketNo = ticketNo;
	}
	public String getWebMemo() {
		return WebMemo;
	}
	public void setWebMemo(String webMemo) {
		WebMemo = webMemo;
	}
	
	
}
