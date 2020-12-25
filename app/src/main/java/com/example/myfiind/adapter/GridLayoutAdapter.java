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

public class GridLayoutAdapter extends DelegateAdapter.Adapter {

    private Context context;
    private List<HomeBean.DataDTO.NewGoodsListDTO> listDTOS;
    private GridLayoutHelper gridLayoutHelper;

    public GridLayoutAdapter(Context context, List<HomeBean.DataDTO.NewGoodsListDTO> listDTOS, GridLayoutHelper gridLayoutHelper) {
        this.context = context;
        this.listDTOS = listDTOS;
        this.gridLayoutHelper = gridLayoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper;
    }
        //activty_gridlayout
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.activity_gridlayout, parent, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.tv_gidlayout_cd.setText(listDTOS.get(position).getName());
        myViewHolder.tv_gidlayout_cd2.setText(listDTOS.get(position).getRetail_price()+"");
        Glide.with(context).load(listDTOS.get(position).getList_pic_url()).into(myViewHolder.img_gidlayout_cd);
    }

    @Override
    public int getItemCount() {
        return listDTOS.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_gidlayout_cd;
        private TextView tv_gidlayout_cd2;
        private ImageView img_gidlayout_cd;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_gidlayout_cd = itemView.findViewById(R.id.tv_gidlayout_cd);
            tv_gidlayout_cd2 = itemView.findViewById(R.id.tv_gidlayout_cd2);
            img_gidlayout_cd = itemView.findViewById(R.id.img_gidlayout_cd);
        }
    }
}
