package com.example.myfiind.base;

public abstract class BasePresenter<D extends BaseView,V extends BaseModel> {

    public D Iview;
    public V IModel;

    public void addACter(D iview) {
        Iview = iview;
        IModel =getIModel();
    }
    public void detachView(){
        Iview = null;
        IModel =null;
    }

    protected abstract V getIModel();

}
