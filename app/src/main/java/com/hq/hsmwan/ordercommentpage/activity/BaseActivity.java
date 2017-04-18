package com.hq.hsmwan.ordercommentpage.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.hq.hsmwan.ordercommentpage.R;

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    protected Bundle savedInstanceState;
    public Context context;

    protected boolean isNoTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.savedInstanceState = savedInstanceState;
        context = this;

        setContentView();
        initData();
        initTitle();
        initView();
        initListener();
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    protected void setTitle(String text) {
        if (!isNoTitle) {
            TextView tv_title = (TextView) findViewById(R.id.tv_title);
            tv_title.setText(text);
        }
    }

    private void initTitle() {

    }

    public abstract void setContentView();

    public abstract void initView();

    public abstract void initListener();

    public abstract void initData();
}

