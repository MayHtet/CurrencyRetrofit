package com.example.mizuki.concurrencyretrofit.activities.viewholders;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder implements View.OnClickListener{

    protected T mData;

    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);

        itemView.setOnClickListener(this);
    }

    public void setmData(T mData) {
        this.mData = mData;
    }

    public abstract void bind(Context context);
}
