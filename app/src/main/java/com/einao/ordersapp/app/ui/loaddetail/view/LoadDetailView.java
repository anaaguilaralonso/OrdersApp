package com.einao.ordersapp.app.ui.loaddetail.view;

import com.einao.ordersapp.app.ui.common.BaseView;

public interface LoadDetailView extends BaseView{
    void setName(String name);

    void setPrice(String price);

    void setDestination(String destination);

    void setOriginDate(String originDate);

    void setDestinationDate(String destinationDate);

    void setPackageType(String packageType);

    void setStatus(int status);

    void setWeight(int weight);
}
