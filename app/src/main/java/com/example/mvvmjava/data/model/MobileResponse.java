package com.example.mvvmjava.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MobileResponse {
    @Expose
    @SerializedName("movies")
    private List<MobileRemote> mobiles;

    public List<MobileRemote> getMovies() {
        return mobiles;
    }

    public void setMovies(List<MobileRemote> mobiles) {
        this.mobiles = mobiles;
    }

}
