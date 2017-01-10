package com.einao.ordersapp.app.ui.viewmodel.mappers;

import com.einao.ordersapp.app.ui.provider.TextFormatter;
import com.einao.ordersapp.app.ui.viewmodel.LoadViewModel;
import com.einao.ordersapp.domain.beans.Load;
import com.einao.ordersapp.domain.common.LoadsObjectMother;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LoadViewModelMapperTest {

    private Load load;
    private LoadViewModel loadViewModel;

    @Before
    public void init() {
        TextFormatter textFormatter = new TextFormatter();
        LoadViewModelMapper loadViewModelMapper = new LoadViewModelMapper(textFormatter);

        LoadsObjectMother loadsObjectMother = new LoadsObjectMother();
        load = loadsObjectMother.getSimpleLoad();

        loadViewModel = loadViewModelMapper.map(this.load);
    }

    @Test
    public void onMap_textMapped() {
        Assert.assertTrue(loadViewModel.getName().compareTo(load.getName()) == 0);
    }

}