package com.einao.ordersapp.app.ui.loaddetail.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.einao.ordersapp.R;
import com.einao.ordersapp.app.common.ExtraConstants;
import com.einao.ordersapp.app.ui.common.BaseActivity;
import com.einao.ordersapp.app.ui.loaddetail.presenter.LoadDetailPresenter;
import com.einao.ordersapp.app.ui.viewmodel.LoadViewModel;

import butterknife.BindView;

public class LoadDetailActivity extends BaseActivity<LoadDetailPresenter> implements LoadDetailView {

    @BindView(R.id.name)
    TextView name;

    @BindView(R.id.destination)
    TextView destination;

    @BindView(R.id.price)
    TextView price;

    @BindView(R.id.destinationDate)
    TextView destinationDate;

    @BindView(R.id.originDate)
    TextView originDate;

    @BindView(R.id.status)
    TextView status;

    @BindView(R.id.weight)
    TextView weight;

    @BindView(R.id.package_type)
    TextView packageType;

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
    public void setPrice(String price) {
        this.price.setText(price);
    }

    @Override
    public void setDestination(String destination) {
        this.destination.setText(destination);
    }

    @Override
    public void setOriginDate(String originDate) {
        this.originDate.setText(originDate);
    }

    @Override
    public void setDestinationDate(String destinationDate) {
        this.destinationDate.setText(destinationDate);
    }

    @Override
    public void setName(String name) {
        this.name.setText(name);
    }

    @Override
    public void setPackageType(String packageType) {
        this.packageType.setText(packageType);
    }

    @Override
    public void setStatus(int status) {
        this.status.setText(String.valueOf(status));
    }

    @Override
    public void setWeight(int weight) {
        this.weight.setText(String.valueOf(weight));
    }

}
