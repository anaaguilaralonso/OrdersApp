package com.einao.ordersapp.app.ui.mainlist.presenter;

import android.util.Log;

import com.einao.ordersapp.app.ui.common.Presenter;
import com.einao.ordersapp.app.ui.mainlist.view.MainView;
import com.einao.ordersapp.app.ui.viewmodel.LoadViewModel;
import com.einao.ordersapp.app.ui.viewmodel.LoadsViewModel;
import com.einao.ordersapp.app.ui.viewmodel.mappers.LoadsViewModerMapper;
import com.einao.ordersapp.domain.UseCaseCallback;
import com.einao.ordersapp.domain.beans.Error;
import com.einao.ordersapp.domain.beans.Loads;
import com.einao.ordersapp.domain.usecases.GetOrdersUseCase;

import java.util.Iterator;

public class MainPresenter extends Presenter<MainView> {

    private GetOrdersUseCase ordersUserCase;

    public MainPresenter(MainView mainView, GetOrdersUseCase ordersUserCase) {
        super(mainView);
        this.ordersUserCase = ordersUserCase;
    }

    @Override
    public void start() {
        ordersUserCase.addCallback(useCaseCallback);
        getOrders();
    }

    @Override
    public void stop() {
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
            if (!existView()) return;
            view.get().clearList();

            LoadsViewModerMapper mapper = new LoadsViewModerMapper();
            LoadsViewModel loadsViewModel = mapper.map(data);

            Iterator<LoadViewModel> iterator = loadsViewModel.iterator();
            while (iterator.hasNext()) {
                if (!existView()) return;
                view.get().addLoad(iterator.next());
            }
        }
    };
}
