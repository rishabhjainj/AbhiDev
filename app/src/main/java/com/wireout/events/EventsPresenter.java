package com.wireout.events;

import com.wireout.apiservices.Repository;
import com.wireout.common.EntitiesLoader;
import com.wireout.listeners.OnEntitiesReceivedListener;
import com.wireout.models.Event;

import java.util.Map;

public class EventsPresenter {
    Repository repository;

    public EventsPresenter(Repository repository){
        this.repository = repository;
    }

    public void getEvents(Map<String,String> queryMap, OnEntitiesReceivedListener<Event> listener){
        repository.getEvents(queryMap,new EntitiesLoader<>(listener));
    }
}
