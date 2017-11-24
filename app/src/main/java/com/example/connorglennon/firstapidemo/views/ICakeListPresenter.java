package com.example.connorglennon.firstapidemo.views;

import com.example.connorglennon.firstapidemo.views.cakelist.ui.base.MvpPresenter;

/**
 * Created by Connor Glennon on 24/11/2017.
 */

public interface ICakeListPresenter<V extends ICakeListView> extends MvpPresenter<V> {
    void onCallCakeList();
}
