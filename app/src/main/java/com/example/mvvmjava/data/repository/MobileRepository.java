package com.example.mvvmjava.data.repository;

import com.example.mvvmjava.data.domain.Mobile;

import java.util.List;

/**
 * Created by Ali Asadi on 05/04/2021
 */
public interface MobileRepository {

    interface LoadMoviesCallback {
        void onMoviesLoaded(List<Mobile> movies);
        void onDataNotAvailable();
        void onError();
    }

    void getMovies(LoadMoviesCallback callback);
    void saveMovies(List<Mobile> movies);
}
