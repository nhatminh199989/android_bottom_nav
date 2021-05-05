package com.example.btvn_bottomnav;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.CatViewHolder> {
    Activity activity;
    ArrayList<Cat> catArrayList;

    public CatAdapter(Activity activity, ArrayList<Cat> catArrayList) {
        this.activity = activity;
        this.catArrayList = catArrayList;
    }

    @NonNull
    @Override
    public CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       return new CatViewHolder(activity.getLayoutInflater().inflate(R.layout.custom_design,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CatViewHolder holder, int position) {
        Cat  c = catArrayList.get(position);
        holder.img.setImageResource(c.getImage());
        holder.name.setText(c.getName());
        holder.price.setText(c.getPrice());
        holder.del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                catArrayList.remove(position);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return catArrayList.size();
    }

    public class CatViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name;
        TextView price;
        Button del;

        public CatViewHolder(@NonNull View v){
            super(v);
            img = v.findViewById(R.id.img);
            name = v.findViewById(R.id.tv_name);
            price = v.findViewById(R.id.tv_price);
            del = v.findViewById(R.id.btn_del);
        }
    }
}
