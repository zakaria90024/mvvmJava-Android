package com.example.mvvmjava.ui.main;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.mvvmjava.R;
import com.example.mvvmjava.data.DataManager;
import com.example.mvvmjava.data.domain.Mobile;
import com.example.mvvmjava.data.repository.MobileRepository;
import com.example.mvvmjava.databinding.ActivityMainBinding;
import com.example.mvvmjava.ui.base.BaseActivity;

import java.util.List;

/**
 *  Created by Md Zakaria Ahnaf on 19/10/2023.
 */

public class MainActivity  extends BaseActivity<ActivityMainBinding, MainViewModel> implements MobileAdapter.MovieListener {


    private MobileAdapter movieAdapter;

    @NonNull
    @Override
    protected MainViewModel createViewModel() {
        MobileRepository movieRepository = DataManager.getInstance().getMovieRepository();
        MainViewModelFactory factory = new MainViewModelFactory(movieRepository);
        return new ViewModelProvider(this, factory).get(MainViewModel.class);
        //return ViewModelProvider(context).get(ClassViewModel::class.java);


    }

    @NonNull
    @Override
    protected ActivityMainBinding createViewBinding(LayoutInflater layoutInflater) {
        return ActivityMainBinding.inflate(layoutInflater);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        movieAdapter = new MobileAdapter(this);
        binding.recyclerMobileid.setAdapter(movieAdapter);

        setListeners();
        observeViewModel();
    }

    private void setListeners() {
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.loadMovies();
            }
        });

        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.onEmptyClicked();
            }
        });
    }

    private void observeViewModel() {
        viewModel.getShowLoadingLiveData().observe(this, new Observer<Void>() {
            @Override
            public void onChanged(@Nullable Void aVoid) {
                //binding.progressBar.setVisibility(View.VISIBLE);
            }
        });

        viewModel.getHideLoadingLiveData().observe(this, new Observer<Void>() {
            @Override
            public void onChanged(@Nullable Void aVoid) {
                //binding.progressBar.setVisibility(View.GONE);
            }
        });

        viewModel.getMoviesLiveData().observe(this, new Observer<List<Mobile>>() {
            @Override
            public void onChanged(@Nullable List<Mobile> movies) {
                movieAdapter.setItems(movies);
            }
        });

        viewModel.getNavigateToDetailsLiveData().observe(this, new Observer<Mobile>() {
            @Override
            public void onChanged(@Nullable Mobile movie) {
                //DetailsActivity.start(MainActivity.this, movie);
            }
        });

        viewModel.getShowErrorMessageLiveData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String message) {
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onMovieClicked(Mobile movie) {

    }
}