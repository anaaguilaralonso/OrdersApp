package com.einao.ordersapp.app.ui.mainlist.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;

import com.einao.ordersapp.app.ui.viewmodel.LoadViewModel;
import com.einao.ordersapp.app.ui.viewmodel.LoadsViewModel;
import com.einao.ordersapp.app.ui.widget.LoadView;

public class LoadsListAdapter extends RecyclerView.Adapter<LoadViewHolder> {

    LoadsViewModel loadsViewModel;

    public LoadsListAdapter(){
        this.loadsViewModel = new LoadsViewModel();
    }

    @Override
    public LoadViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LoadViewHolder(new LoadView(parent.getContext()));
    }

    @Override
    public void onBindViewHolder(LoadViewHolder holder, int position) {
        LoadViewModel loadViewModel = loadsViewModel.getItem(position);
        holder.loadView.setLoadViewModel(loadViewModel);
    }

    @Override
    public int getItemCount() {
        return loadsViewModel.getCount();
    }

    public void add(LoadViewModel load) {
        loadsViewModel.add(load);
    }

    public void clear() {
        loadsViewModel.deleteAll();
    }
}
