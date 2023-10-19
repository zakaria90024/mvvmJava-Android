package com.example.mvvmjava.data.db;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.mvvmjava.data.domain.Mobile;
import com.example.mvvmjava.ui.App;



/**
 *  Created by Md Zakaria Ahnaf on 19/10/2023.
 */

@Database(entities = {Mobile.class}, version = 1, exportSchema = false)
public abstract class MobileDatabase extends RoomDatabase {
    public abstract MobileDao movieDao();

    private static MobileDatabase sInstance;

    public static MobileDatabase getInstance() {
        if (sInstance == null) {
            sInstance = Room.databaseBuilder(App.getInstance(), MobileDatabase.class, "Mobile.db").build();
        }
        return sInstance;
    }
}
