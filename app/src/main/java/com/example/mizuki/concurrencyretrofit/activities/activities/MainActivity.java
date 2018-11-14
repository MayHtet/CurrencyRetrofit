package com.example.mizuki.concurrencyretrofit.activities.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mizuki.concurrencyretrofit.R;
import com.example.mizuki.concurrencyretrofit.activities.adapters.CurrencyRateRecyclerAdapter;
import com.example.mizuki.concurrencyretrofit.activities.data.vos.CurrencyRateVO;
import com.example.mizuki.concurrencyretrofit.activities.data.vos.CurrencyUnitVO;
import com.example.mizuki.concurrencyretrofit.activities.data.vos.CurrencyVO;
import com.example.mizuki.concurrencyretrofit.activities.data.vos.Rates;
import com.example.mizuki.concurrencyretrofit.activities.delagate.CurrencyUnitCallback;
import com.example.mizuki.concurrencyretrofit.activities.delagate.DataCheckCallback;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.tv_date)
    TextView tvDate;
    @BindView(R.id.rv_currency)
    RecyclerView rvCurrency;

    List<CurrencyRateVO> mCurrencyList = new ArrayList<>();
    CurrencyVO mCurrencyVO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(checkNetwork()) {

//
//            getmAppModel().loadCurrencyUnit(this, "3e485d20bffbf2c1757bfc21e13df564", new CurrencyUnitCallback() {
//                @Override
//                public void loadCurrencyUnit(CurrencyUnitVO currencyUnitVO) {
//                    if (currencyUnitVO != null)
//                        Toast.makeText(MainActivity.this,currencyUnitVO.getSuccess().toString(),Toast.LENGTH_LONG).show();
//                    else
//                        Toast.makeText(MainActivity.this,"Fail",Toast.LENGTH_LONG).show();
//                }
//            });

            getmAppModel().loadCurrency(this, "3e485d20bffbf2c1757bfc21e13df564", new DataCheckCallback() {

                @Override
                public void loadCurrencyValue(CurrencyVO currencyVO) {

                    mCurrencyVO = currencyVO;

                    tvDate.setText(mCurrencyVO.getDate());

                    prepareData();
                    setupRecyclerView();


                    Log.e("Inside null?",(mCurrencyVO == null)+"");
                }
            });

        }
        else{
            showAlertDialog();
        }

    }

    private void prepareData() {

        Rates rates = mCurrencyVO.getRates();
        mCurrencyList.add(new CurrencyRateVO(rates.getMMK(),"MMK"));
        mCurrencyList.add(new CurrencyRateVO(rates.getBTC(),"BTC"));
        mCurrencyList.add(new CurrencyRateVO(rates.getCNY(),"CNY"));
        mCurrencyList.add(new CurrencyRateVO(rates.getKRW(),"KRW"));
        mCurrencyList.add(new CurrencyRateVO(rates.getSGD(),"SGD"));
        mCurrencyList.add(new CurrencyRateVO(rates.getEGP(),"EGP"));


        Log.e("List size is ",mCurrencyList.size()+"");
    }

    private void setupRecyclerView() {

        CurrencyRateRecyclerAdapter currencyRateRecyclerAdapter = new CurrencyRateRecyclerAdapter(this);
        rvCurrency.setLayoutManager(new LinearLayoutManager(this));
        rvCurrency.setAdapter(currencyRateRecyclerAdapter);
        currencyRateRecyclerAdapter.setData(mCurrencyList);
    }

    private void showAlertDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("Network not connected")
                .setMessage("Please connect to network!")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
        builder.create().show();
    }

    private boolean checkNetwork() {

        ConnectivityManager cm =
                (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        return (activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting());
    }

    @Override
    protected boolean setHomeAsUpEnabled() {
        return false;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }
}
