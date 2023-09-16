package com.base.activityresultlauncher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        int number2 =  getIntent().getIntExtra("number2",0);
        Button btnSendDataBck = findViewById(R.id.btnSendDataBck);

        btnSendDataBck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();

                intent.putExtra("2X2", number2*2);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}