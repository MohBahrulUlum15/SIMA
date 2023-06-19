package com.example.sima.data.response.laporanBulanan;

import com.google.gson.annotations.SerializedName;

public class LaporanBulananResponse{

	@SerializedName("msg")
	private String msg;

	@SerializedName("data")
	private DataLaporan data;

	@SerializedName("success")
	private boolean success;

	public void setMsg(String msg){
		this.msg = msg;
	}

	public String getMsg(){
		return msg;
	}

	public void setData(DataLaporan data){
		this.data = data;
	}

	public DataLaporan getData(){
		return data;
	}

	public void setSuccess(boolean success){
		this.success = success;
	}

	public boolean isSuccess(){
		return success;
	}
}