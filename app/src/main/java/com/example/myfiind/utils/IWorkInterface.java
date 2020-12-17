package com.example.myfiind.utils;

import java.util.HashMap;

import javax.security.auth.callback.Callback;

public interface IWorkInterface {

        public <T> void  get(String url, ICallBanck<T> callBanck);
        public <T> void  post(String url, ICallBanck<T> callBanck);
        public <T> void  post(String url, HashMap<String,String> map, ICallBanck<T> callBanck);
}
