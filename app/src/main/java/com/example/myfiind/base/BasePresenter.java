package com.example.myfiind.base;

public class BasePresenter<D extends BaseView> {

    private D Iview;
    public void addView(D d){
        Iview =d;
    }
}
