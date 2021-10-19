package com.example.activitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {
    private static final String TAG = "SecondActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        String title = getIntent().getStringExtra("data");
        Button button = findViewById(R.id.button10);
        button.setText(title);

        Button back = findViewById(R.id.button2);
        Button toThird = findViewById(R.id.button4);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "onClick");
                finish();

            }
        });
        toThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "onClick");
                Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
                startActivity(intent);
            }
        });

        Button btnSum = findViewById(R.id.sum);
        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = getIntent().getIntExtra("data1", 0);
                int b = getIntent().getIntExtra("data2", 0);
                Log.i(TAG, "a=" + a);
                Log.i(TAG, "b=" + b);
                int sum = a + b;
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("sum", sum);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}