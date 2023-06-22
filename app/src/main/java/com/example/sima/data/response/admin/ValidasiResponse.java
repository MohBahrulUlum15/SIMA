package com.example.sima.data.response.admin;

import com.google.gson.annotations.SerializedName;

public class ValidasiResponse{

	@SerializedName("success")
	private boolean success;

	@SerializedName("message")
	private String message;

	public boolean isSuccess(){
		return success;
	}

	public String getMessage(){
		return message;
	}
}