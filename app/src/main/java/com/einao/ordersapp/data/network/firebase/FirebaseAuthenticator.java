package com.einao.ordersapp.data.network.firebase;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.util.Log;

import com.einao.ordersapp.domain.auth.Authenticator;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class FirebaseAuthenticator implements Authenticator {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    private Activity activity;

    public FirebaseAuthenticator(Activity activity) {
        this.activity = activity;

        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(this.getClass().getName(), "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d(this.getClass().getName(), "onAuthStateChanged:signed_out");
                }
            }
        };
    }

    @Override
    public void registerAuthenticator() {
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void unregisterAuthenticator() {
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    @Override
    public void authenticate(String email, String password) {

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(this.getClass().getName(), "signInWithEmail:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Log.w(this.getClass().getName(), "signInWithEmail:failed", task.getException());
                        }
                    }
                });
    }
}
