package com.abhidev.presenters;

import android.content.Context;
import android.util.Log;

import com.abhidev.apiservices.Repository;
import com.abhidev.common.AbstractCallback;
import com.abhidev.common.EntitiesLoader;
import com.abhidev.common.LikeEntityManager;
import com.abhidev.listeners.OnEntitiesReceivedListener;
import com.abhidev.models.CourseList;
import com.abhidev.models.Internships;
import com.abhidev.models.Mentor;
import com.abhidev.models.ShortTermCourse;
import com.abhidev.models.University;
import com.abhidev.responses.PaginatedResponse;
import com.abhidev.viewactions.WishlistViewAction;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by rahul on 18/4/18.
 */

public class WishListPresenter {

    Repository repository;
    WishlistViewAction viewAction;
    Context context;
    Map<String,String> queryMap;

    public WishListPresenter(Repository repository, WishlistViewAction viewAction, Context context) {
        this.repository = repository;
        this.viewAction = viewAction;
        this.context = context;
        queryMap = new HashMap<>();
    }

    public void getUniversities(){
        queryMap.put("liked","true");
        repository.getUniversities(queryMap, new AbstractCallback(viewAction) {
            @Override
            public void onResponse(Call call, Response response) {
                Log.d("uni responseCode",response.code()+","+response.message());
                PaginatedResponse<University> arrayResponse = (PaginatedResponse<University>) response.body();
                if(arrayResponse!=null){
                    if(arrayResponse.getResults().size()==0){
                        viewAction.showMessage("No Universities added!");
                    }
                    else
                    viewAction.setWishListRecyclerView(arrayResponse.getResults());
                }
                else{
                    //viewAction.showMessage("null");
                }
            }

        });
    }
    public void likeCourse(int id){
        repository.likeCourse(id, new LikeEntityManager(viewAction));
    }
    public void likeInternship(int id){
        repository.likeInternship(id,new LikeEntityManager(viewAction));
    }
    public void getWishCourses(){
        queryMap.put("liked","true");
        repository.getCourses(queryMap, new AbstractCallback(viewAction) {
            @Override
            public void onResponse(Call call, Response response) {
                Log.d("uni responseCode",response.code()+","+response.message());
                PaginatedResponse<CourseList> arrayResponse = (PaginatedResponse<CourseList>) response.body();
                if(arrayResponse!=null){
                    if(arrayResponse.getResults().size()==0){
                        viewAction.showMessage("No Courses added!");
                    }
                    else
                        viewAction.setWishListCourses(arrayResponse.getResults());
                }
                else{
                    //viewAction.showMessage("null");
                }
            }

        });
    }
    public void getCourses(Map<String,String> map,OnEntitiesReceivedListener<CourseList> listener){
        repository.getCourses(map,new EntitiesLoader<>(listener));
    }
    public void likeCampaigners(int id){repository.likeCampaigners(id, new LikeEntityManager(viewAction));}
    public void getCampaigners(Map<String,String> map,OnEntitiesReceivedListener<Mentor> listener){
        repository.getMentors(map,new EntitiesLoader<>(listener));
    }
    public void getInternships(Map<String,String> map,OnEntitiesReceivedListener<Internships> listener){
        repository.getInternships(map,new EntitiesLoader<>(listener));
    }
    public void getWishShortTermCourses(){
        queryMap.put("liked","true");
        repository.getShortTermCourses(queryMap, new AbstractCallback(viewAction) {
            @Override
            public void onResponse(Call call, Response response) {
                Log.d("uni responseCode",response.code()+","+response.message());
                PaginatedResponse<ShortTermCourse> arrayResponse = (PaginatedResponse<ShortTermCourse>) response.body();
                if(arrayResponse!=null){
                    if(arrayResponse.getResults().size()==0){
                        viewAction.showMessage("No Courses added!");
                    }
                    else
                        viewAction.setWishListShortTermCourses(arrayResponse.getResults());
                }
                else{
                    //viewAction.showMessage("null");
                }
            }

        });
    }

    public void getWishCampaigners(){
        queryMap.put("liked","true");
        repository.getCampaigners(queryMap, new AbstractCallback(viewAction) {
            @Override
            public void onResponse(Call call, Response response) {
                Log.d("uni responseCode",response.code()+","+response.message());
                PaginatedResponse<Mentor> arrayResponse = (PaginatedResponse<Mentor>) response.body();
                if(arrayResponse!=null){
                    if(arrayResponse.getResults().size()==0){
                        viewAction.showMessage("No Campaigners added!");
                    }
                    else
                        viewAction.setWishListCampaigners(arrayResponse.getResults());
                }
                else{
                    //viewAction.showMessage("null");
                }
            }

        });
    }

    public void likeUniversity(int id){repository.likeUniversity(id, new LikeEntityManager(viewAction) );}
    public void likeCourses(int id){repository.likeCourse(id, new LikeEntityManager(viewAction) );}

}
