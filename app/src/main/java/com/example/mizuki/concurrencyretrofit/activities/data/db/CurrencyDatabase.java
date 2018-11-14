package com.example.mizuki.concurrencyretrofit.activities.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.mizuki.concurrencyretrofit.activities.data.dao.CurrencyDao;
import com.example.mizuki.concurrencyretrofit.activities.data.vos.CurrencyVO;
import com.example.mizuki.concurrencyretrofit.activities.utils.DatabaseUtil;



public abstract class CurrencyDatabase extends RoomDatabase{

    public static CurrencyDatabase INSTANCE;


    public static CurrencyDatabase getMemoryDatabase(Context context){

        if(INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), CurrencyDatabase.class, DatabaseUtil.DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build();
        }

        return INSTANCE;
    }

    public abstract CurrencyDao currencyDao();
}
