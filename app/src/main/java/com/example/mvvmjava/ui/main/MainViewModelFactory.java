package com.example.mvvmjava.ui.main;


import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.mvvmjava.data.repository.MobileRepository;

/**
 * Created by Ali Asadi on 19/12/2018.
 */
public class MainViewModelFactory implements ViewModelProvider.Factory {

    private final MobileRepository moviesRepository;

    public MainViewModelFactory(MobileRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainViewModel.class)) {
            return (T) new MainViewModel(moviesRepository);
        }

        throw new IllegalArgumentException("Unknown ViewModel class");
    }

}
