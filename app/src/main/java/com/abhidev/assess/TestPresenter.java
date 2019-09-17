package com.abhidev.assess;

import com.abhidev.common.EntitiesLoader;
import com.abhidev.listeners.OnEntitiesReceivedListener;
import com.abhidev.models.Assessment;
import com.abhidev.presenters.BasePresenter;

public class TestPresenter extends BasePresenter {
    public void getAssessmentSections(OnEntitiesReceivedListener<Assessment> listener){
        repository.getAssessmentSections(new EntitiesLoader<>(listener));
    }

}
