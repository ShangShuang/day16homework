package com.example.day16homework.net;

import com.example.day16homework.bean.HotBean;

public interface HotCallback {
    void onSuccess(HotBean hotBean);

    void onFail(String error);
}
