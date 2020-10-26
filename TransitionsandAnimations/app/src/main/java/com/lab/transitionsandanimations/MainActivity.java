package com.lab.transitionsandanimations;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.util.Pair;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView yellowBlock;
    private ImageView androidBlock;
    boolean firstContentView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getIntent().hasExtra("contentView")) {
            if (Objects.equals(getIntent().getStringExtra("contentView"), "second")) {
                firstContentView = false;
                setContentView(R.layout.activity_second);
            } else {
                firstContentView = true;
                setContentView(R.layout.activity_main);
            }
        }else {
            firstContentView = true;
            setContentView(R.layout.activity_main);
        }

        ImageView redBlock = findViewById(R.id.redBlock);
        ImageView blueBlock = findViewById(R.id.blueBlock);
        yellowBlock = findViewById(R.id.yellowBlock);
        androidBlock = findViewById(R.id.androidBlock);

        redBlock.setOnClickListener(this);
        blueBlock.setOnClickListener(this);
        yellowBlock.setOnClickListener(this);
        androidBlock.setOnClickListener(this);

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
        Intent intent = new Intent(this, MainActivity.class);
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
            case R.id.androidBlock:
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, Pair.create((View)yellowBlock,
                        "transition_yellow"), Pair.create((View)androidBlock, "transition_android"));
                if(firstContentView)
                    intent.putExtra("contentView", "second");
                else
                    intent.putExtra("contentView", "first");
                startActivity(intent, options.toBundle());
        }
    }
}
