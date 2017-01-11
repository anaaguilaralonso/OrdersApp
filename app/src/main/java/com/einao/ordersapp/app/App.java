package com.einao.ordersapp.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.einao.ordersapp.app.policy.ShortDataBasePolicy;
import com.einao.ordersapp.app.provider.NetworkDataSourceProvider;
import com.einao.ordersapp.app.provider.RepositoryProvider;
import com.einao.ordersapp.app.provider.StorageDataSourceProvider;
import com.einao.ordersapp.app.provider.UseCaseProvider;
import com.einao.ordersapp.app.ui.provider.AndroidTimeProvider;
import com.einao.ordersapp.app.ui.provider.GoogleMapFormatter;
import com.einao.ordersapp.app.ui.provider.NavigationProvider;
import com.einao.ordersapp.app.ui.provider.OrdersTextFormatter;
import com.einao.ordersapp.app.ui.provider.PicassoImageLoader;
import com.einao.ordersapp.domain.providers.ImageLoader;
import com.einao.ordersapp.domain.providers.MapFormatter;
import com.einao.ordersapp.domain.providers.TextFormatter;
import com.einao.ordersapp.domain.providers.TimeProvider;

public class App extends Application {

    private UseCaseProvider useCaseProvider;

    @Override
    public void onCreate() {
        super.onCreate();

        NetworkDataSourceProvider networkDataSourceProvider = new NetworkDataSourceProvider();
        StorageDataSourceProvider storageDataSourceProvider = new StorageDataSourceProvider();

        TimeProvider timeProvider = new AndroidTimeProvider();
        ShortDataBasePolicy dataBasePolicy = new ShortDataBasePolicy(timeProvider);

        RepositoryProvider repositoryProvider =
                new RepositoryProvider(networkDataSourceProvider, storageDataSourceProvider, dataBasePolicy,
                        timeProvider);

        useCaseProvider = new UseCaseProvider(repositoryProvider);

    }

    public UseCaseProvider getUseCaseProvider() {
        return useCaseProvider;
    }

    public TextFormatter getTextFormatter() {
        return new OrdersTextFormatter();
    }

    public NavigationProvider getNavigationProvider(Activity activity) {
        return new NavigationProvider(activity);
    }

    public ImageLoader getImageLoader(Context context) {
        return new PicassoImageLoader(context);
    }

    public MapFormatter getMapFormatter() {
        return new GoogleMapFormatter();
    }
}
