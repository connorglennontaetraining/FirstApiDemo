package com.example.connorglennon.firstapidemo.services;

import com.example.connorglennon.firstapidemo.model.CakeModel;
import com.example.connorglennon.firstapidemo.util.constants.ApiList;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Connor Glennon on 22/11/2017.
 */

public interface RequestInterface {
    @GET(ApiList.CAKE_LIST)
    Observable<List<CakeModel>> getCakeList();
}
