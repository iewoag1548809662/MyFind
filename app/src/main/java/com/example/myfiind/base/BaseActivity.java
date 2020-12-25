package com.example.myfiind.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements BaseView {

    public T IPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getView());
        if (IPresenter==null){
            IPresenter = getPresenter();
            IPresenter.addACter(this);
        }
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int getView();
    protected abstract T getPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (IPresenter!=null){
            IPresenter.detachView();
        }
    }

}
