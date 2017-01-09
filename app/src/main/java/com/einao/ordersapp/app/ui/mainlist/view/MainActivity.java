package com.einao.ordersapp.app.ui.mainlist.view;

import android.os.Bundle;

import com.einao.ordersapp.R;
import com.einao.ordersapp.app.ui.common.BaseActivity;
import com.einao.ordersapp.app.ui.mainlist.presenter.MainPresenter;
import com.einao.ordersapp.data.OrdersDataRepository;
import com.einao.ordersapp.data.network.firebase.OrdersNetworkDataSourceFirebase;
import com.einao.ordersapp.data.storage.OrdersStorageDataSourceFirebase;
import com.einao.ordersapp.domain.usecases.OrdersUseCase;

public class MainActivity extends BaseActivity<MainPresenter> implements MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter.start();
    }

    @Override
    public MainPresenter initPresenter() {
        return new MainPresenter(new OrdersUseCase(new OrdersDataRepository(new OrdersNetworkDataSourceFirebase(),
                new OrdersStorageDataSourceFirebase())));
    }
}
