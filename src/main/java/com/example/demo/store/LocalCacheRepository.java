package com.example.demo.store;

import com.example.demo.controller.request.TransactionRoute;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;


@Repository
public class LocalCacheRepository {
    LinkedHashSet<String> addSort = new LinkedHashSet<>();
    AtomicInteger lastId = new AtomicInteger();
    CopyOnWriteArrayList<TransactionRoute> cache = new CopyOnWriteArrayList<>();

    public void add(TransactionRoute transactionRoute){
        if(!addSort.contains(transactionRoute.getPayer())){
            addSort.add(transactionRoute.getPayer());
        }
        transactionRoute.setId(lastId.addAndGet(1));
        cache.add(transactionRoute);
    }

    public List<TransactionRoute> getAll(){
        return cache;
    }

    public LinkedHashSet<String> getAddSort(){
        return addSort;
    }

    public void update(TransactionRoute route) {
        for (TransactionRoute transactionRoute: cache) {
            if(transactionRoute.getId() == route.getId()){
                transactionRoute.setPoints(route.getPoints());
                return;
            }
        }
    }
}
