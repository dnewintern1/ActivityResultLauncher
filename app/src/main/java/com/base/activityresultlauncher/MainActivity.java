package com.base.activityresultlauncher;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_send_data = findViewById(R.id.btn_send_data);
        btn_send_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSecondActivity();
            }
        });
    }

        private void openSecondActivity() {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("number2", 2);
            MainActivity2resultLauncher.launch(intent);
        }



        ActivityResultLauncher<Intent> MainActivity2resultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {

                        if(result.getResultCode()== Activity.RESULT_OK){

                            Intent data = result.getData();

                            int operationResult = data.getIntExtra("2X2",0);

                                    Toast.makeText(this, operationResult + "", Toast.LENGTH_LONG).show();



                        }

                }
        );






}