package com.einao.ordersapp.app.ui.loaddetail.view;

import android.content.Intent;
import android.os.Bundle;

import com.einao.ordersapp.R;
import com.einao.ordersapp.app.common.ExtraConstants;
import com.einao.ordersapp.app.ui.common.BaseActivity;
import com.einao.ordersapp.app.ui.loaddetail.presenter.LoadDetailPresenter;
import com.einao.ordersapp.app.ui.viewmodel.LoadViewModel;

import butterknife.BindView;

public class LoadDetailActivity extends BaseActivity<LoadDetailPresenter> implements LoadDetailView {

    @BindView(R.id.details_view)
    DetailsView detailsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        LoadViewModel load = intent.getParcelableExtra(ExtraConstants.LOAD_EXTRA);
        presenter.setLoad(load);

        presenter.start();
    }

    @Override
    public LoadDetailPresenter initPresenter() {
        return new LoadDetailPresenter(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_load_detail;
    }

    @Override
    public void setViewInformation(LoadViewModel loadViewModel) {
        detailsView.setInformation(loadViewModel);
    }
}
