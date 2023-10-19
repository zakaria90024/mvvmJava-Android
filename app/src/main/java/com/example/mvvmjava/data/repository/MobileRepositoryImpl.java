package com.example.mvvmjava.data.repository;

import com.example.mvvmjava.data.domain.Mobile;

import java.util.List;

/**
 * Created by Ali Asadi on 29/01/2019.
 */
public class MobileRepositoryImpl implements MobileRepository {

    private final MobileDataSource.Remote movieRemote;
    private final MobileDataSource.Local movieLocal;
    private final MobileDataSource.Local movieCache;

    private static MobileRepositoryImpl instance;

    private MobileRepositoryImpl(MobileRemoteDataSource movieRemote,
                                 MobileLocalDataSource movieLocal,
                                 MobileCacheDataSource movieCache) {

        this.movieRemote = movieRemote;
        this.movieLocal = movieLocal;
        this.movieCache = movieCache;
    }

    public static MobileRepositoryImpl getInstance(MobileRemoteDataSource movieRemote,
                                                   MobileLocalDataSource movieLocal,
                                                   MobileCacheDataSource movieCache) {
        if (instance == null) {
            instance = new MobileRepositoryImpl(movieRemote, movieLocal, movieCache);
        }
        return instance;
    }

    @Override
    public void getMovies(final MobileRepository.LoadMoviesCallback callback) {
        if (callback == null) return;

        movieCache.getMovies(new MobileRepository.LoadMoviesCallback() {
            @Override
            public void onMoviesLoaded(List<Mobile> movies) {
                callback.onMoviesLoaded(movies);
            }

            @Override
            public void onDataNotAvailable() {
                getMoviesFromLocalDataSource(callback);
            }

            @Override
            public void onError() {
                //not implemented in cache data source
            }
        });

    }

    @Override
    public void saveMovies(List<Mobile> movies) {
        movieLocal.saveMovies(movies);
    }

    private void getMoviesFromLocalDataSource(final MobileRepository.LoadMoviesCallback callback) {
        movieLocal.getMovies(new MobileRepository.LoadMoviesCallback() {
            @Override
            public void onMoviesLoaded(List<Mobile> movies) {
                callback.onMoviesLoaded(movies);
                refreshCache(movies);
            }

            @Override
            public void onDataNotAvailable() {
                getMoviesFromRemoteDataSource(callback);
            }

            @Override
            public void onError() {
                //not implemented in local data source
            }
        });
    }

    private void getMoviesFromRemoteDataSource(final MobileRepository.LoadMoviesCallback callback) {
        movieRemote.getMovies(new MobileRepository.LoadMoviesCallback() {
            @Override
            public void onMoviesLoaded(List<Mobile> movies) {
                callback.onMoviesLoaded(movies);
                saveMovies(movies);
                refreshCache(movies);
            }

            @Override
            public void onDataNotAvailable() {
                callback.onDataNotAvailable();
            }

            @Override
            public void onError() {
                callback.onError();
            }
        });
    }

    private void refreshCache(List<Mobile> movies) {
        movieCache.saveMovies(movies);
    }
}
