package com.example.day16homework.base;

import java.util.ArrayList;

public abstract class BasePresenter<V extends BaseView> {
    public V mView;
    private ArrayList<BaseModle> modles = new ArrayList<>();

    public BasePresenter() {
        initModel();
    }

    protected abstract void initModel();
    public void addModel(BaseModle modle) {
        modles.add(modle);
    }
    public void bindView(V view) {
        this.mView = view;
    }

    public void destroy() {
        mView = null;
        for (int i = 0; i < modles.size(); i++) {
            BaseModle baseModle = modles.get(i);
            baseModle.destroy();
        }

    }
}
