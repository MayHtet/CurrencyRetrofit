package com.example.mizuki.concurrencyretrofit.activities.data.vos;

public class CurrencyRateVO {

    private String unit;
    private Double rate;

    public CurrencyRateVO(){}

    public CurrencyRateVO(Double rate ,String unit){
        this.unit = unit;
        this.rate = rate;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}
