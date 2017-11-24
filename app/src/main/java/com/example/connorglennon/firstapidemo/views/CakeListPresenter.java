package com.example.connorglennon.firstapidemo.views;

import com.example.connorglennon.firstapidemo.data.DataManager;
import com.example.connorglennon.firstapidemo.data.network.model.CakeModel;
import com.example.connorglennon.firstapidemo.views.cakelist.ui.base.BasePresenter;
import com.example.connorglennon.firstapidemo.views.cakelist.utils.rx.SchedulerProvider;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Created by Connor Glennon on 24/11/2017.
 */

public class CakeListPresenter<V extends ICakeListView> extends BasePresenter<V> implements ICakeListPresenter<V>
{


    public CakeListPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onCallCakeList() {
        getCompositeDisposable().
                add(getDataManager()
                        .getCakeModelList()
                        .observeOn(getSchedulerProvider().ui())
                        .subscribeOn(getSchedulerProvider().io())
                        .subscribe(new Consumer<List<CakeModel>>() {
                                       @Override
                                       public void accept(List<CakeModel> cakeModels) throws Exception {
                                           getMvpView().onFetchDataSuccess(cakeModels);
                                       }
                                   },
                                    new Consumer<Throwable>() {
                                        @Override
                                        public void accept(Throwable throwable) throws Exception {
                                            getMvpView().onError(throwable.getMessage());
                                        }
                                    }
                                ));
    }
}
