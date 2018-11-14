package com.example.mizuki.concurrencyretrofit.activities.delagate;

import com.example.mizuki.concurrencyretrofit.activities.data.vos.CurrencyVO;

public interface DataCheckCallback {

    //void loadCurrencyValue(boolean flag);

    void loadCurrencyValue(CurrencyVO currencyVO);
}
