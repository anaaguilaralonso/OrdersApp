package com.einao.ordersapp.data.entities.mappers;

import com.einao.ordersapp.data.entities.LoadEntity;
import com.einao.ordersapp.data.entities.LoadsEntity;
import com.einao.ordersapp.domain.beans.Load;
import com.einao.ordersapp.domain.beans.Loads;

import java.util.Iterator;

public class LoadsEntityMapper {

    public Loads map(LoadsEntity loadsEntity){
        Loads loads = new Loads();

        LoadEntityMapper mapper = new LoadEntityMapper();
        Iterator<LoadEntity> iterator = loadsEntity.iterator();
        while(iterator.hasNext()){
            Load load = mapper.map(iterator.next());
            loads.add(load);
        }

        return loads;
    }
}
