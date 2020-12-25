package com.example.myfiind.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.myfiind.R;
import com.example.myfiind.bean.HomeBean;

import java.util.List;

public class LinearLayoutAdapter extends DelegateAdapter.Adapter {

    private LinearLayoutHelper LinearLayoutHelper ;
    private Context context;
    private List<HomeBean.DataDTO.HotGoodsListDTO> listDTOS;

    public LinearLayoutAdapter(LinearLayoutHelper  LinearLayoutHelper , Context context, List<HomeBean.DataDTO.HotGoodsListDTO> listDTOS) {
        this.LinearLayoutHelper  = LinearLayoutHelper ;
        this.context = context;
        this.listDTOS = listDTOS;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return LinearLayoutHelper;
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
        myViewHolder.tv_linearLayout.setText(listDTOS.get(position).getName());
        myViewHolder.tv_linearLayout2.setText(listDTOS.get(position).getGoods_brief());
        myViewHolder.tv_linearLayout3.setText(listDTOS.get(position).getRetail_price()+"");
        Glide.with(context).load(listDTOS.get(position).getList_pic_url()).into(myViewHolder.img_linearLayout);
    }

    @Override
    public int getItemCount() {
        return listDTOS.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_linearLayout;
        private TextView tv_linearLayout2;
        private TextView tv_linearLayout3;
        private ImageView img_linearLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_linearLayout = itemView.findViewById(R.id.tv_linearLayout);
            tv_linearLayout2 = itemView.findViewById(R.id.tv_linearLayout2);
            tv_linearLayout3 = itemView.findViewById(R.id.tv_linearLayout3);
            img_linearLayout = itemView.findViewById(R.id.img_linearLayout);

        }
    }
}
