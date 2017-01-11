package com.einao.ordersapp.domain.beans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Loads {

    List<Load> loads;

    public Loads() {
        loads = new ArrayList<>();
    }

    public List<Load> getLoads() {
        return loads;
    }

    public Load getItem(int position) {
        return loads.get(position);
    }

    public int getCount() {
        return loads.size();
    }

    public void add(Load load) {
        loads.add(load);
    }

    public void addAll(List<Load> load) {
        this.loads.addAll(load);
    }

    public Iterator<Load> iterator() {
        return loads.iterator();
    }

}
