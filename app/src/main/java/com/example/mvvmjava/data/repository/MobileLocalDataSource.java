package com.example.mvvmjava.data.repository;

import com.example.mvvmjava.data.db.MobileDao;
import com.example.mvvmjava.data.domain.Mobile;
import com.example.mvvmjava.ui.utils.DiskExecutor;

import java.util.List;
import java.util.concurrent.Executor;

/**
 * Created by Ali Asadi on 30/01/2019.
 */
public class MobileLocalDataSource implements MobileDataSource.Local {

    private final Executor executor;
    private final MobileDao movieDao;

    private static MobileLocalDataSource instance;

    private MobileLocalDataSource(Executor executor, MobileDao movieDao) {
        this.executor = executor;
        this.movieDao = movieDao;
    }

    public static MobileLocalDataSource getInstance(MobileDao movieDao) {
        if (instance == null) {
            instance = new MobileLocalDataSource(new DiskExecutor(), movieDao);
        }
        return instance;
    }

    @Override
    public void getMovies(final MobileRepository.LoadMoviesCallback callback) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                List<Mobile> movies = movieDao.getMovies();
                if (!movies.isEmpty()) {
                    callback.onMoviesLoaded(movies);
                } else {
                    callback.onDataNotAvailable();
                }
            }
        };
        executor.execute(runnable);
    }

    @Override
    public void saveMovies(final List<Mobile> movies) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                movieDao.saveMovies(movies);
            }
        };
        executor.execute(runnable);
    }
}
