package com.GoogleplusloginDemo;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.GoogleplusloginDemo.adapter.Listadapter;
import com.GoogleplusloginDemo.apiclient.ApiClient;
import com.GoogleplusloginDemo.apiclient.ApiInterface;
import com.GoogleplusloginDemo.customui.Custom_CircularProgressView;
import com.GoogleplusloginDemo.pojo.Data_list;
import com.GoogleplusloginDemo.pojo.Example;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Secondscreen extends AppCompatActivity {

    RecyclerView data_recyclerview;
    Listadapter adapter;

    Dialog dialog;
    Custom_CircularProgressView mProgressView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondscreen);
        dialog = new Dialog(Secondscreen.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setContentView(R.layout.activity_coupon);
        dialog.setCancelable(false);
        mProgressView = (Custom_CircularProgressView) dialog.findViewById(R.id.progress_dialog);
        mProgressView.startAnimation();
        mProgressView.setVisibility(View.VISIBLE);

        dialog.show();

        Loadguide_second();
        data_recyclerview = (RecyclerView) findViewById(R.id.data_recyclerview);

    }


    private void Loadguide_second() {

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<Example> call = apiService.getguide();
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {

                if (response.body() != null) {

                    ArrayList<Data_list> trending_list = response.body().getData();

                    Log.e("trending_list", String.valueOf(trending_list.size()));
                    //    deallist2.addAll()
                    adapter = new Listadapter(trending_list);
                    data_recyclerview.setAdapter(adapter);
                    data_recyclerview.setLayoutManager(new LinearLayoutManager(Secondscreen.this));

                    if ((dialog != null) && dialog.isShowing()) {
                        dialog.dismiss();
                        mProgressView.stopAnimation();
                        mProgressView.setVisibility(View.GONE);

                    }

                }


            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Toast.makeText(Myapplication.getAppContext(), "Something went wrong. Try again later", Toast.LENGTH_LONG).show();

            }
        });


    }
}

