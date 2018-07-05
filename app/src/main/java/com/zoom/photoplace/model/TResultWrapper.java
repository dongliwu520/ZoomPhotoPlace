package com.zoom.photoplace.model;

public class TResultWrapper<T> {
	TResult result;
	T data;

	public TResult getResult() {
		return result;
	}

	public void setResult(TResult result) {
		this.result = result;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
