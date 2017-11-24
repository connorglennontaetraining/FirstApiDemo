package com.example.connorglennon.firstapidemo.views;

import com.example.connorglennon.firstapidemo.data.network.model.CakeModel;
import com.example.connorglennon.firstapidemo.views.cakelist.ui.base.MvpView;

import java.util.List;

/**
 * Created by Connor Glennon on 24/11/2017.
 */

public interface ICakeListView extends MvpView {
    void onFetchDataSuccess(List<CakeModel> cakeModels);
    void onFetchDataError(String message);
}
