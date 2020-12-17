package com.example.myfiind.utils;

public interface ICallBanck<T> {

    void getSuccess(T t);
    void getFail(String msg);
}
