package com.example.connorglennon.firstapidemo.data.network;

import com.example.connorglennon.firstapidemo.data.network.model.CakeModel;
import com.example.connorglennon.firstapidemo.data.network.services.RequestInterface;
import com.example.connorglennon.firstapidemo.data.network.services.ServerConnection;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Connor Glennon on 24/11/2017.
 */

public class AppApiHelper implements ApiHelper {

    RequestInterface requestInterface;

    public AppApiHelper() {
        //TODO dependency injection
        this.requestInterface = ServerConnection.getServerConnection();
    }

    @Override
    public Observable<List<CakeModel>> getCakeModelList() {
        return requestInterface.getCakeList();
    }
}
