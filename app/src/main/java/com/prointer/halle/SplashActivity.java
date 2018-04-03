package com.prointer.halle;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 1500;
    Animation animation;
    ImageView logoImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        logoImage = (ImageView) findViewById(R.id.img_logo_splash);
        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);

        logoImage.setAnimation(animation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent it = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(it);
                finish();
            }
        },SPLASH_TIME_OUT);

    }
}
