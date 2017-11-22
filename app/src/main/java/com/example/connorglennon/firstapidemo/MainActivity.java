package com.example.connorglennon.firstapidemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.example.connorglennon.firstapidemo.model.CakeModel;
import com.example.connorglennon.firstapidemo.services.RequestInterface;
import com.example.connorglennon.firstapidemo.services.ServerConnection;
import com.example.connorglennon.firstapidemo.views.CakeAdapter;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private RequestInterface requestInterface;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.rvCakeList);

        requestInterface = ServerConnection.getServerConnection();
        requestInterface.getCakeList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<List<CakeModel>>(){

                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.i("SUBSCIBED", d.toString());
                    }

                    @Override
                    public void onNext(List<CakeModel> value) {
                        Log.i("ONNEXT", value.toString());
                        ArrayList<CakeModel> cakeList = new ArrayList<CakeModel>();

                        for(CakeModel cakeModel: value)
                        {
                            Log.i("CakeList", cakeModel.getTitle());
                            cakeList.add(cakeModel);
                        }

                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        recyclerView.setAdapter(new CakeAdapter(value, R.layout.rv_cakes_list_item, getApplicationContext()));
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
