package com.example.day16homework.presenter;

import com.example.day16homework.base.BasePresenter;
import com.example.day16homework.bean.HotBean;
import com.example.day16homework.model.HotModel;
import com.example.day16homework.net.HotCallback;
import com.example.day16homework.view.HotView;

public class HotPresenter extends BasePresenter<HotView> implements HotCallback {
    private HotModel hotModel;

    @Override
    protected void initModel() {
        hotModel = new HotModel();
        addModel(hotModel);
    }

    public void getData() {
        hotModel.getData(this);
    }

    @Override
    public void onSuccess(HotBean hotBean) {
        mView.setData(hotBean);
    }

    @Override
    public void onFail(String error) {
        mView.showToast(error);
    }
}
