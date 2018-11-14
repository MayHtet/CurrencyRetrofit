package com.example.mizuki.concurrencyretrofit.activities.data.model;

import android.annotation.SuppressLint;
import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.support.v7.util.AsyncListUtil;
import android.widget.Toast;

import com.example.mizuki.concurrencyretrofit.activities.data.db.CurrencyDatabase;
import com.example.mizuki.concurrencyretrofit.activities.data.vos.CurrencyUnitVO;
import com.example.mizuki.concurrencyretrofit.activities.data.vos.CurrencyVO;
import com.example.mizuki.concurrencyretrofit.activities.delagate.CurrencyUnitCallback;
import com.example.mizuki.concurrencyretrofit.activities.delagate.DataCheckCallback;
import com.example.mizuki.concurrencyretrofit.activities.network.CurrencyRetrofitAPI;
import com.example.mizuki.concurrencyretrofit.activities.utils.APIConstant;
import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@SuppressLint("CheckResult")
public class AppModel extends AndroidViewModel {

    private CurrencyDatabase mCurrencyDatabase;

    private CurrencyRetrofitAPI mCurrencyRetrofitAPI;

    public AppModel(Application context) {
        super(context);
        //initDatabase(context);

        initAPI();
    }

    private void initAPI() {

    final OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIConstant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();

        mCurrencyRetrofitAPI = retrofit.create(CurrencyRetrofitAPI.class);
    }

    private void initDatabase(Context context) {

        mCurrencyDatabase = CurrencyDatabase.getMemoryDatabase(context);
    }


    public void loadCurrency(Context context, String accessKey, final DataCheckCallback dataCheckCallback){
        mCurrencyRetrofitAPI.loadCurrency(accessKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CurrencyVO>() {
                    @Override
                    public void accept(CurrencyVO currencyVO) throws Exception {
                        if(currencyVO != null)
                            dataCheckCallback.loadCurrencyValue(currencyVO);

                    }
                });

    }

    public void loadCurrencyUnit(final Context context, String accessKey, final CurrencyUnitCallback currencyUnitCallback){
        mCurrencyRetrofitAPI.loadCurrencyUnit(accessKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CurrencyUnitVO>() {
                    @Override
                    public void accept(CurrencyUnitVO currencyUnitVO) throws Exception {

                            currencyUnitCallback.loadCurrencyUnit(currencyUnitVO);

                    }
                });
    }


}
