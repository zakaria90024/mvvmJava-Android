package com.example.mvvmjava.data.repository;

import com.example.mvvmjava.data.domain.Mobile;

import java.util.List;

public interface MobileDataSource {


    interface Remote {
        void getMovies(MobileRepository.LoadMoviesCallback callback);
    }

    interface Local extends Remote {
        void saveMovies(List<Mobile> movies);
    }
}
