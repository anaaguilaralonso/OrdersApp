package com.einao.ordersapp.app.ui.common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.einao.ordersapp.app.App;
import com.einao.ordersapp.app.common.AuthenticationCredentials;
import com.einao.ordersapp.app.provider.UseCaseProvider;
import com.einao.ordersapp.app.ui.provider.NavigationProvider;
import com.einao.ordersapp.data.network.firebase.FirebaseAuthenticator;
import com.einao.ordersapp.domain.auth.Authenticator;
import com.einao.ordersapp.domain.providers.ImageLoader;
import com.einao.ordersapp.domain.providers.MapFormatter;
import com.einao.ordersapp.domain.providers.TextFormatter;

import butterknife.ButterKnife;

public abstract class BaseActivity<T extends Presenter> extends AppCompatActivity implements BaseView {

    protected T presenter;

    private Authenticator firebaseAuthenticator;

    protected UseCaseProvider useCaseProvider;
    protected NavigationProvider navigationProvider;
    protected TextFormatter textFormatter;
    protected ImageLoader<ImageView> imageLoader;
    protected MapFormatter mapFormatter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayout());

        ButterKnife.bind(this);

        useCaseProvider = ((App) getApplication()).getUseCaseProvider();
        navigationProvider = ((App) getApplication()).getNavigationProvider(this);
        textFormatter = ((App) getApplication()).getTextFormatter();
        imageLoader = ((App) getApplication()).getImageLoader(this);
        mapFormatter = ((App) getApplication()).getMapFormatter();

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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return onOptionsItemSelected(item);
        }
    }

    public abstract T initPresenter();

    protected abstract int getLayout();

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
