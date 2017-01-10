package com.einao.ordersapp.app.ui.provider;

import android.app.Activity;
import android.content.Intent;

import com.einao.ordersapp.app.common.ExtraConstants;
import com.einao.ordersapp.app.ui.loaddetail.view.LoadDetailActivity;
import com.einao.ordersapp.app.ui.viewmodel.LoadViewModel;
import com.einao.ordersapp.domain.providers.Navigator;


public class LoadDetailNavigator implements Navigator<LoadViewModel> {

    Activity activity;

    public LoadDetailNavigator(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void goTo(LoadViewModel viewModel) {
        Intent intent = new Intent(activity, LoadDetailActivity.class);
        intent.putExtra(ExtraConstants.LOAD_EXTRA, viewModel);
        activity.startActivity(intent);
    }
}
