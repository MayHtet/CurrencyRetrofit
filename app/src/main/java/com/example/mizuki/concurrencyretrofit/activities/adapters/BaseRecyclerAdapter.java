package com.example.mizuki.concurrencyretrofit.activities.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import com.example.mizuki.concurrencyretrofit.activities.viewholders.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRecyclerAdapter<M extends BaseViewHolder, T> extends RecyclerView.Adapter<M>{

    protected List<T> mData;
    protected LayoutInflater mLayoutInflater;

    public BaseRecyclerAdapter(Context context){

        mData = new ArrayList<>();
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public void onBindViewHolder(@NonNull M m, int i) {
        if (mData.size() > 0) {

            m.setmData(mData.get(i));
            m.bind(mLayoutInflater.getContext());
        }

    }

    public void setData(List<T> data){
        this.mData = data;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
