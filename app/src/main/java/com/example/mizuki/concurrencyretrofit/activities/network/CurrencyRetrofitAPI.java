package com.example.mizuki.concurrencyretrofit.activities.network;
import com.example.mizuki.concurrencyretrofit.activities.data.vos.CurrencyUnitVO;
import com.example.mizuki.concurrencyretrofit.activities.data.vos.CurrencyVO;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CurrencyRetrofitAPI {

    @GET("latest")
    Single<CurrencyVO> loadCurrency(
        @Query("access_key") String accessKey
    );

    @GET("symbols")
    Single<CurrencyUnitVO> loadCurrencyUnit(
            @Query("access_key") String accessKey
    );
}
