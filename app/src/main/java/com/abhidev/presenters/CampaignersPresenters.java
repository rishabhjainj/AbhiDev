package com.abhidev.presenters;

import android.content.Context;


import com.abhidev.common.EntitiesLoader;
import com.abhidev.common.LikeEntityManager;
import com.abhidev.listeners.OnEntitiesReceivedListener;
import com.abhidev.models.Mentor;
import com.abhidev.repositories.CampaignersRepository;
import com.abhidev.viewactions.AmbasdorsViewAction;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rahul on 10/3/18.
 */

public class CampaignersPresenters extends BasePresenter {

    AmbasdorsViewAction ambasdorsViewAction;
    Context context;
    CampaignersRepository campaignersRepository;


    public CampaignersPresenters(AmbasdorsViewAction ambasdorsViewAction, Context context, CampaignersRepository campaignersRepository) {
        this.ambasdorsViewAction = ambasdorsViewAction;
        this.context = context;
        this.campaignersRepository = campaignersRepository;
    }

    public void likeCampaigners(int id){campaignersRepository.likeCampaigners(id, new LikeEntityManager(ambasdorsViewAction));}
    public void getCampaigners(OnEntitiesReceivedListener<Mentor> listener){
        repository.getMentors(new HashMap<String, String>(),new EntitiesLoader<>(listener));
    }
    public void loadMoreMentors(int page, OnEntitiesReceivedListener<Mentor> listener){
        Map<String,String> uriQuery = new HashMap<>();
        uriQuery.put("page",page+"");
        repository.getMentors(uriQuery,new EntitiesLoader<>(listener));
    }

}
