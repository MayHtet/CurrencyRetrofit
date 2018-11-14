package com.example.mizuki.concurrencyretrofit.activities.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.mizuki.concurrencyretrofit.activities.data.model.AppModel;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity{

   private AppModel mAppModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());

        ButterKnife.bind(this,this);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(setHomeAsUpEnabled());
        }
        mAppModel = ViewModelProviders.of(this).get(AppModel.class);
    }

    protected abstract boolean setHomeAsUpEnabled();

    public abstract int getLayout();

    public AppModel getmAppModel() {
        return mAppModel;
    }
}


