package com.example.mvvmjava.ui.main;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mvvmjava.data.domain.Mobile;
import com.example.mvvmjava.data.repository.MobileRepository;
import com.example.mvvmjava.ui.base.BaseViewModel;

import java.util.Collections;
import java.util.List;

/**
 * Created by Ali Asadi on 18/12/2018.
 */
public class MainViewModel extends BaseViewModel {

    private final MutableLiveData<List<Mobile>> moviesLiveData = new MutableLiveData<>();
    private final MutableLiveData<String> showErrorMessageLiveData = new MutableLiveData<>();
    private final MutableLiveData<Void> showLoadingLiveData = new MutableLiveData<>();
    private final MutableLiveData<Void> hideLoadingLiveData = new MutableLiveData<>();
    private final MutableLiveData<Mobile> navigateToDetailsLiveData = new MutableLiveData<>();

    private final MobileRepository moviesRepository;

    private final MovieCallback movieCallback = new MovieCallback();

    MainViewModel(MobileRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

    public void loadMovies() {
        setIsLoading(true);
        moviesRepository.getMovies(movieCallback);
    }

    public void onEmptyClicked() {
        setMoviesLiveData(Collections.<Mobile>emptyList());
    }

    private void setIsLoading(boolean loading) {
        if (loading) {
            showLoadingLiveData.postValue(null);
        } else {
            hideLoadingLiveData.postValue(null);
        }
    }

    private void setMoviesLiveData(List<Mobile> moviesLiveData) {
        setIsLoading(false);
        this.moviesLiveData.postValue(moviesLiveData);
    }

    public void onMovieClicked(Mobile movie) {
        navigateToDetailsLiveData.postValue(movie);
    }

    /**
     * Callback
     **/
    private class MovieCallback implements MobileRepository.LoadMoviesCallback {
        @Override
        public void onMoviesLoaded(List<Mobile> movies) {
            setMoviesLiveData(movies);
        }

        @Override
        public void onDataNotAvailable() {
            setIsLoading(false);
            showErrorMessageLiveData.postValue("There is not items!");
        }

        @Override
        public void onError() {
            setIsLoading(false);
            showErrorMessageLiveData.postValue("Something Went Wrong!");
        }
    }

    /**
     * LiveData
     **/
    public LiveData<List<Mobile>> getMoviesLiveData() {
        return moviesLiveData;
    }

    public LiveData<Void> getShowLoadingLiveData() {
        return showLoadingLiveData;
    }

    public LiveData<String> getShowErrorMessageLiveData() {
        return showErrorMessageLiveData;
    }

    public LiveData<Void> getHideLoadingLiveData() {
        return hideLoadingLiveData;
    }

    public LiveData<Mobile> getNavigateToDetailsLiveData() {
        return navigateToDetailsLiveData;
    }
}
