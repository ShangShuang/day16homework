package com.example.day16homework.fragment;


import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day16homework.R;
import com.example.day16homework.adapter.SchoolAdapter;
import com.example.day16homework.base.BaseFragment;
import com.example.day16homework.bean.DailyNewsBean;
import com.example.day16homework.presenter.SchoolPresenter;
import com.example.day16homework.view.SchoolView;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class SchoolFragment extends BaseFragment<SchoolPresenter> implements SchoolView {

    @BindView(R.id.rv)
    RecyclerView rv;

    private SchoolAdapter adapter;
    private ArrayList<DailyNewsBean.TopStoriesBean> datas;

    @Override
    protected int getLayout() {
        return R.layout.fragment_school;
    }

    @Override
    protected void initPresenter() {
        presenter = new SchoolPresenter();
    }

    @Override
    protected void initView() {
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        datas = new ArrayList<>();
        adapter = new SchoolAdapter(getActivity(), datas);
        rv.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        presenter.getData();
    }

    @Override
    protected void initListener() {

    }

    @Override
    public void setData(DailyNewsBean dailyNewsBean) {
        datas.addAll(dailyNewsBean.getTop_stories());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showToast(String str) {
        Toast.makeText(getActivity(), str, Toast.LENGTH_SHORT).show();
    }
}
