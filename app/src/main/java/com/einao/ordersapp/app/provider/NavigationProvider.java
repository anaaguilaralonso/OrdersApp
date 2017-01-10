package com.einao.ordersapp.app.provider;

import android.app.Activity;

import com.einao.ordersapp.app.ui.provider.LoadDetailNavigator;
import com.einao.ordersapp.app.ui.viewmodel.LoadViewModel;
import com.einao.ordersapp.domain.providers.Navigator;

public class NavigationProvider {

    Activity activity;

    public NavigationProvider(Activity activity) {
        this.activity = activity;
    }

    public Navigator<LoadViewModel> getLoadDetailNavigationProvider() {
        return new LoadDetailNavigator(activity);
    }

}
