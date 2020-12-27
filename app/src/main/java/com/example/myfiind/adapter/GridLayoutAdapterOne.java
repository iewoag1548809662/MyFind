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
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.myfiind.R;
import com.example.myfiind.bean.HomeBean;

import java.util.List;

public class GridLayoutAdapterOne extends RecyclerView.Adapter {

    private Context context;
    private List<HomeBean.DataDTO.TopicListDTO> topicListDTOList;

    public GridLayoutAdapterOne(Context context, List<HomeBean.DataDTO.TopicListDTO> topicListDTOList) {
        this.context = context;
        this.topicListDTOList = topicListDTOList;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.activity_gridlayoutone, parent, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.tv_gidlayout_one.setText(topicListDTOList.get(position).getTitle());
       myViewHolder.tv_gidlayout_one2.setText(topicListDTOList.get(position).getSubtitle());
       myViewHolder.tv_gidlayout3.setText(topicListDTOList.get(position).getTopic_category_id()+"");
        Glide.with(context).load(topicListDTOList.get(position).getItem_pic_url()).into(myViewHolder.img_gidlayout_one);
    }

    @Override
    public int getItemCount() {
        return topicListDTOList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_gidlayout_one;
        private TextView tv_gidlayout3;
        private TextView tv_gidlayout_one2;
        private ImageView img_gidlayout_one;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_gidlayout_one = itemView.findViewById(R.id.tv_gidlayout_one);
            tv_gidlayout3 = itemView.findViewById(R.id.tv_gidlayout3);
            tv_gidlayout_one2 = itemView.findViewById(R.id.tv_gidlayout_one2);
            img_gidlayout_one = itemView.findViewById(R.id.img_gidlayout_one);

        }
    }
}
