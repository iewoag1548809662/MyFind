package com.example.myfiind.model;

import com.example.myfiind.interfacer.MainContract;
import com.example.myfiind.presenter.MainPrenter;
import com.example.myfiind.utils.ICallBanck;
import com.example.myfiind.utils.MyNetworkframework;

public class MainModel implements MainContract.Imodel {

    private MainContract.Iprenter iprenter;

    public MainModel(MainContract.Iprenter mainPrenter) {
        this.iprenter = mainPrenter;
    }

    @Override
    public <T> void getNews(String url, ICallBanck<T> callBanck) {
        MyNetworkframework.getmyNetworkframework().get(url,callBanck);
    }
}
