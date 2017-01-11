package com.einao.ordersapp.app.ui.viewmodel.mappers;

import com.einao.ordersapp.app.ui.viewmodel.LoadViewModel;
import com.einao.ordersapp.domain.beans.Load;
import com.einao.ordersapp.domain.common.LoadsObjectMother;
import com.einao.ordersapp.domain.providers.MapFormatter;
import com.einao.ordersapp.domain.providers.TextFormatter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LoadViewModelMapperTest {

    @Mock
    private TextFormatter textFormatter;
    @Mock
    private MapFormatter mapFormatter;

    private Load load;
    private LoadViewModel loadViewModel;

    @Before
    public void init() {
        LoadViewModelMapper loadViewModelMapper = new LoadViewModelMapper(textFormatter, mapFormatter);

        LoadsObjectMother loadsObjectMother = new LoadsObjectMother();
        load = loadsObjectMother.getSimpleLoad();

        loadViewModel = loadViewModelMapper.map(this.load);
    }

    @Test
    public void onMap_textMapped() {
        Assert.assertTrue(loadViewModel.getName().compareTo(load.getName()) == 0);
    }

}