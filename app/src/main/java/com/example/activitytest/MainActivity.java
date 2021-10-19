package com.example.activitytest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {//AppCompatActivity
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.button);
        EditText editText1 = findViewById(R.id.editTextTextPersonName);
        EditText editText2 = findViewById(R.id.editTextTextPersonName2);




        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               int a = Integer.parseInt(editText1.getText().toString());
                int b = Integer.parseInt(editText2.getText().toString());
                Log.i(TAG, "onClick");
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("data", "First로부터");
                intent.putExtra("data1", a);
                intent.putExtra("data2", b);
                //startActivity(intent);
                startActivityForResult(intent, 0);
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            if (requestCode == RESULT_OK) {
                int result = data.getIntExtra("sum", 0);

            }
        }
    }

}