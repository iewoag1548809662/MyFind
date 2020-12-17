package com.example.myfiind.interfacer;

import com.example.myfiind.base.BaseView;
import com.example.myfiind.bean.NewsBean;
import com.example.myfiind.utils.ICallBanck;

public interface MainContract {
    interface Imodel{
        <T> void getNews(String url, ICallBanck<T> callBanck);
    }
    interface  Iprenter{
       void  getNews();
    }
    interface Iview extends BaseView{
        void getNewsDatas(NewsBean newsBean);
    }
}
