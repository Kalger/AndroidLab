package com.lab.transitionsandanimations;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Slide;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView yellowBlock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView redBlock = findViewById(R.id.redBlock);
        ImageView blueBlock = findViewById(R.id.blueBlock);
        yellowBlock = findViewById(R.id.yellowBlock);

        redBlock.setOnClickListener(this);
        blueBlock.setOnClickListener(this);
        yellowBlock.setOnClickListener(this);

        String transitionType = getIntent().getStringExtra("transitionType");
        if(transitionType != null){
            switch (transitionType){
                case "Explode":
                    getWindow().setEnterTransition(new Explode());
                    break;
                case "Fade":
                    getWindow().setEnterTransition(new Slide());
            }
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, SecondActivity.class);
        switch (v.getId()){
            case R.id.yellowBlock:
                ObjectAnimator animator = ObjectAnimator.ofFloat(yellowBlock, View.ROTATION, 0, 360);
                animator.setDuration(1000);
                animator.setRepeatMode(ValueAnimator.REVERSE);
                animator.setRepeatCount(1);
                animator.start();
                break;
            case R.id.redBlock:
                getWindow().setExitTransition(new Explode());
                intent.putExtra("transitionType", "Explode");
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                break;
            case R.id.blueBlock:
                getWindow().setExitTransition(new Slide());
                intent.putExtra("transitionType", "Fade");
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                break;
        }

    }
}
