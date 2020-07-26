package com.example.day16homework.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements BaseView {
    public P presenter;
    private Unbinder bind;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), null);
        bind = ButterKnife.bind(this, view);
        initPresenter();
        if (presenter != null) {
            presenter.bindView(this);
        }
        initView();
        initData();
        initListener();
        return view;
    }

    protected abstract int getLayout();

    protected abstract void initPresenter();

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void initListener();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.destroy();
            presenter = null;
        }
        bind.unbind();
    }
}
