package com.wireout.Activities;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.Toast;

import com.wireout.common.PrefManager;

import com.wireout.viewactions.BaseViewAction;

/**
 * Created by Rishabh on 2/8/2018.
 */

public class BaseActivity extends AppCompatActivity implements BaseViewAction{


    private static BaseActivity mInstance;
    public PrefManager prefManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        prefManager = new PrefManager(this);
        mInstance = this;
        //Fresco.initialize(this);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }

//    @Override
//    protected void attachBaseContext(Context newBase) {
//
//        if (android.os.Build.VERSION.SDK_INT>19) {
//            super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
//
//        }
//        else{
//            super.attachBaseContext(newBase);
//        }
//
//
//    }

    public static synchronized BaseActivity getInstance() {
        return mInstance;
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showNetworkError(String message) {
        showMessage(message);
    }
}
