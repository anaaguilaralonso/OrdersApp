package com.einao.ordersapp.app.ui.mainlist.presenter;

import android.util.Log;

import com.einao.ordersapp.app.ui.common.Presenter;
import com.einao.ordersapp.domain.UseCaseCallback;
import com.einao.ordersapp.domain.beans.Error;
import com.einao.ordersapp.domain.beans.Loads;
import com.einao.ordersapp.domain.usecases.GetOrdersUseCase;

public class MainPresenter extends Presenter {


    private GetOrdersUseCase ordersUserCase;

    public MainPresenter(GetOrdersUseCase ordersUserCase) {
        this.ordersUserCase = ordersUserCase;
    }

    @Override
    public void start() {
        ordersUserCase.addCallback(useCaseCallback);
        getOrders();
    }

    @Override
    public void stop(){
        ordersUserCase.stopCallback();
    }

    public void getOrders() {
        ordersUserCase.execute();
    }

    private final UseCaseCallback<Loads> useCaseCallback = new UseCaseCallback<Loads>() {
        @Override
        public void onError(Error error) {
            Log.i(this.getClass().getName(), error.getMessage());
        }

        @Override
        public void onSuccess(Loads data) {
            Log.i(this.getClass().getName(), "Data " + data.getCount());
        }
    };
}
