package com.example.day16homework.net;

import com.example.day16homework.bean.DailyNewsBean;

public interface SchoolCallback {
    void onSuccess(DailyNewsBean dailyNewsBean);

    void onFail(String error);
}
