package com.example.hrecycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<CoinInfo> mDataModels;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HRecyclerView hRecyclerView= findViewById(R.id.id_hrecyclerview);
        mDataModels = new ArrayList<>();
        for(int i=0;i<100;i++) {
            CoinInfo coinInfo = new CoinInfo();
            coinInfo.name = "USDT";
            coinInfo.priceLast="20.0";
            coinInfo.riseRate24="0.2";
            coinInfo.vol24="10020";
            coinInfo.close="22.2";
            coinInfo.open="40.0";
            coinInfo.bid="33.2";
            coinInfo.ask="19.0";
            coinInfo.amountPercent = "33.3%";
            mDataModels.add(coinInfo);
        }

        hRecyclerView.setHeaderListData(getResources().getStringArray(R.array.right_title_name));

        CoinAdapter adapter = new CoinAdapter(this, mDataModels, R.layout.item_layout, new CommonViewHolder.onItemCommonClickListener() {
            @Override
            public void onItemClickListener(int position) {
                Toast.makeText(MainActivity.this, "position--->"+position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClickListener(int position) {

            }
        });

        hRecyclerView.setAdapter(adapter);

    }
}
