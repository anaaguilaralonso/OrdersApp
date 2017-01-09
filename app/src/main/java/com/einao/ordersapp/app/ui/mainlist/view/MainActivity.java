package com.einao.ordersapp.app.ui.mainlist.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.einao.ordersapp.R;
import com.einao.ordersapp.app.ui.common.BaseActivity;
import com.einao.ordersapp.app.ui.mainlist.adapter.LoadsListAdapter;
import com.einao.ordersapp.app.ui.mainlist.presenter.MainPresenter;
import com.einao.ordersapp.app.ui.viewmodel.LoadViewModel;
import com.einao.ordersapp.data.OrdersDataRepository;
import com.einao.ordersapp.data.network.firebase.OrdersNetworkDataSourceFirebase;
import com.einao.ordersapp.data.storage.OrdersStorageDataSourceFirebase;
import com.einao.ordersapp.domain.usecases.GetOrdersUseCase;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainPresenter> implements MainView {

    @BindView(R.id.loads_list)
    RecyclerView loadsRecycler;

    LoadsListAdapter loadsListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        loadsRecycler.setLayoutManager(layoutManager);

        loadsListAdapter = new LoadsListAdapter();
        loadsRecycler.setAdapter(loadsListAdapter);

        presenter.start();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public MainPresenter initPresenter() {
        return new MainPresenter(this, new GetOrdersUseCase(new OrdersDataRepository(new
                OrdersNetworkDataSourceFirebase(),
                new OrdersStorageDataSourceFirebase())));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.stop();
    }

    @Override
    public void addLoad(LoadViewModel load) {
        loadsListAdapter.add(load);
    }

    @Override
    public void clearList() {
        loadsListAdapter.clear();
    }
}
