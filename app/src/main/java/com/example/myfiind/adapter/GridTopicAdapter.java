package com.example.myfiind.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.myfiind.R;
import com.example.myfiind.bean.HomeBean;

import java.util.List;

public class GridTopicAdapter extends DelegateAdapter.Adapter {
    private FragmentActivity context;
    private List<HomeBean.DataDTO.CategoryListDTO.GoodsListDTO> goodsList;
    private GridLayoutHelper gridLayoutHelper;

    public GridTopicAdapter(FragmentActivity context, List<HomeBean.DataDTO.CategoryListDTO.GoodsListDTO> goodsList, GridLayoutHelper gridLayoutHelper) {
        this.context = context;
        this.goodsList = goodsList;
        this.gridLayoutHelper = gridLayoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.activity_gri, parent, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.tv_top.setText(goodsList.get(position).getName());
        myViewHolder.tv_top2.setText(goodsList.get(position).getRetail_price()+"");
        Glide.with(context).load(goodsList.get(position).getList_pic_url()).into(myViewHolder.img_top);
    }

    @Override
    public int getItemCount() {
        return goodsList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_top;
        private TextView tv_top2;
        private ImageView img_top;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_top = itemView.findViewById(R.id.tv_top);
            tv_top2 = itemView.findViewById(R.id.tv_top2);
            img_top = itemView.findViewById(R.id.img_top);
        }
    }
}
