package com.einao.ordersapp.data.entities.mappers;

import com.einao.ordersapp.data.common.LoadEntityObjectMother;
import com.einao.ordersapp.data.entities.LoadEntity;
import com.einao.ordersapp.domain.beans.Load;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LoadEntityMapperTest {

    @Test
    public void onLoadMap_checkName() {
        LoadEntityMapper loadEntityMapper = new LoadEntityMapper();
        LoadEntityObjectMother loadEntityObjectMother = new LoadEntityObjectMother();
        LoadEntity loadEntity = loadEntityObjectMother.getSimpleLoad();

        Load load = loadEntityMapper.map(loadEntity);

        Assert.assertTrue(load.getName().compareTo(loadEntity.getName()) == 0);
    }

}