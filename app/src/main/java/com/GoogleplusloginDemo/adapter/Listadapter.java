package com.GoogleplusloginDemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.GoogleplusloginDemo.R;
import com.GoogleplusloginDemo.customui.ProfileImageView;
import com.GoogleplusloginDemo.pojo.Data_list;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

/**
 * Created by chavali on 2017-02-25.
 */

public class Listadapter extends RecyclerView.Adapter<Listadapter.ViewHolder> {

    Context context;
    ArrayList<Data_list> mItems;
    int width, height;


    public Listadapter(ArrayList<Data_list> items) {
        mItems = items;

    }


    @Override
    public Listadapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent, false);
        context = parent.getContext();
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final Listadapter.ViewHolder holder, final int position) {


        holder.name.setText(mItems.get(position).getName());
        holder.enddate.setText(mItems.get(position).getEndDate());

        Glide.with(context).load(mItems.get(position).getIcon())
                .thumbnail(0.5f)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.logo);

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name, enddate;
        ProfileImageView logo;
ImageView add,sub;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            enddate = (TextView) itemView.findViewById(R.id.end_date);
            add= (ImageView) itemView.findViewById(R.id.add_item);
            sub= (ImageView) itemView.findViewById(R.id.remove_item);

            logo = (ProfileImageView) itemView.findViewById(R.id.profile_icon);


        }


    }
}
