package com.example.connorglennon.firstapidemo.data.network;

import com.example.connorglennon.firstapidemo.data.network.model.CakeModel;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Connor Glennon on 24/11/2017.
 */

public interface ApiHelper {
    public Observable<List<CakeModel>> getCakeModelList();
}
