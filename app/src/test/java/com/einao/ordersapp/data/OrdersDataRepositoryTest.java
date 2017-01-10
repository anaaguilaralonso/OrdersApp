package com.einao.ordersapp.data;

import com.einao.ordersapp.data.common.LoadEntityObjectMother;
import com.einao.ordersapp.data.entities.LoadsEntity;
import com.einao.ordersapp.data.network.OrdersNetworkDataSource;
import com.einao.ordersapp.data.network.common.RepositoryCallback;
import com.einao.ordersapp.data.storage.OrdersStorageDataSource;
import com.einao.ordersapp.domain.beans.Error;
import com.einao.ordersapp.domain.beans.Loads;
import com.einao.ordersapp.domain.common.DomainCallback;
import com.einao.ordersapp.domain.common.ErrorObjectMother;
import com.einao.ordersapp.domain.policy.DataBasePolicy;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

@RunWith(MockitoJUnitRunner.class)
public class OrdersDataRepositoryTest {

    @Mock
    OrdersStorageDataSource storageDataSource;

    @Mock
    OrdersNetworkDataSource networkDataSource;

    @Mock
    DataBasePolicy dataBasePolicy;

    @Mock
    DomainCallback domainCallback;

    OrdersDataRepository ordersDataRepository;

    @Before
    public void init() {
        ordersDataRepository = new OrdersDataRepository(networkDataSource, storageDataSource, dataBasePolicy);
    }

    @Test
    public void onGetOrders_validPolicy_getFromStorage() {
        Mockito.doReturn(true).when(dataBasePolicy).isValid(Mockito.anyLong());

        ordersDataRepository.getOrders(domainCallback);

        Mockito.verify(storageDataSource).getOrders(Mockito.any(RepositoryCallback.class));
    }

    @Test
    public void onGetOrders_invalidPolicy_getFromStorage() {
        Mockito.doReturn(false).when(dataBasePolicy).isValid(Mockito.anyLong());

        ordersDataRepository.getOrders(domainCallback);

        Mockito.verify(networkDataSource).getOrders(Mockito.any(RepositoryCallback.class));
    }

    @Test
    public void onGetOrders_successResponse_successCallback() {
        LoadEntityObjectMother loadEntityObjectMother = new LoadEntityObjectMother();
        final LoadsEntity loads = loadEntityObjectMother.getLoads(3);
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                ordersDataRepository.repositoryCallback.onSuccess(loads);
                return null;
            }
        }).when(networkDataSource).getOrders(ordersDataRepository.repositoryCallback);

        ordersDataRepository.getOrders(domainCallback);

        Mockito.verify(domainCallback).onSuccess(Mockito.any(Loads.class));
    }

    @Test
    public void onGetOrders_failureResponse_failureCallback() {
        ErrorObjectMother errorObjectMother = new ErrorObjectMother();
        final Error error = errorObjectMother.getSimpleError();
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                ordersDataRepository.repositoryCallback.onFailure(error);
                return null;
            }
        }).when(networkDataSource).getOrders(ordersDataRepository.repositoryCallback);

        ordersDataRepository.getOrders(domainCallback);

        Mockito.verify(domainCallback).onFailure(error);
    }
}