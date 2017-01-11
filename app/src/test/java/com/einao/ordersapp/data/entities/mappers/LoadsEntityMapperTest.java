package com.einao.ordersapp.data.entities.mappers;

import com.einao.ordersapp.data.common.LoadEntityObjectMother;
import com.einao.ordersapp.data.entities.LoadsEntity;
import com.einao.ordersapp.domain.beans.Loads;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LoadsEntityMapperTest {

    @Test
    public void onMap_addAllLoads() {
        int numberOfLoads = 4;
        LoadsEntityMapper loadsEntityMapper = new LoadsEntityMapper();
        LoadEntityObjectMother loadEntityObjectMother = new LoadEntityObjectMother();
        LoadsEntity loadsEntity = loadEntityObjectMother.getLoads(numberOfLoads);

        Loads loads = loadsEntityMapper.map(loadsEntity);

        Assert.assertTrue(loads.getCount() == numberOfLoads);
    }

}