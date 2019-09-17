package com.abhidev.presenters;

import com.abhidev.common.EntitiesLoader;
import com.abhidev.listeners.OnEntitiesReceivedListener;
import com.abhidev.models.Videos;
import com.abhidev.viewactions.VideosViewAction;

import java.util.Map;

/**
 * Created by Rishabh on 3/31/2018.
 */

public class VideosPresenter extends BasePresenter{
    OnEntitiesReceivedListener<Videos> videosRecievedListener;
    VideosViewAction viewAction;

    public VideosPresenter(OnEntitiesReceivedListener<Videos> videosRecievedListener, VideosViewAction viewAction){
        this.viewAction = viewAction;
        this.videosRecievedListener = videosRecievedListener;
    }

    public void loadVideos(Map<String, String> uriQuery){
        repository.getVideos(uriQuery, new EntitiesLoader<>(videosRecievedListener));
    }
}
