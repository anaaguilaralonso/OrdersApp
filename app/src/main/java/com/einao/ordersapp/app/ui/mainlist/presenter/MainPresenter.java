package com.einao.ordersapp.app.ui.mainlist.presenter;

import com.einao.ordersapp.app.ui.common.Presenter;
import com.einao.ordersapp.app.ui.mainlist.view.MainView;
import com.einao.ordersapp.app.ui.viewmodel.LoadViewModel;
import com.einao.ordersapp.app.ui.viewmodel.LoadsViewModel;
import com.einao.ordersapp.app.ui.viewmodel.mappers.LoadsViewModerMapper;
import com.einao.ordersapp.domain.UseCaseCallback;
import com.einao.ordersapp.domain.beans.Error;
import com.einao.ordersapp.domain.beans.Loads;
import com.einao.ordersapp.domain.providers.Navigator;
import com.einao.ordersapp.domain.usecases.GetOrdersUseCase;

import java.util.Iterator;

public class MainPresenter extends Presenter<MainView> {

    private final GetOrdersUseCase ordersUserCase;
    private final Navigator<LoadViewModel> navigator;

    public MainPresenter(MainView mainView, Navigator navigator, GetOrdersUseCase ordersUserCase) {
        super(mainView);
        this.ordersUserCase = ordersUserCase;
        this.navigator = navigator;
    }

    @Override
    public void start() {
        getOrders();
    }

    public void getOrders() {
        ordersUserCase.execute(useCaseCallback);
    }

    private final UseCaseCallback<Loads> useCaseCallback = new UseCaseCallback<Loads>() {
        @Override
        public void onError(Error error) {
            if (!existView()) return;
            ordersNotFetched(error);
        }

        @Override
        public void onSuccess(Loads data) {
            if (!existView()) return;
            ordersFetched(data);
        }
    };

    private void ordersFetched(Loads data) {
        view.get().clearList();

        LoadsViewModerMapper mapper = new LoadsViewModerMapper();
        LoadsViewModel loadsViewModel = mapper.map(data);

        addLoadsToView(loadsViewModel);
    }

    private void addLoadsToView(LoadsViewModel loadsViewModel) {
        Iterator<LoadViewModel> iterator = loadsViewModel.iterator();
        while (iterator.hasNext()) {
            if (!existView()) return;
            view.get().addLoad(iterator.next());
        }
    }

    private void ordersNotFetched(Error error) {
        view.get().showMessage(error.getMessage());
    }

    public void onLoadClicked(LoadViewModel loadViewModel) {
        navigator.goTo(loadViewModel);
    }
}
