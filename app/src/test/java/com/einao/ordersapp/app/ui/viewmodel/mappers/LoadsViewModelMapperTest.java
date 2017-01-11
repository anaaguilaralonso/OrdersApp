package com.einao.ordersapp.app.ui.viewmodel.mappers;

import com.einao.ordersapp.app.ui.viewmodel.LoadsViewModel;
import com.einao.ordersapp.domain.beans.Loads;
import com.einao.ordersapp.domain.common.LoadsObjectMother;
import com.einao.ordersapp.domain.providers.MapFormatter;
import com.einao.ordersapp.domain.providers.TextFormatter;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LoadsViewModelMapperTest {

    @Mock
    private TextFormatter textFormatter;

    @Mock
    private MapFormatter mapFormatter;

    @Test
    public void onMap_addAllLoads() {
        int numberOfLoads = 4;
        LoadsViewModelMapper loadsViewModelMapper = new LoadsViewModelMapper(textFormatter, mapFormatter);
        LoadsObjectMother loadsObjectMother = new LoadsObjectMother();
        Loads loads = loadsObjectMother.getLoads(numberOfLoads);

        LoadsViewModel loadsViewModel = loadsViewModelMapper.map(loads);

        Assert.assertTrue(loadsViewModel.getCount() == numberOfLoads);
    }
}