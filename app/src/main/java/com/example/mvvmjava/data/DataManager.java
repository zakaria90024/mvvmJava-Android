package com.example.mvvmjava.data;

import android.preference.Preference;

import com.example.mvvmjava.data.db.MobileDao;
import com.example.mvvmjava.data.db.MobileDatabase;
import com.example.mvvmjava.data.remote.APIService;
import com.example.mvvmjava.data.remote.RetrofitClient;
import com.example.mvvmjava.data.repository.MobileCacheDataSource;
import com.example.mvvmjava.data.repository.MobileLocalDataSource;
import com.example.mvvmjava.data.repository.MobileRemoteDataSource;
import com.example.mvvmjava.data.repository.MobileRepository;
import com.example.mvvmjava.data.repository.MobileRepositoryImpl;

/**
 * Created by Ali Asadi on 26/03/2018.
 */

public class DataManager {

    private static DataManager sInstance;

    private DataManager() {
        // This class is not publicly instantiable
    }

    public static synchronized DataManager getInstance() {
        if (sInstance == null) {
            sInstance = new DataManager();
        }
        return sInstance;
    }

//    public Preference getPrefs() {
//        return PowerPreference.getDefaultFile();
//    }

    public MobileRepository getMovieRepository() {

        APIService movieApi = RetrofitClient.getInstance().getMovieApi();
        MobileRemoteDataSource movieRemote = MobileRemoteDataSource.getInstance(movieApi);

        MobileDao movieDao = MobileDatabase.getInstance().movieDao();
        MobileLocalDataSource movieLocal = MobileLocalDataSource.getInstance(movieDao);

        MobileCacheDataSource movieCache = MobileCacheDataSource.getsInstance();

        return MobileRepositoryImpl.getInstance(movieRemote,movieLocal,movieCache);
    }

}
