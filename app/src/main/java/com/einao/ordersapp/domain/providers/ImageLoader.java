package com.einao.ordersapp.domain.providers;


public interface ImageLoader<T> {

    void load(T view, String url);

}
