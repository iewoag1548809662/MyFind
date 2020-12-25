package com.example.myfiind.interfacer;

import com.example.myfiind.base.BaseModel;
import com.example.myfiind.base.BaseView;
import com.example.myfiind.bean.HomeBean;
import com.example.myfiind.utils.ICallBanck;

public interface MainContract {
    interface Imodel extends BaseModel {
        <T> void getHomes(String url, ICallBanck<T> callBanck);
    }
    interface  Iprenter{
       void  getHomes();
    }
    interface Iview extends BaseView{
        void getHomesDatas(HomeBean homeBean);
    }
}
