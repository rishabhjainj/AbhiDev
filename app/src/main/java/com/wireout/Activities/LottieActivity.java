package com.wireout.Activities;

import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;
import com.wireout.R;

public class LottieActivity extends AppCompatActivity {
    LottieAnimationView animationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottie);
        animationView = findViewById(R.id.animation_view);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
            setContentView(R.layout.activity_new_homepage);

            }
        }, 3000);
    }
}
