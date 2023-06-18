package com.example.sima.data.response;

import com.google.gson.annotations.SerializedName;

public class TambahPompaResponse{

	@SerializedName("data")
	private DataPompa data;

	@SerializedName("success")
	private boolean success;

	@SerializedName("message")
	private String message;

	public void setData(DataPompa data){
		this.data = data;
	}

	public DataPompa getData(){
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