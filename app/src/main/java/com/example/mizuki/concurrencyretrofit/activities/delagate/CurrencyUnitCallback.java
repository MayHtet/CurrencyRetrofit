package com.example.mizuki.concurrencyretrofit.activities.delagate;

import com.example.mizuki.concurrencyretrofit.activities.data.vos.CurrencyUnitVO;

public interface CurrencyUnitCallback {

    void loadCurrencyUnit(CurrencyUnitVO currencyUnitVO);
}
