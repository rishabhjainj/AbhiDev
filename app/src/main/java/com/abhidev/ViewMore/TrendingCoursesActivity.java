package com.abhidev.ViewMore;

import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.MenuItem;


import com.abhidev.Activities.BaseActivity;
import com.abhidev.R;
import com.abhidev.adapters.ViewMoreTrendingCoursesAdapter;
import com.abhidev.common.PrefManager;
import com.abhidev.models.CourseList;
import com.abhidev.presenters.TrendingCoursesPresenter;
import com.abhidev.repositories.TrendingCoursesRepository;
import com.abhidev.viewactions.TrendingCoursesViewAction;

import java.util.List;

public class TrendingCoursesActivity extends BaseActivity implements TrendingCoursesViewAction{

    RecyclerView recyclerView;
    ViewMoreTrendingCoursesAdapter adapter;
    TrendingCoursesPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_more__trending_courses);

        recyclerView=(RecyclerView)findViewById(R.id.recyclerview_viewMore_trendingCourses);

        presenter=new TrendingCoursesPresenter(new TrendingCoursesRepository(),getApplicationContext(),this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tool);
        toolbar.setBackgroundColor(getResources().getColor(R.color.filter_blue));
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

//        Intent intent=getIntent();
//        Bundle bundle=intent.getBundleExtra("Bundle");
//        ArrayList<ShortTermCoursesData> shortTermCoursesData=(ArrayList<ShortTermCoursesData>)bundle.getSerializable("ShortTermCoursesData");

        presenter.getCourses();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setTrendingCoursesRecyclerView(List<CourseList> courseList) {
        DisplayMetrics displayMetrics=new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        adapter=new ViewMoreTrendingCoursesAdapter(new PrefManager(getApplicationContext()),getApplicationContext(),courseList,displayMetrics){
            @Override
            public void OnLiked(int id) {
                presenter.likeCourse(id);
            }
        };

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void startVideos() {

    }
}
