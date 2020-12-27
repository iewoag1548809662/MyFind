package com.example.myfiind.fragment;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.myfiind.R;
import com.example.myfiind.adapter.BannerAdapter;
import com.example.myfiind.adapter.ButtonAdapter;
import com.example.myfiind.adapter.ColumnLayoutHelperAdapter;
import com.example.myfiind.adapter.DanGeAdapter;
import com.example.myfiind.adapter.GridLayoutAdapter;
import com.example.myfiind.adapter.GridLayoutAdapterOne;
import com.example.myfiind.adapter.GridLayoutHelperAdapter;
import com.example.myfiind.adapter.GridTopicAdapter;
import com.example.myfiind.adapter.LinearLayoutAdapter;
import com.example.myfiind.adapter.LinearLayoutHelperAdapter;
import com.example.myfiind.adapter.TopicListDTOAdapter;
import com.example.myfiind.base.BaseFragment;
import com.example.myfiind.bean.HomeBean;
import com.example.myfiind.interfacer.MainContract;
import com.example.myfiind.presenter.MainPrenter;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends BaseFragment<MainPrenter> implements MainContract.Iview {


   // private Button search;
    private RecyclerView recyclerView;
    private ColumnLayoutHelperAdapter columnLayoutHelperAdapter;
    private ArrayList<HomeBean.DataDTO.ChannelDTO> channelDTOS;
    private ArrayList<HomeBean.DataDTO.BrandListDTO> brandListDTOS;
    private GridLayoutHelperAdapter gridLayoutHelperAdapter;
    private ArrayList<HomeBean.DataDTO.NewGoodsListDTO> newGoodsListDTOS;
    private GridLayoutAdapter gridLayoutAdapter;
    private ArrayList<HomeBean.DataDTO.HotGoodsListDTO> hotGoodsListDTOS;
    private LinearLayoutAdapter linearLayoutAdapter;
    private ArrayList<HomeBean.DataDTO.TopicListDTO> topicListDTOS;
    private GridLayoutAdapterOne gridLayoutAdapterOne;
    private DanGeAdapter danGeAdapter;
    private DanGeAdapter danGeAdapter1;
    private GridTopicAdapter gridTopicAdapter;
    private DelegateAdapter delegateAdapter;
    private ArrayList<HomeBean.DataDTO.BannerDTO> bannerDTOS;
    private BannerAdapter bannerAdapter;
    private LinearLayoutHelperAdapter linearLayoutHelperAdapter;
    private VirtualLayoutManager virtualLayoutManager;
    private ButtonAdapter buttonAdapter;
    private TopicListDTOAdapter topicListDTOAdapter;


    @Override
    protected int getViewLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(View inflate) {
       /* search = inflate.findViewById(R.id.butts);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //搜索后续操作
            }
        });
*/
        recyclerView = inflate.findViewById(R.id.recyclerView);

        // banner = inflate.findViewById(R.id.banner);
        virtualLayoutManager = new VirtualLayoutManager(getActivity());
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        recyclerView.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 10);


        //开始
        //banner
        GridLayoutHelper gridLayoutBanner = new GridLayoutHelper(1);
        gridLayoutBanner.setItemCount(1);// 设置布局里Item个数
        bannerDTOS = new ArrayList<>();
        bannerAdapter = new BannerAdapter(getActivity(), bannerDTOS, gridLayoutBanner);

        //横向
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(5);
        gridLayoutHelper.setItemCount(5);// 设置布局里Item个数
        channelDTOS = new ArrayList<>();
        columnLayoutHelperAdapter = new ColumnLayoutHelperAdapter(gridLayoutHelper, getActivity(), channelDTOS);


        /**
         设置Grid布局
         */
        //制造商
        GridLayoutHelper gridLayoutHelpers = new GridLayoutHelper(2);

        gridLayoutHelpers.setItemCount(4);// 设置布局里Item个数
        brandListDTOS = new ArrayList<>();
        gridLayoutHelperAdapter = new GridLayoutHelperAdapter(getActivity(), gridLayoutHelpers, brandListDTOS);

        //下一个

        //饼干
        GridLayoutHelper gridLayout = new GridLayoutHelper(2);
        gridLayout.setItemCount(4);// 设置布局里Item个数
        newGoodsListDTOS = new ArrayList<>();
        gridLayoutAdapter = new GridLayoutAdapter(getActivity(), newGoodsListDTOS, gridLayout);

        /**
         设置线性布局
         */
        //蚕丝被
        LinearLayoutHelper linearLayout = new LinearLayoutHelper();
        hotGoodsListDTOS = new ArrayList<>();
        linearLayoutAdapter = new LinearLayoutAdapter(linearLayout, getActivity(), hotGoodsListDTOS);


        //横向
        LinearLayoutHelper gridLayoutone = new LinearLayoutHelper();
        gridLayoutone.setItemCount(3);// 设置布局里Item个数
        topicListDTOS = new ArrayList<>();
        topicListDTOAdapter = new TopicListDTOAdapter(getActivity(), gridLayoutone, topicListDTOS);


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
        List<HomeBean.DataDTO.BannerDTO> banner = homeBean.getData().getBanner();
        bannerDTOS.addAll(banner);
        bannerAdapter.notifyDataSetChanged();

        List<HomeBean.DataDTO.ChannelDTO> channel = homeBean.getData().getChannel();
        channelDTOS.addAll(channel);
        columnLayoutHelperAdapter.notifyDataSetChanged();

        List<HomeBean.DataDTO.BrandListDTO> brandList = homeBean.getData().getBrandList();
        brandListDTOS.addAll(brandList);
        gridLayoutHelperAdapter.notifyDataSetChanged();

        List<HomeBean.DataDTO.NewGoodsListDTO> newGoodsList = homeBean.getData().getNewGoodsList();
        newGoodsListDTOS.addAll(newGoodsList);
        gridLayoutAdapter.notifyDataSetChanged();

        List<HomeBean.DataDTO.HotGoodsListDTO> hotGoodsList = homeBean.getData().getHotGoodsList();
        hotGoodsListDTOS.addAll(hotGoodsList);
        linearLayoutAdapter.notifyDataSetChanged();


        List<HomeBean.DataDTO.TopicListDTO> topicList = homeBean.getData().getTopicList();
        topicListDTOS.addAll(topicList);
        topicListDTOAdapter.notifyDataSetChanged();

        delegateAdapter = new DelegateAdapter(virtualLayoutManager, true);
        delegateAdapter.addAdapter(initButton());
        delegateAdapter.addAdapter(bannerAdapter);
        delegateAdapter.addAdapter(columnLayoutHelperAdapter);
        delegateAdapter.addAdapter(initTitles("品牌制造商直供"));
        delegateAdapter.addAdapter(gridLayoutHelperAdapter);
        delegateAdapter.addAdapter(initTitles("周一周四.新品首发"));

        delegateAdapter.addAdapter(gridLayoutAdapter);
        delegateAdapter.addAdapter(initTitles("人气推荐"));
        delegateAdapter.addAdapter(linearLayoutAdapter);
        delegateAdapter.addAdapter(initTitles("精选专题"));
        delegateAdapter.addAdapter(topicListDTOAdapter);

        List<HomeBean.DataDTO.CategoryListDTO> categoryList = homeBean.getData().getCategoryList();
        for (int i = 0; i < categoryList.size(); i++) {
            danGeAdapter1 = initTitle(categoryList.get(i).getName());
            gridTopicAdapter = initCateory(categoryList.get(i).getGoodsList());
            delegateAdapter.addAdapter(danGeAdapter1);
            delegateAdapter.addAdapter(gridTopicAdapter);
        }
        danGeAdapter.notifyDataSetChanged();


        //delegateAdapter.addAdapter(linearLayoutHelperAdapter);
        recyclerView.setLayoutManager(virtualLayoutManager);
        recyclerView.setAdapter(delegateAdapter);
    }

    private DelegateAdapter.Adapter initButton() {
        GridLayoutHelper gridLayouts= new GridLayoutHelper(1);
        buttonAdapter = new ButtonAdapter(gridLayouts, getActivity());
        return buttonAdapter;

    }

    //一行字
    private DelegateAdapter.Adapter initTitles(String str) {
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        linearLayoutHelper.setItemCount(1);// 设置布局里Item个数
        linearLayoutHelperAdapter = new LinearLayoutHelperAdapter(linearLayoutHelper, getActivity(), str);
        return linearLayoutHelperAdapter;
    }

    private GridTopicAdapter initCateory(List<HomeBean.DataDTO.CategoryListDTO.GoodsListDTO> goodsList) {
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(2);
        GridTopicAdapter gridTopicAdapter = new GridTopicAdapter(getActivity(), goodsList, gridLayoutHelper);
        return gridTopicAdapter;
    }

    private DanGeAdapter initTitle(String name) {
        LinearLayoutHelper dange = new LinearLayoutHelper();
        danGeAdapter = new DanGeAdapter(name, dange, getActivity());
        return danGeAdapter;
    }
}