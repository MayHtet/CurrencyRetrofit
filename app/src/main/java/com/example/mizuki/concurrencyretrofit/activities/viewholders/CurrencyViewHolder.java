package com.example.mizuki.concurrencyretrofit.activities.viewholders;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.example.mizuki.concurrencyretrofit.R;
import com.example.mizuki.concurrencyretrofit.activities.data.vos.CurrencyRateVO;
import com.example.mizuki.concurrencyretrofit.activities.data.vos.CurrencyVO;

import butterknife.BindView;

public class CurrencyViewHolder extends BaseViewHolder<CurrencyRateVO>{

    @BindView(R.id.tv_rate)
    TextView tvRate;
    @BindView(R.id.tv_unit)
    TextView tvUnit;

    public CurrencyViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    @Override
    public void bind(Context context) {

        tvRate.setText(mData.getRate().toString());
        tvUnit.setText(mData.getUnit());
    }

    @Override
    public void onClick(View v) {

    }
}
