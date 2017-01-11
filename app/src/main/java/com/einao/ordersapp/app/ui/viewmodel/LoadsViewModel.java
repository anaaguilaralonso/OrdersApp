package com.einao.ordersapp.app.ui.viewmodel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoadsViewModel {

    List<LoadViewModel> loads;

    public LoadsViewModel() {
        loads = new ArrayList<>();
    }

    public List<LoadViewModel> getLoads() {
        return loads;
    }

    public LoadViewModel getItem(int position) {
        return loads.get(position);
    }

    public int getCount() {
        return loads.size();
    }

    public void add(LoadViewModel load) {
        loads.add(load);
    }

    public void addAll(List<LoadViewModel> load) {
        this.loads.addAll(load);
    }

    public Iterator<LoadViewModel> iterator() {
        return loads.iterator();
    }

    public void deleteAll() {
        loads.clear();
    }
}
