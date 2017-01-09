package com.einao.ordersapp.app.ui.common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.einao.ordersapp.app.common.AuthenticationCredentials;
import com.einao.ordersapp.data.network.firebase.FirebaseAuthenticator;
import com.einao.ordersapp.domain.auth.Authenticator;

public abstract class BaseActivity<T extends Presenter> extends AppCompatActivity {

    protected T presenter;

    private Authenticator firebaseAuthenticator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        firebaseAuthenticator = new FirebaseAuthenticator(this);
        firebaseAuthenticator.authenticate(
                AuthenticationCredentials.AUTHENTICATE_EMAIL, AuthenticationCredentials.AUTHENTICATE_PASSWORD);

        if (presenter == null) {
            presenter = initPresenter();
        }


    }

    @Override
    protected void onStart() {
        super.onStart();
        firebaseAuthenticator.registerAuthenticator();
    }

    @Override
    protected void onStop() {
        super.onStop();
        firebaseAuthenticator.unregisterAuthenticator();
    }

    public abstract T initPresenter();
}
