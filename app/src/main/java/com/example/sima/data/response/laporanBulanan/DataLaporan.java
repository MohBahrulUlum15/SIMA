package com.example.sima.data.response.laporanBulanan;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class DataLaporan {

	@SerializedName("dataAkhirBulan")
	private List<DataAkhirBulanItem> dataAkhirBulan;

	@SerializedName("dataAwalBulan")
	private List<DataAwalBulanItem> dataAwalBulan;

	public void setDataAkhirBulan(List<DataAkhirBulanItem> dataAkhirBulan){
		this.dataAkhirBulan = dataAkhirBulan;
	}

	public List<DataAkhirBulanItem> getDataAkhirBulan(){
		return dataAkhirBulan;
	}

	public void setDataAwalBulan(List<DataAwalBulanItem> dataAwalBulan){
		this.dataAwalBulan = dataAwalBulan;
	}

	public List<DataAwalBulanItem> getDataAwalBulan(){
		return dataAwalBulan;
	}
}