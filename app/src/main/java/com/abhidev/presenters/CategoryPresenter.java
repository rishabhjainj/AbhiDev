package com.abhidev.presenters;

import android.util.Log;

import com.abhidev.apiservices.Repository;
import com.abhidev.common.AbstractCallback;
import com.abhidev.common.EntitiesLoader;
import com.abhidev.common.LikeEntityManager;
import com.abhidev.listeners.OnEntitiesReceivedListener;
import com.abhidev.models.Articles;
import com.abhidev.models.Category;
import com.abhidev.models.CourseList;
import com.abhidev.models.Mentor;
import com.abhidev.models.CategoryList;
import com.abhidev.viewactions.CategoryViewAction;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Response;

public class CategoryPresenter extends BasePresenter {
    CategoryViewAction viewAction;

    public CategoryPresenter(CategoryViewAction viewAction, Repository repository){
        this.repository = repository;
        this.viewAction= viewAction;
    }

    public void likeCampaigners(int id){repository.likeCampaigners(id, new LikeEntityManager(viewAction));}
    public void getCampaigners(OnEntitiesReceivedListener<Mentor> listener){
        repository.getMentors(new HashMap<String, String>(),new EntitiesLoader<>(listener));
    }
    public void getCategory(OnEntitiesReceivedListener<CourseList> listener){
        repository.getCourses(new HashMap<String, String>(),new EntitiesLoader<>(listener));
    }
    public void getCategoryById(String id){
        repository.getCategoryById(id,new AbstractCallback(viewAction){
            @Override
            public void onResponse(Call call, Response response) {
                Category category = (Category) response.body();
                if(category!=null){
                    viewAction.initUi(category);
                }
                else{
                    viewAction.showMessage("null");
                }
            }
        });
    }
    public void getArticles(OnEntitiesReceivedListener<Articles> listener){
        repository.getArticles(new HashMap<String, String>(),new EntitiesLoader<>(listener));
    }
    public void getCategoriesList(OnEntitiesReceivedListener<CategoryList> listener){
        Log.d("categoryList","called");
        repository.getSchoolsList(new HashMap<String, String>(),new EntitiesLoader<>(listener));
    }
}
