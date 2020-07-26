package com.example.day16homework.net;

import com.example.day16homework.bean.DailyNewsBean;
import com.example.day16homework.bean.HotBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    String BASE_URL = "http://news-at.zhihu.com/api/4/";

    //得到最新的日报新闻
    @GET("news/latest")
    Observable<DailyNewsBean> getLatestNews();

    @GET("news/hot")
    Observable<HotBean> getHot();

}
