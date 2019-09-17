package com.abhidev.presenters;

import com.abhidev.common.EntitiesLoader;
import com.abhidev.listeners.OnEntitiesReceivedListener;
import com.abhidev.models.Tag;
import com.abhidev.viewactions.ExploreViewAction;

import java.util.Map;

/**
 * Created by Rishabh on 3/31/2018.
 */

public class ExplorePresenter extends BasePresenter{
    OnEntitiesReceivedListener<Tag> tagReceivedListener;
    ExploreViewAction viewAction;

    public ExplorePresenter(OnEntitiesReceivedListener<Tag> tagReceivedListener, ExploreViewAction viewAction){
        this.viewAction = viewAction;
        this.tagReceivedListener = tagReceivedListener;
    }

    public void loadTags(Map<String, String> uriQuery){
        repository.getTags(uriQuery, new EntitiesLoader<>(tagReceivedListener));
    }
}
