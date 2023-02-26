package com.springdemo.demo;

public  interface CallBack <T extends String > {
    void run(T n);

    static void RunIfNotNull(CallBack callback,String n){
        if(callback != null){
            callback.run(n);
        }
    }
}
