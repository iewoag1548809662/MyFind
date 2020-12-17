package com.example.myfiind.base;

public class BasePresenter<D extends BaseView> {

    public D Iviews;
    public void addView(D d){
        Iviews =d;
    }
}
