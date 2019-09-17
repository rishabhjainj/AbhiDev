package com.abhidev.randomized_feeds;


import com.abhidev.apiservices.Repository;
import com.abhidev.common.EntitiesLoader;
import com.abhidev.listeners.OnEntitiesReceivedListener;
import com.abhidev.models.RandomizedFeed;

public class RandomizedFeedsPresenter {

    Repository repository;

    public RandomizedFeedsPresenter(Repository repository){
        this.repository = repository;
    }

    public void getRandomizedFeeds(OnEntitiesReceivedListener<RandomizedFeed> listener){
        repository.getRandomizedFeeds(new EntitiesLoader<>(listener));
    }


}
