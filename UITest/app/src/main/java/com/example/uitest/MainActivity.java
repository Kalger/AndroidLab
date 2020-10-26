package com.example.uitest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    int num = 0;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        textView.setText(String.valueOf(num));
    }

    public  void onAdd(View v){
        textView.setText(String.valueOf(++num));
    }

    public  void onMinus(View v){
        textView.setText(String.valueOf(--num));
    }
}
