package com.abhidev.Exams;

import com.abhidev.apiservices.Repository;
import com.abhidev.common.EntitiesLoader;
import com.abhidev.listeners.OnEntitiesReceivedListener;
import com.abhidev.models.exams.ExamSubCategory;
import com.abhidev.presenters.BasePresenter;


import java.util.Map;

public class ExamPresenter extends BasePresenter {
    ExamViewAction viewAction;
    Repository repository;

    public ExamPresenter(ExamViewAction viewAction,Repository repository){
        this.repository = repository;
        this.viewAction = viewAction;

    }
    public void submitTestResponse(OnEntitiesReceivedListener<TestResponse> listener){

    }
    public void getExamCategories(OnEntitiesReceivedListener<CategoryModel> listener){
        repository.getExamCategories(new EntitiesLoader<>(listener));
    }
    public void getExamSubCategories(OnEntitiesReceivedListener<ExamSubCategory> listener, Map<String,String> query){
        repository.getExamSubCategories(query,new EntitiesLoader<>(listener));
    }
}
