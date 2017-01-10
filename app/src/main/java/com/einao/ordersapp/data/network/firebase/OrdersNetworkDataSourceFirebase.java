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

import java.util.Iterator;


public class OrdersNetworkDataSourceFirebase implements OrdersNetworkDataSource {

    private RepositoryCallback repositoryCallback;

    private final DatabaseReference myRef;

    private Long lastUpdate;
    private TimeProvider timeProvider;

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

        myRef.child(EndpointConstants.RESOURCE_LOADS).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Log.d(this.getClass().getName(), dataSnapshot.toString());

                LoadsEntity loadsEntity = createLoadsEntity(dataSnapshot);
                if (OrdersNetworkDataSourceFirebase.this.repositoryCallback == null) return;
                OrdersNetworkDataSourceFirebase.this.repositoryCallback.onSuccess(loadsEntity);
                // We usually update lastUpdate here but Firebase has its own database
                // lastUpdate = timeProvider.getCurrentTimeInMiliseconds();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(this.getClass().getName(), "Failed to read value.", error.toException());

                Error errorEntity = createErrorEntity(error);
                if (OrdersNetworkDataSourceFirebase.this.repositoryCallback == null) return;
                OrdersNetworkDataSourceFirebase.this.repositoryCallback.onFailure(errorEntity);
            }
        });
    }

    @NonNull
    private LoadsEntity createLoadsEntity(DataSnapshot dataSnapshot) {
        LoadsEntity loadsEntity = new LoadsEntity();

        Iterator<DataSnapshot> iterator = dataSnapshot.getChildren().iterator();
        while (iterator.hasNext()) {
            LoadEntity loadEntity = iterator.next().getValue(LoadEntity.class);
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
}
