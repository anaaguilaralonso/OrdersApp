package com.einao.ordersapp.data.network.firebase;

import android.util.Log;

import com.einao.ordersapp.data.network.common.EndpointConstants;
import com.einao.ordersapp.data.network.OrdersNetworkDataSource;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


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
                //String value = dataSnapshot.getValue(String.class);
                Log.d(this.getClass().getName(), dataSnapshot.toString());
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(this.getClass().getName(), "Failed to read value.", error.toException());
            }
        });
    }
}
