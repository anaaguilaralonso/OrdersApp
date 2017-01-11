package com.einao.ordersapp.app.ui.mainlist.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.einao.ordersapp.app.ui.viewmodel.LoadViewModel;
import com.einao.ordersapp.app.ui.viewmodel.LoadsViewModel;
import com.einao.ordersapp.app.ui.widget.LoadView;

public class LoadsListAdapter extends RecyclerView.Adapter<LoadViewHolder> {

    private final LoadsViewModel loadsViewModel;
    private final OnLoadClickListener onLoadClickListener;

    public LoadsListAdapter(OnLoadClickListener onLoadClickListener) {
        this.loadsViewModel = new LoadsViewModel();
        this.onLoadClickListener = onLoadClickListener;
    }

    @Override
    public LoadViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LoadView loadView = new LoadView(parent.getContext());
        return new LoadViewHolder(loadView);
    }

    @Override
    public void onBindViewHolder(LoadViewHolder holder, int position) {
        final LoadViewModel loadViewModel = loadsViewModel.getItem(position);
        holder.loadView.setLoadViewModel(loadViewModel);
        holder.loadView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onLoadClickListener.onClick(loadViewModel);
            }
        });
    }

    @Override
    public int getItemCount() {
        return loadsViewModel.getCount();
    }

    public void add(LoadViewModel load) {
        loadsViewModel.add(load);
        notifyItemInserted(loadsViewModel.getCount() - 1);
    }

    public void clear() {
        loadsViewModel.deleteAll();
        notifyDataSetChanged();
    }

    public interface OnLoadClickListener {
        void onClick(LoadViewModel loadViewModel);
    }
}
