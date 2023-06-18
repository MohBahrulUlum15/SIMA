package com.example.sima.data.response;

import com.google.gson.annotations.SerializedName;

public class TambahGensetResponse{

	@SerializedName("data")
	private DataGenset data;

	@SerializedName("success")
	private boolean success;

	@SerializedName("message")
	private String message;

	public void setData(DataGenset data){
		this.data = data;
	}

	public DataGenset getData(){
		return data;
	}

	public void setSuccess(boolean success){
		this.success = success;
	}

	public boolean isSuccess(){
		return success;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}
}