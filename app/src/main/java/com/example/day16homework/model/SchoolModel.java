package com.example.day16homework.model;

import com.example.day16homework.base.BaseModle;
import com.example.day16homework.bean.DailyNewsBean;
import com.example.day16homework.net.ApiService;
import com.example.day16homework.net.SchoolCallback;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class SchoolModel extends BaseModle {
    public void getData(SchoolCallback schoolCallback) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(ApiService.BASE_URL)
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<DailyNewsBean> observable = apiService.getLatestNews();
        observable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<DailyNewsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DailyNewsBean dailyNewsBean) {
                        schoolCallback.onSuccess(dailyNewsBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
