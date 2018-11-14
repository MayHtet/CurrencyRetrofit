package com.example.mizuki.concurrencyretrofit.activities.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mizuki.concurrencyretrofit.R;
import com.example.mizuki.concurrencyretrofit.activities.data.vos.CurrencyRateVO;
import com.example.mizuki.concurrencyretrofit.activities.viewholders.CurrencyViewHolder;

public class CurrencyRateRecyclerAdapter extends BaseRecyclerAdapter<CurrencyViewHolder,CurrencyRateVO> {

    public CurrencyRateRecyclerAdapter(Context context) {
        super(context);
    }

    @NonNull
    @Override
    public CurrencyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_view_currency,viewGroup,false);
        return new CurrencyViewHolder(view);
    }
}
