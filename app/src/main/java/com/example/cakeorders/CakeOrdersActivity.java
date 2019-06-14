package com.example.cakeorders;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.cakeorders.cakeFactory.CakeObject;

import java.util.ArrayList;

public class CakeOrdersActivity extends AppCompatActivity implements CakeRepository.DataCommunicator{
    private static final String TAG = "CAKE_ACTIVITY";
    private RecyclerView cakeRecyclerView;
    private CakeOrdersAdapter cakeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cake_orders);

        final Button showCakes = findViewById(R.id.show_cake_options);

        cakeRecyclerView = findViewById(R.id.cake_options_view);
        cakeRecyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager cakesLayoutManager = new LinearLayoutManager(this);
        cakeRecyclerView.setLayoutManager(cakesLayoutManager);
        cakeAdapter = new CakeOrdersAdapter();
        cakeRecyclerView.setAdapter(cakeAdapter);

        showCakes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CakeRepository.getInstance().showCakes(CakeOrdersActivity.this);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        CakeRepository.getInstance().addToSet(this);
    }

    @Override
    protected void onPause() {
        CakeRepository.getInstance().removeFromSet(this);

        super.onPause();
    }

    @Override
    public void sendCake(final ArrayList<CakeObject> cakeArrayList) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                cakeAdapter.updateCakeList(cakeArrayList);
            }
        });
    }
}
