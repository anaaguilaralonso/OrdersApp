package com.einao.ordersapp.app.ui.mainlist.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.einao.ordersapp.R;
import com.einao.ordersapp.app.ui.common.BaseActivity;
import com.einao.ordersapp.app.ui.mainlist.adapter.LoadsListAdapter;
import com.einao.ordersapp.app.ui.mainlist.presenter.MainPresenter;
import com.einao.ordersapp.app.ui.viewmodel.LoadViewModel;
import com.einao.ordersapp.domain.providers.Navigator;
import com.einao.ordersapp.domain.usecases.GetOrdersUseCase;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainPresenter> implements MainView {

    @BindView(R.id.loads_list)
    RecyclerView loadsRecycler;

    private LoadsListAdapter loadsListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        loadsRecycler.setLayoutManager(layoutManager);

        loadsListAdapter = new LoadsListAdapter(onLoadClickListener);
        loadsRecycler.setAdapter(loadsListAdapter);

        presenter.start();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public MainPresenter initPresenter() {
        Navigator<LoadViewModel> loadDetailNavigationProvider = navigationProvider.getLoadDetailNavigationProvider();
        GetOrdersUseCase ordersUseCase = useCaseProvider.getOrdersUseCase();
        return new MainPresenter(this, loadDetailNavigationProvider,
                ordersUseCase, textFormatter);
    }

    @Override
    public void addLoad(LoadViewModel load) {
        loadsListAdapter.add(load);
    }

    @Override
    public void clearList() {
        loadsListAdapter.clear();
    }

    private LoadsListAdapter.OnLoadClickListener onLoadClickListener = new LoadsListAdapter.OnLoadClickListener() {
        @Override
        public void onClick(LoadViewModel loadViewModel) {
            presenter.onLoadClicked(loadViewModel);
        }
    };
}
