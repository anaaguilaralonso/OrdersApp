package com.einao.ordersapp.app;

import android.app.Application;

import com.einao.ordersapp.app.provider.NetworkDataSourceProvider;
import com.einao.ordersapp.app.provider.RepositoryProvider;
import com.einao.ordersapp.app.provider.StorageDataSourceProvider;
import com.einao.ordersapp.app.provider.UseCaseProvider;

public class App extends Application {

    private UseCaseProvider useCaseProvider;

    @Override
    public void onCreate() {
        super.onCreate();

        NetworkDataSourceProvider networkDataSourceProvider = new NetworkDataSourceProvider();
        StorageDataSourceProvider storageDataSourceProvider = new StorageDataSourceProvider();

        RepositoryProvider repositoryProvider =
                new RepositoryProvider(networkDataSourceProvider, storageDataSourceProvider);

        useCaseProvider = new UseCaseProvider(repositoryProvider);

    }

    public UseCaseProvider getUseCaseProvider() {
        return useCaseProvider;
    }
}
