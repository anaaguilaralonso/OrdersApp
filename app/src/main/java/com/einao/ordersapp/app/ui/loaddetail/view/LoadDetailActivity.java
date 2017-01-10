package com.einao.ordersapp.app.ui.loaddetail.view;

import android.os.Bundle;

import com.einao.ordersapp.R;
import com.einao.ordersapp.app.ui.common.BaseActivity;
import com.einao.ordersapp.app.ui.common.Presenter;
import com.einao.ordersapp.app.ui.loaddetail.presenter.LoadDetailPresenter;

public class LoadDetailActivity extends BaseActivity implements LoadDetailView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public Presenter initPresenter() {
        return new LoadDetailPresenter(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_load_detail;
    }
}
