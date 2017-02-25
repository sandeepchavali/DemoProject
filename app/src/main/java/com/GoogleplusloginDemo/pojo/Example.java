package com.GoogleplusloginDemo.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by chavali on 2017-02-25.
 */

public class Example {
    @SerializedName("total")
    @Expose
    private String total;
    @SerializedName("data")
    @Expose
    private ArrayList<Data_list> data = null;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public ArrayList<Data_list> getData() {
        return data;
    }

    public void setData(ArrayList<Data_list> data) {
        this.data = data;
    }
}
