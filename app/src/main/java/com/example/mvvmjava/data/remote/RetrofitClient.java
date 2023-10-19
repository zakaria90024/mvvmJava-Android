package com.example.mvvmjava.data.remote;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ali Asadi on 26/03/2018.
 */
public class RetrofitClient {

    private static final String URL = "https://apps.bncodeing.com/";

    private final APIService movieApi;

    private static RetrofitClient singleton;

    private RetrofitClient() {
        Retrofit mRetrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(URL).build();

        movieApi = mRetrofit.create(APIService.class);
    }

    public static RetrofitClient getInstance() {
        if (singleton == null) {
            synchronized (RetrofitClient.class) {
                if (singleton == null) {
                    singleton = new RetrofitClient();
                }
            }
        }
        return singleton;
    }

    public APIService getMovieApi() {
        return movieApi;
    }

}
