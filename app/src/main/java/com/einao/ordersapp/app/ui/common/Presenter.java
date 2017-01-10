package com.einao.ordersapp.app.ui.common;

import java.lang.ref.WeakReference;

public abstract class Presenter<View> {

    protected final WeakReference<View> view;

    public Presenter(View view) {
        this.view = new WeakReference<>(view);
    }

    public abstract void start();

    public boolean existView() {
        return view.get() != null;
    }
}
