package com.einao.ordersapp.app.ui.mainlist.view;

import com.einao.ordersapp.app.ui.common.BaseView;
import com.einao.ordersapp.app.ui.viewmodel.LoadViewModel;

public interface MainView extends BaseView {

    void addLoad(LoadViewModel load);

    void clearList();
}
