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
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.myfiind.R;
import com.example.myfiind.bean.HomeBean;

import java.util.List;

public class ColumnLayoutHelperAdapter extends DelegateAdapter.Adapter {

    private com.alibaba.android.vlayout.layout.GridLayoutHelper GridLayoutHelper;
    private Context context;
    private List<HomeBean.DataDTO.ChannelDTO> list;

    public ColumnLayoutHelperAdapter(GridLayoutHelper GridLayoutHelper, Context context, List<HomeBean.DataDTO.ChannelDTO> list) {
        this.GridLayoutHelper = GridLayoutHelper;
        this.context = context;
        this.list = list;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return GridLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_columnlayout, parent, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.tv_colmn.setText(list.get(position).getName());
        Glide.with(context).load(list.get(position).getIcon_url()).into(myViewHolder.img_colmn);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_colmn;
        private ImageView img_colmn;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_colmn = itemView.findViewById(R.id.tv_colmn);
            img_colmn = itemView.findViewById(R.id.img_colmn);
        }
    }
}
