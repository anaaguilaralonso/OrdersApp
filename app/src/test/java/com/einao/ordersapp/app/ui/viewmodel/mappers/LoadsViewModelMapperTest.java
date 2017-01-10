package com.einao.ordersapp.app.ui.viewmodel.mappers;

import com.einao.ordersapp.app.ui.provider.TextFormatter;
import com.einao.ordersapp.app.ui.viewmodel.LoadsViewModel;
import com.einao.ordersapp.domain.beans.Loads;
import com.einao.ordersapp.domain.common.LoadsObjectMother;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LoadsViewModelMapperTest {

    @Mock
    TextFormatter textFormatter;

    @Test
    public void onMap_addAllLoads() {
        int numberOfLoads = 4;
        LoadsViewModelMapper loadsViewModelMapper = new LoadsViewModelMapper(textFormatter);
        LoadsObjectMother loadsObjectMother = new LoadsObjectMother();
        Loads loads = loadsObjectMother.getLoads(numberOfLoads);

        LoadsViewModel loadsViewModel = loadsViewModelMapper.map(loads);

        Assert.assertTrue(loadsViewModel.getCount() == numberOfLoads);
    }
}