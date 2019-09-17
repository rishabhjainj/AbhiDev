package com.abhidev.events;

import com.abhidev.apiservices.Repository;
import com.abhidev.common.EntitiesLoader;
import com.abhidev.listeners.OnEntitiesReceivedListener;
import com.abhidev.models.Event;

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
