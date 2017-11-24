package com.example.connorglennon.firstapidemo.data;

import com.example.connorglennon.firstapidemo.data.DataManager;
import com.example.connorglennon.firstapidemo.data.network.ApiHelper;
import com.example.connorglennon.firstapidemo.data.network.AppApiHelper;
import com.example.connorglennon.firstapidemo.data.network.model.CakeModel;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Connor Glennon on 24/11/2017.
 */

public class AppDataManager implements DataManager {
    ApiHelper apiHelper;

    public AppDataManager() {
        this.apiHelper = new AppApiHelper();
    }

    @Override
    public Observable<List<CakeModel>> getCakeModelList() {
        return apiHelper.getCakeModelList();
    }
}
