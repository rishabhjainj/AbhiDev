package com.abhidev.presenters;

import com.abhidev.Recommendation.TabFragmentViewAction;
import com.abhidev.apiservices.Repository;
import com.abhidev.common.AbstractCallback;
import com.abhidev.common.EntitiesLoader;
import com.abhidev.listeners.OnEntitiesReceivedListener;
import com.abhidev.models.Slot;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Response;

public class TabFragment2Presenter extends BasePresenter {

    TabFragmentViewAction viewAction;

    public TabFragment2Presenter(TabFragmentViewAction viewAction, Repository repository){
        this.viewAction = viewAction;
        this.repository = repository;
    }
    public void getSlots(OnEntitiesReceivedListener<Slot> listener){
        repository.getSlots(new HashMap<String, String>(),new EntitiesLoader<>(listener));
    }
    public void bookSlot(String callSlot,String mode,String contact){
       repository.bookSlot(new AbstractCallback(viewAction) {
           @Override
           public void onResponse(Call call, Response response) {
               viewAction.showMessage(response.message()+","+response.code());
               viewAction.confirmVisible();
           }
       },callSlot,mode,contact);
    }


}
