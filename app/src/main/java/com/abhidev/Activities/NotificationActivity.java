package com.abhidev.Activities;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;


import com.abhidev.R;
import com.abhidev.adapters.NotificationRecyclerViewAdapter;
import com.abhidev.apiservices.Repository;
import com.abhidev.listeners.OnEntitiesReceivedListener;
import com.abhidev.models.Notification;
import com.abhidev.models.NotificationData;
import com.abhidev.presenters.NotificationPresenter;
import com.abhidev.viewactions.BaseViewAction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rishabh on 3/2/2018.
 */

public class NotificationActivity extends BaseActivity implements BaseViewAction{

    RecyclerView recyclerView;
    ArrayList<NotificationData> notificationDataArrayList;
    NotificationRecyclerViewAdapter notificationRecyclerViewAdapter;
    OnEntitiesReceivedListener<Notification> listener;
    NotificationPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notifications_layout);


        Toolbar toolbar = (Toolbar) findViewById(R.id.tool);
        //toolbar.setBackgroundColor(getResources().getColor(R.color.black));
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Notification");

        recyclerView=(RecyclerView)findViewById(R.id.recyclerView_notif);
        listener = new OnEntitiesReceivedListener<Notification>(this) {
            @Override
            public void onReceived(List<Notification> entities) {
                setNotificationRecyclerView(entities);
            }
        };
        presenter = new NotificationPresenter(new Repository());
        presenter.getNotifications(listener);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();


    }


    @Override
    public void showNetworkError(String message) {
        super.showNetworkError(message);
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

    public void setNotificationRecyclerView(List<Notification> notifications) {

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        notificationRecyclerViewAdapter=new NotificationRecyclerViewAdapter(getApplicationContext(),notifications);
        recyclerView.setAdapter(notificationRecyclerViewAdapter);

    }
}
