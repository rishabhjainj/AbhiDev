package com.abhidev.Activities;

import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;


import com.abhidev.viewactions.TedViewAction;
import com.abhidev.R;
import com.abhidev.adapters.TedTalksAdapter;
import com.abhidev.apiservices.Repository;
import com.abhidev.listeners.OnEntitiesReceivedListener;
import com.abhidev.models.TedYouTube;
import com.abhidev.presenters.TedTalksPresenter;

import java.util.ArrayList;
import java.util.List;

public class TedTalksActivity extends BaseActivity implements TedViewAction{

    RecyclerView tedRecyclerView;
    TedTalksAdapter tedTalksAdapter;
    ArrayList<String> links,stories;
    int index=1;
    ArrayList<TedYouTube> tedYouTubeArrayList;
    TedTalksPresenter presenter;
    OnEntitiesReceivedListener<TedYouTube> moreTedListener;
    OnEntitiesReceivedListener<TedYouTube> tedListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ted_talks);
        tedYouTubeArrayList = new ArrayList<>();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(getResources().getColor(R.color.filter_blue));
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        tedRecyclerView = findViewById(R.id.ted_recyclerview);
//        links = new ArrayList<>();
//        links.add("_tewedUBhAo");
//        links.add("Fw1Fc_y_2Ek");
//        links.add("9Q7Zl3OI4us");
//        links.add("kcW4ABcY3zI");
//        links.add("LTnI7cmpDZI");
//
//        stories = new ArrayList<>();
//        stories.add("What it's like to be the child of immigrants");
//        stories.add("The interesting story of our educational system");
//        stories.add("The 3 Myths of the Indian Education System");
//        stories.add("A well educated mind vs a well formed mind");
//        stories.add("What makes life complete?");
        tedListener = new OnEntitiesReceivedListener<TedYouTube>(this) {
            @Override
            public void onReceived(List<TedYouTube> tedVideos) {
                setTedTalksRecyclerView(tedVideos);
            }
        };
        moreTedListener = new OnEntitiesReceivedListener<TedYouTube>(this) {
            @Override
            public void onReceived(List<TedYouTube> entities) {
                addToRecyclerView(entities);
            }
        };

        presenter = new TedTalksPresenter(new Repository());
        presenter.getTedVideos(tedListener);


        }

    @Override
    public void addToRecyclerView(List<TedYouTube> list) {
        if(tedTalksAdapter!=null){
            tedYouTubeArrayList.addAll(list);
            //showMessage("added"+tedYouTubeArrayList.size());
            tedTalksAdapter.notifyDataChanged();
            if(list.size()==20){
                //showMessage("setmoredata");
                tedTalksAdapter.setMoreDataAvailable(true);
            }
            else{
                //showMessage("not av");
                tedTalksAdapter.setMoreDataAvailable(false);
            }

            tedTalksAdapter.setLoadMoreListener(new TedTalksAdapter.OnLoadMoreListener(){

                @Override
                public void onLoadMore() {
                    tedRecyclerView.post(new Runnable() {
                        @Override
                        public void run() {
                           // showMessage("addmore loadmore");
                            index++;
                            presenter.loadMoreTed(index,moreTedListener);// a method which requests remote data
                        }
                    });

                }
            });

        }
    }

    public void setTedTalksRecyclerView(List<TedYouTube> tedVideos){
        tedRecyclerView.setHasFixedSize(true);
        tedYouTubeArrayList.clear();
        tedYouTubeArrayList.addAll(tedVideos);
        tedRecyclerView.removeAllViews();
        tedRecyclerView.setNestedScrollingEnabled(false);
        tedRecyclerView.removeAllViewsInLayout();
        StaggeredGridLayoutManager mStaggeredVerticalLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL); // (int spanCount, int orientation)
        tedRecyclerView.setLayoutManager(mStaggeredVerticalLayoutManager);
        tedTalksAdapter =
                new TedTalksAdapter(this,tedYouTubeArrayList);
        tedTalksAdapter.setLoadMoreListener(new TedTalksAdapter.OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                tedRecyclerView.post(new Runnable() {
                    @Override
                    public void run() {
                        if(tedYouTubeArrayList.size()==20) {
                            index++;
                            //showMessage("called here"+index);
                            presenter.loadMoreTed(index, moreTedListener);
                        }// a method which requests remote data
                    }
                });
            }
        });
        tedRecyclerView.setAdapter(tedTalksAdapter);
        tedRecyclerView.setLayoutManager(mStaggeredVerticalLayoutManager);

        tedTalksAdapter.notifyDataSetChanged();
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
