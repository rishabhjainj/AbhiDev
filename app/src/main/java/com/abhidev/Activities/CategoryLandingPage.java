package com.abhidev.Activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.github.clans.fab.FloatingActionButton;
import com.abhidev.common.MyApplication;
import com.abhidev.listeners.OnUserReceivedListener;
import com.abhidev.models.User;
import com.abhidev.presenters.CurrentUserPresenter;
import com.abhidev.R;
import com.abhidev.ViewMore.AmbassdorsActivity;
import com.abhidev.ViewMore.TrendingUniversitiesActivity;
import com.abhidev.adapters.CareerBlogAdapter;
import com.abhidev.adapters.CareerOptionsAdapter;
import com.abhidev.adapters.InstitutesAdapter;
import com.abhidev.adapters.LandingPageMentorAdapter;
import com.abhidev.adapters.RelatedCoursesAdapter;
import com.abhidev.apiservices.Repository;
import com.abhidev.listeners.OnEntitiesReceivedListener;
import com.abhidev.models.Articles;
import com.abhidev.models.CareerOption;
import com.abhidev.models.Category;
import com.abhidev.models.Institution;
import com.abhidev.models.Mentor;
import com.abhidev.models.RelatedCourse;
import com.abhidev.presenters.CategoryPresenter;
import com.abhidev.viewactions.CategoryViewAction;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CategoryLandingPage extends BaseActivity implements CategoryViewAction,OnUserReceivedListener{
    ImageView backBtn;
    RecyclerView careerOptionsRecyclerView;
    RelatedCoursesAdapter topCoursesItemAdapter;
    RecyclerView popularCoursesRecyclerView;
    RecyclerView institutesRecyclerView;
    TextView tootitle;
    CareerOptionsAdapter subjectsAdapter;
    TextView viewAllCourses,viewAllCareer,viewAllMentors,viewAllBlogs,viewInstitutes;
    DisplayMetrics displayMetrics;
    TextView learnMore;
    List<String> subjects;
    RecyclerView trendingRecyclerView;
    CareerBlogAdapter wikipediaAdapter;
    TextView userName;
    FloatingActionButton floatingActionButton;
    OnEntitiesReceivedListener<Articles> listener;
    CategoryPresenter presenter;
    TextView categoryName;
    TextView categoryPopularityText;
    TextView categoryPopPercentage;
    Intent i;
    LandingPageMentorAdapter adapter;
    OnEntitiesReceivedListener<Mentor> mentorListener;
    RecyclerView recyclerView;

    RelativeLayout topLayout;
    InstitutesAdapter institutesAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottie);
        i = getIntent();
        String id = i.getExtras().getString("id");
        Log.d("categoryImage",id);
        presenter = new CategoryPresenter(this, new Repository());
        presenter.getCategoryById(id);
        listener = new OnEntitiesReceivedListener<Articles>(this) {
            @Override
            public void onReceived(List<Articles> articles) {
                setTrendingRecyclerView(articles);
            }
        };
        mentorListener = new OnEntitiesReceivedListener<Mentor>(this) {
            @Override
            public void onReceived(List<Mentor> mentors) {
                setAmbassdorRecyclerView(mentors);
            }
        };

    }

    public void setAmbassdorRecyclerView(List<Mentor> ambassdorsDataList) {
        adapter=new LandingPageMentorAdapter(getApplicationContext(),ambassdorsDataList){
            @Override
            public void OnLiked(int id) {
                presenter.likeCampaigners(id);
            }
        };
        StaggeredGridLayoutManager linearLayoutManager=new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }
    public void setTrendingRecyclerView(List<Articles> articles) {
        trendingRecyclerView.setHasFixedSize(true);
        trendingRecyclerView.removeAllViews();
        trendingRecyclerView.setNestedScrollingEnabled(false);
        trendingRecyclerView.removeAllViewsInLayout();
        StaggeredGridLayoutManager mStaggeredVerticalLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL); // (int spanCount, int orientation)
        trendingRecyclerView.setLayoutManager(mStaggeredVerticalLayoutManager);
        wikipediaAdapter =
                new CareerBlogAdapter(this,articles);
        trendingRecyclerView.setAdapter(wikipediaAdapter);
        trendingRecyclerView.setLayoutManager(mStaggeredVerticalLayoutManager);

        wikipediaAdapter.notifyDataSetChanged();

    }
    @Override
    public void initUi(final Category category) {
        setContentView(R.layout.category_landing_page);
        backBtn = findViewById(R.id.backbtn);
        userName = findViewById(R.id.username);
        if(MyApplication.getInstance().prefManager.isLoggedIn()){
            new CurrentUserPresenter(this,this).getCurrentUser();
        }

        viewAllBlogs = findViewById(R.id.view_career_blogs);
        viewAllCareer = findViewById(R.id.view_all_career);
        viewAllCourses = findViewById(R.id.view_all_courses);
        viewAllMentors = findViewById(R.id.view_all_mentors);
        viewInstitutes= findViewById(R.id.view_all_inst);


        viewAllBlogs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(CategoryLandingPage.this, TrendingArticlesActivity.class);
                myIntent.putExtra("landing","yes");
                startActivity(myIntent);
            }
        });
        viewAllCareer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(CategoryLandingPage.this, CareerActivity.class);
                myIntent.putExtra("LIST", (Serializable) category.getCareerOptions());
                myIntent.putExtra("landing","yes");
                startActivity(myIntent);
            }
        });
        viewAllCourses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(CategoryLandingPage.this, AllCoursesActivity.class);
                myIntent.putExtra("LIST", (Serializable) category.getCourses());
                myIntent.putExtra("landing","yes");
                startActivity(myIntent);
            }
        });
        viewAllMentors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CategoryLandingPage.this, AmbassdorsActivity.class));
            }
        });
        viewInstitutes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(CategoryLandingPage.this, TrendingUniversitiesActivity.class);
                myIntent.putExtra("LIST", (Serializable) category.getInstitutions());
                myIntent.putExtra("landing","yes");
                startActivity(myIntent);
            }
        });


        floatingActionButton = findViewById(R.id.fab);
        recyclerView = findViewById(R.id.am_recycler_view);
        presenter.getCampaigners(mentorListener);
        categoryName = findViewById(R.id.category_name);
        categoryPopPercentage = findViewById(R.id.category_pop_percent);
        categoryPopularityText = findViewById(R.id.category_pop_text);
        tootitle = findViewById(R.id.tooltilte);


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CategoryLandingPage.this, AptitudeActivity.class));
            }
        });
        learnMore = findViewById(R.id.learnmore);
        learnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CategoryLandingPage.this,OverviewActivity.class);
                i.putExtra("coursename",category.getName());
                i.putExtra("courseimage",category.getImage());
                i.putExtra("courseoverview",category.getDescription());
                startActivity(i);
            }
        });
        trendingRecyclerView  = findViewById(R.id.career_recyclerview);


        presenter.getArticles(listener);

        tootitle.setText(category.getName());
        categoryName.setText(category.getName());
        categoryPopPercentage.setText(category.getPopularity()+"%");
        categoryPopularityText.setText(category.getDescription());

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        popularCoursesRecyclerView = findViewById(R.id.popular_courses_recyclerView);
        careerOptionsRecyclerView = findViewById(R.id.college_recycler_view);
        institutesRecyclerView = findViewById(R.id.institutions_recyclerview);
        displayMetrics=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        topLayout = findViewById(R.id.appbar);
        Double height=displayMetrics.heightPixels/(3.2);
        topLayout.getLayoutParams().height=height.intValue();
        topLayout.getLayoutParams().width=displayMetrics.widthPixels;

        subjects = new ArrayList<>();
        subjects.add("Become a Data Scientist");
        subjects.add("Become a Financial Analyst");
        subjects.add("Become a Lawyer");
        subjects.add("Become a Web Developer");
        subjects.add("Become an Android Developer");

        setRelatedCareerOptions(category.getCareerOptions());

        if(category.getCourses().size()>3)
        setRelatedCourses(category.getCourses().subList(0,2));
        else
            setRelatedCourses(category.getCourses());
        setInstitutesRecyclerView(category.getInstitutions());
    }

    public void setRelatedCareerOptions(List<CareerOption> careers) {

        careerOptionsRecyclerView.setHasFixedSize(true);
        careerOptionsRecyclerView.removeAllViews();
        careerOptionsRecyclerView.setNestedScrollingEnabled(false);
        careerOptionsRecyclerView.removeAllViewsInLayout();
        StaggeredGridLayoutManager mStaggeredVerticalLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL); // (int spanCount, int orientation)
        careerOptionsRecyclerView.setLayoutManager(mStaggeredVerticalLayoutManager);
        subjectsAdapter =
                new CareerOptionsAdapter(this,careers,displayMetrics);
        careerOptionsRecyclerView.setAdapter(subjectsAdapter);
        careerOptionsRecyclerView.setLayoutManager(mStaggeredVerticalLayoutManager);

        subjectsAdapter.notifyDataSetChanged();

    }
    private void setInstitutesRecyclerView(List<Institution> institutions) {

        institutesRecyclerView.hasFixedSize();
        institutesRecyclerView.removeAllViews();
        institutesRecyclerView.setNestedScrollingEnabled(false);
        institutesRecyclerView.removeAllViewsInLayout();

        institutesAdapter=new InstitutesAdapter(this,institutions);
        StaggeredGridLayoutManager mStaggeredVerticalLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL);
        institutesRecyclerView.setLayoutManager(mStaggeredVerticalLayoutManager);
        institutesRecyclerView.setHasFixedSize(true);
        institutesRecyclerView.setAdapter(institutesAdapter);

    }
    public void setRelatedCourses(List<RelatedCourse> courses)
    {

        popularCoursesRecyclerView.hasFixedSize();
        popularCoursesRecyclerView.removeAllViews();
        popularCoursesRecyclerView.setNestedScrollingEnabled(false);
        popularCoursesRecyclerView.removeAllViewsInLayout();
//

        topCoursesItemAdapter=new RelatedCoursesAdapter(this,courses);

        StaggeredGridLayoutManager layoutManager=new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL);
        popularCoursesRecyclerView.setLayoutManager(layoutManager);
        popularCoursesRecyclerView.setAdapter(topCoursesItemAdapter);
        topCoursesItemAdapter.notifyDataSetChanged();

    }
    @Override
    public void onUserReceived(User user) {
        if(userName!=null){
            userName.setText("Hi "+user.getFirstName()+",");
        }
    }
}
