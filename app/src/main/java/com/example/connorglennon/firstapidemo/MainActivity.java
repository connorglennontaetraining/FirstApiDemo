package com.example.connorglennon.firstapidemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.connorglennon.firstapidemo.data.AppDataManager;
import com.example.connorglennon.firstapidemo.data.network.model.CakeModel;
import com.example.connorglennon.firstapidemo.data.network.services.RequestInterface;
import com.example.connorglennon.firstapidemo.data.network.services.ServerConnection;
import com.example.connorglennon.firstapidemo.views.CakeAdapter;
import com.example.connorglennon.firstapidemo.views.CakeListPresenter;
import com.example.connorglennon.firstapidemo.views.ICakeListView;
import com.example.connorglennon.firstapidemo.views.cakelist.utils.rx.AppSchedulerProvider;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements ICakeListView{

    private RecyclerView recyclerView;
    List<CakeModel> cakesList;
    private CakeListPresenter<MainActivity> cakeListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialisePresenter();
        cakeListPresenter.onCallCakeList();

        recyclerView = (RecyclerView) findViewById(R.id.rvCakeList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public void initialisePresenter()
    {
        cakeListPresenter = new CakeListPresenter<>(new AppDataManager(),
                new AppSchedulerProvider(),
                new CompositeDisposable());
        cakeListPresenter.onAttach(this);
    }

    @Override
    public void onFetchDataSuccess(List<CakeModel> cakeModels) {
        recyclerView.setAdapter(new CakeAdapter(cakeModels, R.layout.rv_cakes_list_item, this));
    }

    @Override
    public void onFetchDataError(String message) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void openActivityOnTokenExpire() {

    }

    @Override
    public void onError(int resId) {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void showMessage(int resId) {

    }

    @Override
    public boolean isNetworkConnected() {
        return false;
    }

    @Override
    public void hideKeyboard() {

    }
}
