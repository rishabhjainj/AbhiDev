package com.wireout.presenters;

import com.wireout.apiservices.Repository;
import com.wireout.common.AbstractCallback;
import com.wireout.common.EntitiesLoader;
import com.wireout.common.LikeEntityManager;
import com.wireout.listeners.OnEntitiesReceivedListener;
import com.wireout.models.Articles;
import com.wireout.models.Career;
import com.wireout.models.CareerList;
import com.wireout.models.DailyGoals;
import com.wireout.models.Mentor;
import com.wireout.viewactions.CareerViewAction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;

public class CareerPresenter extends BasePresenter {
    OnEntitiesReceivedListener<DailyGoals> careerListener;
    CareerViewAction viewAction;

    public CareerPresenter(CareerViewAction viewAction,Repository repository){
        this.viewAction = viewAction;
        this.repository = repository;
    }

    public void loadMoreCareers(int page,OnEntitiesReceivedListener<CareerList> listener){
       // viewAction.showMessage("load more called");
        Map<String,String > uriQuery = new HashMap<>();
        uriQuery.put("page",page+"");
        repository.getCareer(uriQuery,new EntitiesLoader<>(listener));
    }
    public void getCareer(OnEntitiesReceivedListener<CareerList> listener){
        Map<String,String> map = new HashMap<>();
        map.put("page","1");
        repository.getCareer(map,new EntitiesLoader<>(listener));
    }
    public void getCareerTags(OnEntitiesReceivedListener<DailyGoals> listener){
        repository.getCareerTags(new HashMap<String, String>(),new EntitiesLoader<>(listener));
    }
    public void applyFilters(ArrayList<String> categories,int page,OnEntitiesReceivedListener<CareerList> listener){
        Map map = new HashMap<String, String>();
        map.put("page",page+"");
        repository.getCareer(map,categories,new EntitiesLoader<>(listener));
    }
    public void getCareerById(String id){
        repository.getCareerById(id,new AbstractCallback(viewAction){
            @Override
            public void onResponse(Call call, Response response) {
                Career career = (Career)response.body();
                if(career!=null){
                    viewAction.initUi(career);
                }
                else{
                    viewAction.showMessage("null");
                }
            }
        });
    }
    public void likeCampaigners(int id){repository.likeCampaigners(id, new LikeEntityManager(viewAction));}
    public void getCampaigners(OnEntitiesReceivedListener<Mentor> listener){
        repository.getMentors(new HashMap<String, String>(),new EntitiesLoader<>(listener));
    }
    public void getArticles(OnEntitiesReceivedListener<Articles> listener){
        repository.getArticles(new HashMap<String, String>(),new EntitiesLoader<>(listener));
    }
}
