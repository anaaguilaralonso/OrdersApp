package com.einao.ordersapp.data.network.firebase;

import android.support.annotation.NonNull;
import android.util.Log;

import com.einao.ordersapp.data.entities.LoadEntity;
import com.einao.ordersapp.data.entities.LoadsEntity;
import com.einao.ordersapp.data.network.OrdersNetworkDataSource;
import com.einao.ordersapp.data.network.common.EndpointConstants;
import com.einao.ordersapp.data.network.common.RepositoryCallback;
import com.einao.ordersapp.domain.beans.Error;
import com.einao.ordersapp.domain.providers.TimeProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class OrdersNetworkDataSourceFirebase implements OrdersNetworkDataSource {

    private RepositoryCallback repositoryCallback;

    private final DatabaseReference myRef;

    private final Long lastUpdate;
    private final TimeProvider timeProvider;

    public OrdersNetworkDataSourceFirebase(TimeProvider timeProvider) {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        database.setPersistenceEnabled(true);
        myRef = database.getReference();

        lastUpdate = 0L;
        this.timeProvider = timeProvider;
    }

    @Override
    public void getOrders(RepositoryCallback repositoryCallback) {
        this.repositoryCallback = repositoryCallback;

        myRef.child(EndpointConstants.RESOURCE_LOADS).addValueEventListener(ordersValueEventListener);
    }

    @NonNull
    private LoadsEntity createLoadsEntity(DataSnapshot dataSnapshot) {
        LoadsEntity loadsEntity = new LoadsEntity();

        for (DataSnapshot children : dataSnapshot.getChildren()) {
            LoadEntity loadEntity = children.getValue(LoadEntity.class);
            loadsEntity.add(loadEntity);
        }
        
        return loadsEntity;
    }

    @NonNull
    private Error createErrorEntity(DatabaseError error) {
        Error errorEntity = new Error();
        errorEntity.setCode(error.getCode());
        errorEntity.setMessage(error.getMessage());
        return errorEntity;
    }

    @Override
    public Long getLastUpdate() {
        return lastUpdate;
    }

    private void ordersFetched(DataSnapshot dataSnapshot) {
        Log.d(this.getClass().getName(), dataSnapshot.toString());

        LoadsEntity loadsEntity = createLoadsEntity(dataSnapshot);
        if (OrdersNetworkDataSourceFirebase.this.repositoryCallback == null) return;
        OrdersNetworkDataSourceFirebase.this.repositoryCallback.onSuccess(loadsEntity);
        // We usually update lastUpdate here but Firebase has its own database
        // lastUpdate = timeProvider.getCurrentTimeInMiliseconds();
    }

    private void ordersFetchCancelled(DatabaseError error) {
        Log.w(this.getClass().getName(), "Failed to read value.", error.toException());

        Error errorEntity = createErrorEntity(error);
        if (OrdersNetworkDataSourceFirebase.this.repositoryCallback == null) return;
        OrdersNetworkDataSourceFirebase.this.repositoryCallback.onFailure(errorEntity);
    }


    private ValueEventListener ordersValueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            ordersFetched(dataSnapshot);
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {
            ordersFetchCancelled(databaseError);
        }


    };
}
