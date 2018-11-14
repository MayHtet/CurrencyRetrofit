
package com.example.mizuki.concurrencyretrofit.activities.data.vos;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class CurrencyUnitVO {

    @SerializedName("success")
    private Boolean mSuccess;
    @SerializedName("symbols")
    private Symbols mSymbols;

    public Boolean getSuccess() {
        return mSuccess;
    }

    public void setSuccess(Boolean success) {
        mSuccess = success;
    }

    public Symbols getSymbols() {
        return mSymbols;
    }

    public void setSymbols(Symbols symbols) {
        mSymbols = symbols;
    }

}
