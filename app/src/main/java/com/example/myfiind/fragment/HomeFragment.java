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
import com.example.myfiind.adapter.ColumnLayoutHelperAdapter;
import com.example.myfiind.adapter.DanGeAdapter;
import com.example.myfiind.adapter.GridLayoutAdapter;
import com.example.myfiind.adapter.GridLayoutAdapterOne;
import com.example.myfiind.adapter.GridLayoutHelperAdapter;
import com.example.myfiind.adapter.GridTopicAdapter;
import com.example.myfiind.adapter.LinearLayoutAdapter;
import com.example.myfiind.adapter.LinearLayoutHelperAdapter;
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
    private LinearLayoutHelperAdapter linearLayoutHelperAdapter;
    private ArrayList<HomeBean.DataDTO.BrandListDTO> brandListDTOS;
    private GridLayoutHelperAdapter gridLayoutHelperAdapter;
    private ArrayList<HomeBean.DataDTO.NewGoodsListDTO> newGoodsListDTOS;
    private GridLayoutAdapter gridLayoutAdapter;
    private ArrayList<HomeBean.DataDTO.HotGoodsListDTO> hotGoodsListDTOS;
    private LinearLayoutAdapter linearLayoutAdapter;
    private ArrayList<HomeBean.DataDTO.TopicListDTO> topicListDTOS;
    private GridLayoutAdapterOne gridLayoutAdapterOne;
    private List<HomeBean.DataDTO.CategoryListDTO> categoryListDTOS;
    private DanGeAdapter danGeAdapter;
    private DanGeAdapter danGeAdapter1;
    private GridTopicAdapter gridTopicAdapter;
    private DelegateAdapter delegateAdapter;


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
         设置Grid布局
         */
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(5);
        // 在构造函数设置每行的网格个数

        // 公共属性
        gridLayoutHelper.setItemCount(5);// 设置布局里Item个数


        channelDTOS = new ArrayList<>();
        columnLayoutHelperAdapter = new ColumnLayoutHelperAdapter(gridLayoutHelper, getActivity(), channelDTOS);

        //下一个布局
        /**
         设置线性布局
         */
       /* LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        // 创建对应的LayoutHelper对象

        // 所有布局的公共属性（属性会在下面详细说明）
        linearLayoutHelper.setItemCount(1);// 设置布局里Item个数

        // linearLayoutHelper特有属性
       // linearLayoutHelper.setDividerHeight(1); // 设置每行Item的距离

        linearLayoutHelperAdapter = new LinearLayoutHelperAdapter(linearLayoutHelper, getActivity());*/

        /**
         设置Grid布局
         */
        GridLayoutHelper gridLayoutHelpers = new GridLayoutHelper(2);
        // 在构造函数设置每行的网格个数

        // 公共属性
        gridLayoutHelpers.setItemCount(4);// 设置布局里Item个数
        brandListDTOS = new ArrayList<>();
        gridLayoutHelperAdapter = new GridLayoutHelperAdapter(getActivity(), gridLayoutHelpers, brandListDTOS);

        //下一个


        GridLayoutHelper gridLayout = new GridLayoutHelper(2);
        // 在构造函数设置每行的网格个数

        // 公共属性
        gridLayout.setItemCount(4);// 设置布局里Item个数
        newGoodsListDTOS = new ArrayList<>();
        gridLayoutAdapter = new GridLayoutAdapter(getActivity(), newGoodsListDTOS, gridLayout);

        /**
         设置线性布局
         */
        LinearLayoutHelper linearLayout = new LinearLayoutHelper();
        // 创建对应的LayoutHelper对象

        // 所有布局的公共属性（属性会在下面详细说明）
       /* linearLayout.setItemCount(4);// 设置布局里Item个数
        linearLayout.setPadding(10,10,10,10);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        linearLayout.setMargin(10,10,10,10);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        linearLayout.setBgColor(Color.GRAY);// 设置背景颜色
        linearLayout.setAspectRatio(6);// 设置设置布局内每行布局的宽与高的比*/

        // linearLayoutHelper特有属性

        hotGoodsListDTOS = new ArrayList<>();

        linearLayoutAdapter = new LinearLayoutAdapter(linearLayout, getActivity(), hotGoodsListDTOS);
        //

        LinearLayoutHelper gridLayoutone = new LinearLayoutHelper();
        // 在构造函数设置每行的网格个数
        // 公共属性
        gridLayoutone.setItemCount(4);// 设置布局里Item个数
        topicListDTOS = new ArrayList<>();
        gridLayoutAdapterOne = new GridLayoutAdapterOne(getActivity(), topicListDTOS, gridLayoutone);


        delegateAdapter = new DelegateAdapter(virtualLayoutManager, true);
        delegateAdapter.addAdapter(columnLayoutHelperAdapter);
        delegateAdapter.addAdapter(gridLayoutHelperAdapter);
        delegateAdapter.addAdapter(gridLayoutAdapter);
        delegateAdapter.addAdapter(linearLayoutAdapter);
        delegateAdapter.addAdapter(gridLayoutAdapterOne);


        //delegateAdapter.addAdapter(linearLayoutHelperAdapter);
        recyclerView.setLayoutManager(virtualLayoutManager);
        recyclerView.setAdapter(delegateAdapter);

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
        gridLayoutAdapterOne.notifyDataSetChanged();

        List<HomeBean.DataDTO.CategoryListDTO> categoryList = homeBean.getData().getCategoryList();
        for (int i = 0; i < categoryList.size(); i++) {
            danGeAdapter1 = initTitle(categoryList.get(i).getName());
            gridTopicAdapter = initCateory(categoryList.get(i).getGoodsList());
            delegateAdapter.addAdapter(danGeAdapter1);
            delegateAdapter.addAdapter(gridTopicAdapter);

        }
        danGeAdapter.notifyDataSetChanged();
    }

    private GridTopicAdapter initCateory(List<HomeBean.DataDTO.CategoryListDTO.GoodsListDTO> goodsList) {
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(2);
        GridTopicAdapter gridTopicAdapter = new GridTopicAdapter(getActivity(), goodsList, gridLayoutHelper);
        return gridTopicAdapter;
    }

    private DanGeAdapter initTitle(String name) {
        LinearLayoutHelper dange = new LinearLayoutHelper();
        // 在构造函数设置每行的网格个数
        // 公共属性
        //dange.setItemCount(4);//
        danGeAdapter = new DanGeAdapter(name, dange, getActivity());
        return danGeAdapter;
    }
}