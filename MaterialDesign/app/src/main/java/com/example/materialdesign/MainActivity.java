package com.example.materialdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button showBtn = findViewById(R.id.show);
        Button hideBtn = findViewById(R.id.hide);
        Button curBtn = findViewById(R.id.curveBtn);
        showBtn.setOnClickListener(this);
        hideBtn.setOnClickListener(this);
        curBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.show:
                cirReveal(true);
                break;
            case R.id.hide:
                cirReveal(false);
                break;
            case R.id.curveBtn:
                startActivity(new Intent(this, SecondActivity.class));
        }
    }

    private void cirReveal(boolean show) {
        final ImageView imageView = findViewById(R.id.imageView);
        // Get the center for the clipping circle.
        int cx = imageView.getWidth() / 2;
        int cy = imageView.getHeight() / 2;

        // Get the max radius for the clipping circle
        float maxRadius = (float) Math.hypot(cx, cy);
        Animator anim;

        if(show){
            // Create the animator for this view (the start radius is zero).
            anim = ViewAnimationUtils
                    .createCircularReveal(imageView, cx, cy, 0, maxRadius);
            // Make the view visible and start the animation.
            imageView.setVisibility(View.VISIBLE);
        }else {
            anim  = ViewAnimationUtils.createCircularReveal(imageView, cx, cy, maxRadius, 0);
            anim.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    imageView.setVisibility(View.INVISIBLE);
                }
            });
        }
        anim.start();
    }
}

