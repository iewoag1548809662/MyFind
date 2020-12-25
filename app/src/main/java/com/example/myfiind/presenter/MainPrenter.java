package com.example.myfiind.presenter;


import com.example.myfiind.base.BasePresenter;
import com.example.myfiind.bean.HomeBean;
import com.example.myfiind.interfacer.MainContract;
import com.example.myfiind.model.MainModel;
import com.example.myfiind.utils.ICallBanck;
import com.example.myfiind.utils.URLConstants;

public class MainPrenter extends BasePresenter<MainContract.Iview,MainContract.Imodel> implements MainContract.Iprenter {





    @Override
    public void getHomes() {
        IModel.getHomes(URLConstants.URL_ADD, new ICallBanck<HomeBean>() {
            @Override
            public void getSuccess(HomeBean homeBean) {
                Iview.getHomesDatas(homeBean);
            }

            @Override
            public void getFail(String msg) {

            }
        });
    }

    @Override
    protected MainContract.Imodel getIModel() {
        return new MainModel();
    }
}