package com.example.myfiind.utils;

public class MyNetworkframework {

    private static MyNetworkframework myNetworkframework;

    private MyNetworkframework() {

    }

    public static MyNetworkframework getmyNetworkframework() {
        if (myNetworkframework == null) {
            synchronized (MyNetworkframework.class) {
                if (myNetworkframework == null) {
                    myNetworkframework = new MyNetworkframework();
                }
            }
        }
        return myNetworkframework;
    }
}
