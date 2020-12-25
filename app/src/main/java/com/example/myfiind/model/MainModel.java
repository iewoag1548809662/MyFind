package com.example.myfiind.model;

import com.example.myfiind.interfacer.MainContract;
import com.example.myfiind.presenter.MainPrenter;
import com.example.myfiind.utils.ICallBanck;
import com.example.myfiind.utils.MyNetworkframework;
import com.example.myfiind.utils.URLConstants;

public class MainModel implements MainContract.Imodel {



    @Override
    public <T> void getHomes(String url, ICallBanck<T> callBanck) {
        MyNetworkframework.getmyNetworkframework().get(URLConstants.URL_ADD,callBanck);
    }
}
