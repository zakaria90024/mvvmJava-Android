package com.example.mvvmjava.data.repository;


import com.example.mvvmjava.data.domain.Mobile;
import com.example.mvvmjava.data.mapper.MobileMapper;
import com.example.mvvmjava.data.model.MobileRemote;
import com.example.mvvmjava.data.model.MobileResponse;
import com.example.mvvmjava.data.remote.APIService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MobileRemoteDataSource implements MobileDataSource.Remote {

    private static MobileRemoteDataSource instance;

    private final APIService movieApi;

    private MobileRemoteDataSource(APIService movieApi) {
        this.movieApi = movieApi;
    }

    public static MobileRemoteDataSource getInstance(APIService movieApi) {
        if (instance == null) {
            instance = new MobileRemoteDataSource(movieApi);
        }
        return instance;
    }

    @Override
    public void getMovies(final MobileRepository.LoadMoviesCallback callback) {


        movieApi.getMobiles().enqueue(new Callback<MobileResponse>() {
            @Override
            public void onResponse(Call<MobileResponse> call, Response<MobileResponse> response) {
                List<MobileRemote> movies = response.body() != null ? response.body().getMovies() : null;
                if (movies != null && !movies.isEmpty()) {
                    final List<Mobile> moviesDomain = new ArrayList<>();
                    for (MobileRemote movieRemote : movies) {
                        moviesDomain.add(MobileMapper.toDomain(movieRemote));
                    }
                    callback.onMoviesLoaded(moviesDomain);
                } else {
                    callback.onDataNotAvailable();
                }
            }

            @Override
            public void onFailure(Call<MobileResponse> call, Throwable t) {
                callback.onError();
            }
        });
    }
}
