package com.einao.ordersapp.app.ui.loaddetail.presenter;

import com.einao.ordersapp.app.ui.loaddetail.view.LoadDetailView;
import com.einao.ordersapp.app.ui.viewmodel.LoadViewModel;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LoadDetailPresenterTest {

    @Mock
    LoadDetailView loadDetailView;

    @Mock
    LoadViewModel loadViewModel;

    LoadDetailPresenter loadDetailPresenter;

    @Before
    public void init() {
        loadDetailPresenter = new LoadDetailPresenter(loadDetailView, loadViewModel);
    }

    @Test
    public void onStart_setLoadViewModel_showDetails() {

        loadDetailPresenter.start();

        Mockito.verify(loadDetailView).setViewInformation(loadViewModel);
    }

}