package com.example.sima.data.response;

import com.google.gson.annotations.SerializedName;

public class TambahMotorPompaResponse{

	@SerializedName("data")
	private DataMotorPompa data;

	@SerializedName("success")
	private boolean success;

	@SerializedName("message")
	private String message;

	public void setData(DataMotorPompa data){
		this.data = data;
	}

	public DataMotorPompa getData(){
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