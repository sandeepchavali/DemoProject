package com.GoogleplusloginDemo;

import android.app.Application;
import android.content.Context;

import com.GoogleplusloginDemo.model2.ModelCart;
import com.GoogleplusloginDemo.model2.ModelProducts;

import java.util.ArrayList;

/**
 * Created by chavali on 2017-02-24.
 */

public class Myapplication extends Application {
    private static Myapplication mInstance;
    private static Context context;
    private ArrayList<ModelProducts> myProducts = new ArrayList<ModelProducts>();
    private ModelCart myCart = new ModelCart();

    public static synchronized Myapplication getInstance() {
        return mInstance;
    }

    public static Context getAppContext() {
        return Myapplication.context;
    }

    @Override
    public void onCreate() {
        super.onCreate();


        Myapplication.context = getApplicationContext();

    }

    public ModelProducts getProducts(int pPosition) {

        return myProducts.get(pPosition);
    }

    public void setProducts(ModelProducts Products) {

        myProducts.add(Products);

    }

    public ModelCart getCart() {

        return myCart;

    }

    public int getProductsArraylistSize() {

        return myProducts.size();
    }


}
