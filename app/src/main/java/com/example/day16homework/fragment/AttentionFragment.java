package com.example.day16homework.fragment;


import android.content.Intent;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day16homework.ContentActivity;
import com.example.day16homework.R;
import com.example.day16homework.adapter.HotAdapter;
import com.example.day16homework.base.BaseFragment;
import com.example.day16homework.bean.HotBean;
import com.example.day16homework.presenter.HotPresenter;
import com.example.day16homework.view.HotView;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class AttentionFragment extends BaseFragment<HotPresenter> implements HotView {

    @BindView(R.id.rv_hot)
    RecyclerView rvHot;
    private ArrayList<HotBean.RecentBean> datas;
    private HotAdapter adapter;

    @Override
    protected int getLayout() {
        return R.layout.fragment_attention;
    }

    @Override
    protected void initPresenter() {
        presenter = new HotPresenter();
    }

    @Override
    protected void initView() {
        rvHot.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvHot.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));

        datas = new ArrayList<>();
        adapter = new HotAdapter(getActivity(), datas);
        rvHot.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        presenter.getData();
    }

    @Override
    protected void initListener() {
        adapter.setOnItemClickListener(new HotAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(getActivity(), ContentActivity.class);
                intent.putExtra("url", datas.get(position).getUrl());
                startActivity(intent);
            }
        });
    }

    @Override
    public void setData(HotBean hotBean) {
        datas.addAll(hotBean.getRecent());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showToast(String str) {
        Toast.makeText(getActivity(), str, Toast.LENGTH_SHORT).show();
    }
}
