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
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.myfiind.R;
import com.example.myfiind.bean.HomeBean;

import java.util.List;

public class GridLayoutHelperAdapter extends DelegateAdapter.Adapter {

    private Context context;
    private GridLayoutHelper gridLayoutHelper;

    private List<HomeBean.DataDTO.BrandListDTO> list;

    public GridLayoutHelperAdapter(Context context, GridLayoutHelper gridLayoutHelper, List<HomeBean.DataDTO.BrandListDTO> list) {
        this.context = context;
        this.gridLayoutHelper = gridLayoutHelper;
        this.list = list;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper;
    }
    //context_gridlayouthelper
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View inflate = LayoutInflater.from(context).inflate(R.layout.activity_gridlayouthelper, parent, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.tv_gidlayout.setText(list.get(position).getName());

        myViewHolder.tv_gidlayout2.setText(list.get(position).getFloor_price()+"");
        Glide.with(context).load(list.get(position).getNew_pic_url()).into(myViewHolder.img_gidlayout);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_gidlayout;
        private TextView tv_gidlayout2;
        private ImageView img_gidlayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_gidlayout = itemView.findViewById(R.id.tv_gidlayout);
            tv_gidlayout2 = itemView.findViewById(R.id.tv_gidlayout2);
            img_gidlayout = itemView.findViewById(R.id.img_gidlayout);
        }
    }

}
