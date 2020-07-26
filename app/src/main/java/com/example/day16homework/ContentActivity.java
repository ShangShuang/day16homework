package com.example.day16homework;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContentActivity extends AppCompatActivity {

    @BindView(R.id.web)
    WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        String url = getIntent().getStringExtra("url");
        web.loadUrl(url);
        web.setWebViewClient(new WebViewClient());
    }
}
