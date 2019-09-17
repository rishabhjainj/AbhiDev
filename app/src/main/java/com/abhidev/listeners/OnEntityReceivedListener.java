package com.abhidev.listeners;

import android.content.Context;
import android.widget.Toast;

import com.abhidev.viewactions.BaseViewAction;

public abstract class OnEntityReceivedListener<T> implements BaseViewAction {

    Context context;

    public OnEntityReceivedListener(Context context) { this.context = context; }

    public abstract void onReceived(T entity);

    @Override
    public void showMessage(String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showNetworkError(String message){
        showMessage(message);
    }
}
