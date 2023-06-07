package com.example.sima.data.response;

import com.google.gson.annotations.SerializedName;

public class RegisterResponse{

	@SerializedName("data")
	private DataRegister data;

	@SerializedName("success")
	private Boolean success;

	@SerializedName("message")
	private String message;

	public void setData(DataRegister data){
		this.data = data;
	}

	public DataRegister getData(){
		return data;
	}

	public void setSuccess(Boolean success){
		this.success = success;
	}

	public Boolean isSuccess(){
		return success;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}
}