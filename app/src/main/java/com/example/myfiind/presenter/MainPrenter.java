package com.example.myfiind.presenter;

import com.example.myfiind.base.BasePresenter;
import com.example.myfiind.bean.NewsBean;
import com.example.myfiind.interfacer.MainContract;
import com.example.myfiind.model.MainModel;
import com.example.myfiind.utils.ICallBanck;
import com.example.myfiind.utils.URLConstants;
import com.example.myfiind.view.MainActivity;

public class MainPrenter extends BasePresenter<MainContract.Iview> implements MainContract.Iprenter {

    public MainContract.Imodel imodel;


    public MainPrenter() {
        this.imodel = new MainModel(this);
    }

    @Override
    public void getNews() {
        imodel.getNews(URLConstants.URL_ADD, new ICallBanck<NewsBean>() {
            @Override
            public void getSuccess(NewsBean newsBean) {
                Iviews.getNewsDatas(newsBean);
            }

            @Override
            public void getFail(String msg) {

            }
        });
    }
}