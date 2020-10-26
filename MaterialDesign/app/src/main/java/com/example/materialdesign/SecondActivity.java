package com.example.materialdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Path;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.PathInterpolator;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        View block = findViewById(R.id.firstBlock);
        View secBlock = findViewById(R.id.secBlock);

        Path path = new Path();
        PathInterpolator pathInterpolator = new PathInterpolator(0.4f, 0.1f, 0.1f,0.8f);
        path.moveTo(200,200);
        path.lineTo(800f, 1000f);
        ObjectAnimator animator = ObjectAnimator.ofFloat(block, View.X, View.Y, path);
        animator.setInterpolator(pathInterpolator);
        animator.setDuration(2000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.start();

        Path path2 = new Path();
        path2.arcTo(100f, 1100, 800f, 1400f, 0f, 270f, true);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(secBlock, View.X, View.Y, path2);
        animator2.setRepeatCount(ValueAnimator.INFINITE);
        animator2.setDuration(2000);
        animator2.start();
    }
}
