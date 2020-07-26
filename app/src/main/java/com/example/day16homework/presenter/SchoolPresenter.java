package com.example.day16homework.presenter;

import com.example.day16homework.base.BasePresenter;
import com.example.day16homework.bean.DailyNewsBean;
import com.example.day16homework.model.SchoolModel;
import com.example.day16homework.net.SchoolCallback;
import com.example.day16homework.view.SchoolView;

public class SchoolPresenter extends BasePresenter<SchoolView> implements SchoolCallback {
    private SchoolModel schoolModel;

    @Override
    protected void initModel() {
        schoolModel = new SchoolModel();
        addModel(schoolModel);
    }

    public void getData() {
        schoolModel.getData(this);
    }

    @Override
    public void onSuccess(DailyNewsBean dailyNewsBean) {
        mView.setData(dailyNewsBean);
    }

    @Override
    public void onFail(String error) {
        mView.showToast(error);
    }
}
