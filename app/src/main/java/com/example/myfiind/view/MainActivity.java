package com.example.myfiind.view;

import android.widget.TextView;

import com.example.myfiind.R;
import com.example.myfiind.base.BaseActivity;
import com.example.myfiind.bean.NewsBean;
import com.example.myfiind.interfacer.MainContract;
import com.example.myfiind.presenter.MainPrenter;

public class MainActivity extends BaseActivity<MainPrenter> implements MainContract.Iview {

    private TextView tv;

    @Override
    protected void initData() {
        IPresenter.getNews();
    }

    @Override
    protected void initView() {
        tv = findViewById(R.id.tv);
    }

    @Override
    protected int getView() {
        return R.layout.activity_main;
    }

    @Override
    protected MainPrenter getPresenter() {
        return new MainPrenter(this);
    }

    @Override
    public void getNewsDatas(NewsBean newsBean) {

    }
}