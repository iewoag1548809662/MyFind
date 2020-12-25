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

public class LinearLayoutHelperAdapter extends DelegateAdapter.Adapter {

    private LinearLayoutHelper linearLayoutHelper;
    private Context context;

    public LinearLayoutHelperAdapter(LinearLayoutHelper linearLayoutHelper, Context context) {
        this.linearLayoutHelper = linearLayoutHelper;
        this.context = context;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return linearLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.activity_linearlayout, parent, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.tv_LinearLayoutHelper.setText("品牌制造商直供");
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_LinearLayoutHelper;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_LinearLayoutHelper = itemView.findViewById(R.id.tv_LinearLayoutHelper);

        }
    }
}
