package com.abhidev.presenters;

import android.content.Context;

import com.abhidev.apiservices.Repository;
import com.abhidev.common.EntitiesLoader;
import com.abhidev.common.LikeEntityManager;
import com.abhidev.listeners.OnEntitiesReceivedListener;
import com.abhidev.models.University;
import com.abhidev.viewactions.TrendingUniversitiesViewAction;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rahul on 10/3/18.
 */

public class TrendingUniversitryPresenter {

    TrendingUniversitiesViewAction viewAction;
    Context context;
    Repository repository;

    public TrendingUniversitryPresenter(TrendingUniversitiesViewAction viewAction, Context context, Repository repository) {
        this.viewAction = viewAction;
        this.context = context;
        this.repository = repository;
    }

    public void loadMoreUniversities(int page,OnEntitiesReceivedListener<University> listener){
        Map<String,String> uriQuery = new HashMap<>();
        uriQuery.put("page",page+"");
        repository.getUniversities(uriQuery, new EntitiesLoader<>(listener));
    }
    public void likeUniversity(int id){
        repository.likeUniversity(id, new LikeEntityManager(viewAction));
    }
    public void getUniversities(OnEntitiesReceivedListener<University> listener) {
        repository.getUniversities(new HashMap<String, String>(), new EntitiesLoader<>(listener));
    }
}
