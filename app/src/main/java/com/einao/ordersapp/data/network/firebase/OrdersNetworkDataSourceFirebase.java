package com.einao.ordersapp.data.network.firebase;

import android.util.Log;

import com.einao.ordersapp.data.entities.LoadEntity;
import com.einao.ordersapp.data.entities.LoadsEntity;
import com.einao.ordersapp.data.network.common.EndpointConstants;
import com.einao.ordersapp.data.network.OrdersNetworkDataSource;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Iterator;


public class OrdersNetworkDataSourceFirebase implements OrdersNetworkDataSource {

    private final DatabaseReference myRef;


    public OrdersNetworkDataSourceFirebase() {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference();

    }

    @Override
    public void getOrders() {

        myRef.child(EndpointConstants.RESOURCE_LOADS).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Log.d(this.getClass().getName(), dataSnapshot.toString());

                LoadsEntity loadsEntity = new LoadsEntity();
                Iterator<DataSnapshot> iterator = dataSnapshot.getChildren().iterator();
                while (iterator.hasNext()){
                    LoadEntity loadEntity = iterator.next().getValue(LoadEntity.class);
                    loadsEntity.add(loadEntity);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(this.getClass().getName(), "Failed to read value.", error.toException());
            }
        });
    }
}
