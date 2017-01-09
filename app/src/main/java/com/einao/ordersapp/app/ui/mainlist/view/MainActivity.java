package com.einao.ordersapp.app.ui.mainlist.view;

import android.os.Bundle;

import com.einao.ordersapp.R;
import com.einao.ordersapp.app.ui.common.BaseActivity;
import com.einao.ordersapp.app.ui.mainlist.presenter.MainPresenter;

public class MainActivity extends BaseActivity<MainPresenter> implements MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public MainPresenter initPresenter() {
        return new MainPresenter();
    }
}
