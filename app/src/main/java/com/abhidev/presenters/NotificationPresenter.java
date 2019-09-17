package com.abhidev.presenters;

import com.abhidev.apiservices.Repository;
import com.abhidev.common.EntitiesLoader;
import com.abhidev.listeners.OnEntitiesReceivedListener;
import com.abhidev.models.Notification;

public class NotificationPresenter extends BasePresenter {
    public NotificationPresenter(Repository repository){
        this.repository = repository;
    }

    public void getNotifications(OnEntitiesReceivedListener<Notification> listener){
        repository.getNotifications(new EntitiesLoader<>(listener));
    }
}
