package com.example.mvvmjava.data.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.mvvmjava.data.domain.Mobile;

import java.util.List;

/**
 *  Created by Md Zakaria Ahnaf on 19/10/2023.
 */

@Dao
public interface MobileDao {

    /**
     * Select all movies from the movies table.
     *
     * @return all movies.
     */
    @Query("SELECT * FROM mobiles")
    List<Mobile> getMovies();

    /**
     * Insert all movies.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveMovies(List<Mobile> movies);

    /**
     * Delete all movies.
     */
    @Query("DELETE FROM mobiles")
    void deleteMovies();
}
