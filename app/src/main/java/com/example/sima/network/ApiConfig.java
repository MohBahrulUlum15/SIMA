package com.example.sima.network;

import com.example.sima.BuildConfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiConfig {

    private static String BASE_URL = "http://192.168.1.19/sima-api/";

    public static ApiService getApiService() {
        OkHttpClient OkHttpClient = createHttpClient();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL) // Replace with your API base URL
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpClient)
                .build();
        return retrofit.create(ApiService.class);
    }
    private static OkHttpClient createHttpClient(){
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        if (BuildConfig.DEBUG){
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        }
        httpClient.addInterceptor(loggingInterceptor);
        return httpClient.build();
    }
}
