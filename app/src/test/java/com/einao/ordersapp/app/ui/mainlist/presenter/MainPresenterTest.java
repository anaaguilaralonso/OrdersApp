package com.einao.ordersapp.app.ui.mainlist.presenter;

import com.einao.ordersapp.app.ui.mainlist.view.MainView;
import com.einao.ordersapp.app.ui.viewmodel.LoadViewModel;
import com.einao.ordersapp.domain.beans.Loads;
import com.einao.ordersapp.domain.common.ErrorObjectMother;
import com.einao.ordersapp.domain.common.LoadsObjectMother;
import com.einao.ordersapp.domain.providers.Navigator;
import com.einao.ordersapp.domain.providers.TextFormatter;
import com.einao.ordersapp.domain.usecases.GetOrdersUseCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

@RunWith(MockitoJUnitRunner.class)
public class MainPresenterTest {

    @Mock
    private MainView mainView;

    @Mock
    private Navigator navigator;

    @Mock
    private GetOrdersUseCase getOrdersUseCase;

    @Mock
    private TextFormatter textFormatter;

    private MainPresenter mainPresenter;
    private LoadsObjectMother loadsObjectMother;
    private ErrorObjectMother errorObjectMother;

    @Before
    public void init() {
        mainPresenter = new MainPresenter(mainView, navigator, getOrdersUseCase, textFormatter);

        loadsObjectMother = new LoadsObjectMother();
        errorObjectMother = new ErrorObjectMother();
    }

    @Test
    public void onStartPresenter_getOrdersSuccess_putAllOrders() {
        int loadCount = 4;
        final Loads loads = loadsObjectMother.getLoads(loadCount);
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                mainPresenter.useCaseCallback.onSuccess(loads);
                return null;
            }
        }).when(getOrdersUseCase).execute(mainPresenter.useCaseCallback);

        mainPresenter.start();

        Mockito.verify(mainView, Mockito.times(loadCount)).addLoad(Mockito.any(LoadViewModel.class));
    }

    @Test
    public void onStartPresenter_getOrdersFailure_showMessage() {
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                mainPresenter.useCaseCallback.onFailure(errorObjectMother.getSimpleError());
                return null;
            }
        }).when(getOrdersUseCase).execute(mainPresenter.useCaseCallback);

        mainPresenter.start();

        Mockito.verify(mainView).showMessage(Mockito.anyString());
    }

    @Test
    public void onClickItem_navigateDetail() {
        LoadViewModel loadViewModel = new LoadViewModel();

        mainPresenter.onLoadClicked(loadViewModel);

        Mockito.verify(navigator).goTo(loadViewModel);
    }

}