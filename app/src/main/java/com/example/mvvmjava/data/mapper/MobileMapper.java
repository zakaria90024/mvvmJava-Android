package com.example.mvvmjava.data.mapper;


import android.graphics.Movie;

import com.example.mvvmjava.data.domain.Mobile;
import com.example.mvvmjava.data.model.MobileRemote;

/**
 * Created by Ali Asadi on 05/04/2021
 */
public class MobileMapper {
    public static Mobile toDomain(MobileRemote movieRemote) {
        return new Mobile(movieRemote.getId(), movieRemote.getCategoryId(), movieRemote.getMobileName(), movieRemote.getMobilePrice(), movieRemote.getMobileRelease(), movieRemote.getMobileColor(),
                movieRemote.getMobileDetails(), movieRemote.getMobileImageUrl(), movieRemote.getMobileImage(), movieRemote.getCreatedAt(), movieRemote.getUpdatedAt());
    }

}
