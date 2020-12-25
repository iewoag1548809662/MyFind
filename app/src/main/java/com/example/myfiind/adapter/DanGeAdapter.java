package com.example.myfiind.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.example.myfiind.R;
import com.example.myfiind.bean.HomeBean;

import java.util.List;

public class DanGeAdapter extends DelegateAdapter.Adapter {


    private String name;
    private LinearLayoutHelper dange;
    private Context context;

    public DanGeAdapter(String name, LinearLayoutHelper dange, Context context) {

        this.name = name;
        this.dange = dange;
        this.context = context;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return dange;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.activity_dange, parent, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.tv_dan.setText(name);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_dan;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_dan = itemView.findViewById(R.id.tv_dan);


        }
    }
}
