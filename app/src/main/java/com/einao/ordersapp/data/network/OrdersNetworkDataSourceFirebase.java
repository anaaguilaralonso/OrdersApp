package com.einao.ordersapp.data.network;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class OrdersNetworkDataSourceFirebase implements OrdersNetworkDataSource {

    DatabaseReference myRef;

    public OrdersNetworkDataSourceFirebase(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
         myRef = database.getReference();
    }

    @Override
    public void getOrders() {
        myRef.child("usersData").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                //String value = dataSnapshot.getValue(String.class);
                Log.d(this.getClass().getName(), "Value is something!");
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(this.getClass().getName(), "Failed to read value.", error.toException());
            }
        });
    }
}
