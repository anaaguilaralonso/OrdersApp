package com.einao.ordersapp.app.ui.loaddetail.view;

import com.einao.ordersapp.app.ui.common.BaseView;
import com.einao.ordersapp.app.ui.viewmodel.LoadViewModel;

public interface LoadDetailView extends BaseView {
    void setViewInformation(LoadViewModel loadViewModel);
}
