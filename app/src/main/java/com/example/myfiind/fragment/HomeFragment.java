package com.example.myfiind.fragment;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.myfiind.R;
import com.example.myfiind.adapter.ColumnLayoutHelperAdapter;
import com.example.myfiind.base.BaseFragment;
import com.example.myfiind.bean.HomeBean;
import com.example.myfiind.interfacer.MainContract;
import com.example.myfiind.presenter.MainPrenter;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends BaseFragment<MainPrenter> implements MainContract.Iview {


    private Button search;
    private RecyclerView recyclerView;
    private Banner banner;
    private ColumnLayoutHelperAdapter columnLayoutHelperAdapter;
    private ArrayList<HomeBean.DataDTO.ChannelDTO> channelDTOS;

    @Override
    protected int getViewLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(View inflate) {
        search = inflate.findViewById(R.id.butts);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //搜索后续操作
            }
        });

        recyclerView = inflate.findViewById(R.id.recyclerView);

        banner = inflate.findViewById(R.id.banner);
        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(getActivity());
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        recyclerView.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 10);


        //开始
        /**
         设置栏格布局
         /**
         设置栏格布局
         */
        ColumnLayoutHelper columnLayoutHelper = new ColumnLayoutHelper();
        // 创建对象

        // 公共属性
        columnLayoutHelper.setItemCount(3);// 设置布局里Item个数
       /* columnLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        columnLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        columnLayoutHelper.setBgColor(Color.GRAY);// 设置背景颜色*/
        columnLayoutHelper.setAspectRatio(6);// 设置设置布局内每行布局的宽与高的比

        // columnLayoutHelper特有属性
        columnLayoutHelper.setWeights(new float[]{30, 40, 30});// 设置该行每个Item占该行总宽度的比例
        // 同上面Weigths属性讲解

        // columnLayoutHelper特有属性
        //columnLayoutHelper.setWeights(new float[]{30, 40, 30});// 设置该行每个Item占该行总宽度的比例
        // 同上面Weigths属性讲解
        channelDTOS = new ArrayList<>();
        columnLayoutHelperAdapter = new ColumnLayoutHelperAdapter(columnLayoutHelper, getActivity(), channelDTOS);
        recyclerView.setLayoutManager(virtualLayoutManager);
        recyclerView.setAdapter(columnLayoutHelperAdapter);

        //下一个布局


    }

    @Override
    protected void initDatas() {
        Ipresenter.getHomes();
    }

    @Override
    protected MainPrenter getPresenter() {
        return new MainPrenter();
    }


    @Override
    public void getHomesDatas(HomeBean homeBean) {
        banner.setImages(homeBean.getData().getBanner()).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                HomeBean.DataDTO.BannerDTO bannerDTO = (HomeBean.DataDTO.BannerDTO) path;
                Glide.with(context).load(bannerDTO.getImage_url()).into(imageView);
            }
        }).start();

        List<HomeBean.DataDTO.ChannelDTO> channel = homeBean.getData().getChannel();
        channelDTOS.addAll(channel);
        columnLayoutHelperAdapter.notifyDataSetChanged();
    }
}