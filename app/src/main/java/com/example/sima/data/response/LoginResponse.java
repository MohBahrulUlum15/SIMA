package com.example.sima.data.response;

import com.google.gson.annotations.SerializedName;

public class LoginResponse{
	public DataUser getData() {
		return data;
	}

	public void setData(DataUser data) {
		this.data = data;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@SerializedName("data")
	private DataUser data;

	@SerializedName("success")
	private Boolean success;

	@SerializedName("message")
	private String message;
}

