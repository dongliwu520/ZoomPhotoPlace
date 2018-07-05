package com.zoom.photoplace.model;

import java.io.Serializable;

public class TFilmNumberSelectDataWrapper implements Serializable {

	CinemaInfo cinemaInfo;
	FilmList[] filmList;
	ThjList[] tdjList;
	public CinemaInfo getCinemaInfo() {
		return cinemaInfo;
	}
	public void setCinemaInfo(CinemaInfo cinemaInfo) {
		this.cinemaInfo = cinemaInfo;
	}
	public FilmList[] getFilmList() {
		return filmList;
	}
	public void setFilmList(FilmList[] filmList) {
		this.filmList = filmList;
	}
	public ThjList[] getTdjList() {
		return tdjList;
	}
	public void setTdjList(ThjList[] tdjList) {
		this.tdjList = tdjList;
	}

	
}
