package com.einao.ordersapp.data.entities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoadsEntity {

    List<LoadEntity> loadEntities;

    public LoadsEntity() {
        loadEntities = new ArrayList<>();
    }

    public List<LoadEntity> getLoadsEntity() {
        return loadEntities;
    }

    public LoadEntity getItem(int position) {
        return loadEntities.get(position);
    }

    public int getCount() {
        return loadEntities.size();
    }

    public void add(LoadEntity loadEntity) {
        loadEntities.add(loadEntity);
    }

    public void addAll(List<LoadEntity> loadEntities) {
        this.loadEntities.addAll(loadEntities);
    }

    public Iterator<LoadEntity> iterator() {
        return loadEntities.iterator();
    }


}
