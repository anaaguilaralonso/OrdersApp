package com.einao.ordersapp.domain.usecases;

import com.einao.ordersapp.domain.OrdersRepository;
import com.einao.ordersapp.domain.UseCaseCallback;
import com.einao.ordersapp.domain.beans.Error;
import com.einao.ordersapp.domain.beans.Loads;
import com.einao.ordersapp.domain.common.ErrorObjectMother;
import com.einao.ordersapp.domain.common.LoadsObjectMother;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

@RunWith(MockitoJUnitRunner.class)
public class GetOrdersUseCaseTest {

    @Mock
    OrdersRepository ordersRepository;

    @Mock
    UseCaseCallback useCaseCallback;

    GetOrdersUseCase getOrdersUseCase;


    @Before
    public void init() {
        getOrdersUseCase = new GetOrdersUseCase(ordersRepository);
    }

    @Test
    public void onGetOrders_successResponse_successCallback() {
        LoadsObjectMother loadsObjectMother = new LoadsObjectMother();
        final Loads loads = loadsObjectMother.getLoads(3);
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                getOrdersUseCase.domainCallback.onSuccess(loads);
                return null;
            }
        }).when(ordersRepository).getOrders(getOrdersUseCase.domainCallback);

        getOrdersUseCase.execute(useCaseCallback);

        Mockito.verify(useCaseCallback).onSuccess(Mockito.any(Loads.class));
    }

    @Test
    public void onGetOrders_failureResponse_failureCallback() {
        ErrorObjectMother errorObjectMother = new ErrorObjectMother();
        final Error error = errorObjectMother.getSimpleError();
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                getOrdersUseCase.domainCallback.onFailure(error);
                return null;
            }
        }).when(ordersRepository).getOrders(getOrdersUseCase.domainCallback);

        getOrdersUseCase.execute(useCaseCallback);

        Mockito.verify(useCaseCallback).onFailure(error);
    }

}