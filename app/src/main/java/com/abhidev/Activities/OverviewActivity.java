package com.abhidev.Activities;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import com.abhidev.R;

public class OverviewActivity extends BaseActivity{
    TextView tooltitle;
    TextView overview;
    ImageView courseImage;
    Intent i;
    String courseName;
    String imageUrl;
    String courseOverView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);
        tooltitle = findViewById(R.id.tooltilte);
        overview = findViewById(R.id.overView_text);
        courseImage = findViewById(R.id.course_image);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(getResources().getColor(R.color.filter_blue));
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        i = getIntent();
        courseName = i.getExtras().getString("coursename");
        imageUrl = i.getExtras().getString("courseimage");
        courseOverView = i.getExtras().getString("courseoverview");

        tooltitle.setText(courseName);
        Picasso.with(this).load(imageUrl).into(courseImage);
        overview.setText(courseOverView);
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

}
