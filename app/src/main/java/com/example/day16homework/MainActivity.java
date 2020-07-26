package com.example.day16homework;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.day16homework.adapter.TvfAdapter;
import com.example.day16homework.fragment.AttentionFragment;
import com.example.day16homework.fragment.SchoolFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new SchoolFragment());
        fragments.add(new AttentionFragment());
        ArrayList<String> titles = new ArrayList<>();
        titles.add("校门");
        titles.add("关注");

        TvfAdapter adapter = new TvfAdapter(getSupportFragmentManager(), fragments, titles);
        vp.setAdapter(adapter);
        tab.setupWithViewPager(vp);
    }
}
