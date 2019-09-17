package com.abhidev.Activities;

import android.content.Intent;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.appcompat.widget.Toolbar;
import android.util.DisplayMetrics;
import android.widget.TextView;

import com.abhidev.adapters.TopCoursesItemAdapter;
import com.abhidev.apiservices.Repository;
import com.abhidev.models.CourseList;
import com.abhidev.presenters.SearchPresenter;
import com.abhidev.R;

import java.util.List;

public class ExploreTagSearchActivity extends SearchActivity {
    RecyclerView recyclerView;

    TextView title;
    Intent i;
    String searchQuery;
    SearchPresenter presenter;
    DisplayMetrics displayMetrics;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_tag_search);
        recyclerView = findViewById(R.id.recyclerView);
        title = findViewById(R.id.tooltilte);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setBackgroundColor(getResources().getColor(R.color.filter_blue));
        i = getIntent();
        displayMetrics=new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        presenter = new SearchPresenter(this, this, new Repository());
        searchQuery = i.getExtras().getString("search");
        title.setText(searchQuery);
        queryMap.put("search",searchQuery);
        presenter.searchCourses(queryMap);

    }
    @Override
    public void setCoursesRecyclerView(List<CourseList> courses) {
        recyclerView.hasFixedSize();
        recyclerView.removeAllViews();
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.removeAllViewsInLayout();
//
        courseAdapter=new TopCoursesItemAdapter(this,courses){
            @Override
            public void like(int id) {
                presenter.likeCourse(id);
            }
        };

        StaggeredGridLayoutManager layoutManager=new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(courseAdapter);
        courseAdapter.notifyDataSetChanged();
    }

}
