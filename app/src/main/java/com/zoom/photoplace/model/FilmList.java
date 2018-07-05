package com.zoom.photoplace.model;

import java.io.Serializable;

public class FilmList implements Serializable{

//  "frontImg": "http://Img.wangpiao.com/NewsImage/20154/ddb91d5f-2da3-42e8-8d38-8d4c80f41791.jpg",
//  "filmName": "速度与激情7",
//  "cinemaNo": "1648",
//  "cinemaName": null,
//  "showType": "3D",
//  "mainActors": "杰森·斯坦森/道恩·强森/范·迪塞尔/保罗·沃克/龙达·鲁西/埃尔莎·帕塔奇/卢卡斯·布莱克/米歇尔·罗德里格兹/杰曼·翰苏/库尔特·拉塞尔/乔丹娜·布鲁斯特/娜塔莉·伊曼纽尔/泰瑞斯·吉布森",
//	 "filmNo": 16581,
//   "averageDegree": "9.4"
//	"duration": "137分钟",
	
	private String duration;//时长
	private String filmCritic;//短评
	
	
	public String getFilmCritic() {
		return filmCritic;
	}
	public void setFilmCritic(String filmCritic) {
		this.filmCritic = filmCritic;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	private String frontImg;//封面
	private String filmName;//影片名称
	private String cinemaNo;//影院id
	private String cinemaName;
	private String mainActors;//主演
	private String filmNo;//影片id
	private String averageDegree;//
	private String showType;
	private FilmDateLists[] filmDateLists;
	private String category;

	public String getShowType() {
		return showType;
	}
	public void setShowType(String showType) {
		this.showType = showType;
	}
	public String getFrontImg() {
		return frontImg;
	}
	public void setFrontImg(String frontImg) {
		this.frontImg = frontImg;
	}
	public String getFilmName() {
		return filmName;
	}
	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}
	public String getCinemaNo() {
		return cinemaNo;
	}
	public void setCinemaNo(String cinemaNo) {
		this.cinemaNo = cinemaNo;
	}
	public String getCinemaName() {
		return cinemaName;
	}
	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}
	public String getMainActors() {
		return mainActors;
	}
	public void setMainActors(String mainActors) {
		this.mainActors = mainActors;
	}
	public String getFilmNo() {
		return filmNo;
	}
	public void setFilmNo(String filmNo) {
		this.filmNo = filmNo;
	}
	public String getAverageDegree() {
		return averageDegree;
	}
	public void setAverageDegree(String averageDegree) {
		this.averageDegree = averageDegree;
	}
	public FilmDateLists[] getFilmDateLists() {
		return filmDateLists;
	}
	public void setFilmDateLists(FilmDateLists[] filmDateLists) {
		this.filmDateLists = filmDateLists;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
