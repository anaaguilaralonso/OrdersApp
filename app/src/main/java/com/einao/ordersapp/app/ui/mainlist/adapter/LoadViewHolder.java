package com.einao.ordersapp.app.ui.mainlist.adapter;

import android.support.v7.widget.RecyclerView;

import com.einao.ordersapp.app.ui.widget.LoadView;

public class LoadViewHolder extends RecyclerView.ViewHolder {

    LoadView loadView;

    public LoadViewHolder(LoadView loadView) {
        super(loadView);

        this.loadView = loadView;
    }
}
