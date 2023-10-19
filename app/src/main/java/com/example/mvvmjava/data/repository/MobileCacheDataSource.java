package com.example.mvvmjava.data.repository;

import android.util.SparseArray;

import com.example.mvvmjava.data.domain.Mobile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ali Asadi on 30/01/2019.
 */
public class MobileCacheDataSource implements MobileDataSource.Local {

    private static MobileCacheDataSource sInstance;

    private final SparseArray<Mobile> cachedMovies = new SparseArray<>();

    public static MobileCacheDataSource getsInstance() {
        if (sInstance == null) {
            sInstance = new MobileCacheDataSource();
        }
        return sInstance;
    }

    @Override
    public void getMovies(MobileRepository.LoadMoviesCallback callback) {

        if (cachedMovies.size() > 0) {
            List<Mobile> movies = new ArrayList<>();
            for (int i = 0; i < cachedMovies.size(); i++) {
                int key = cachedMovies.keyAt(i);
                movies.add(cachedMovies.get(key));
            }

            callback.onMoviesLoaded(movies);

        } else {
            callback.onDataNotAvailable();
        }

    }

    @Override
    public void saveMovies(List<Mobile> movies) {
        cachedMovies.clear();
        for (Mobile movie : movies) {
            cachedMovies.put(Integer.valueOf(movie.getId()), movie);
        }
    }

}
