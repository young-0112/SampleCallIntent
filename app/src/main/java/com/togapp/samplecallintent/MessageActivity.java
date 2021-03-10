package com.togapp.samplecallintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);



        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();

                EditText emailText = findViewById(R.id.editTextTextEmailAddress);
                Log.v("email",emailText.getText().toString());

                intent.putExtra("email", emailText.getText().toString());
                intent.putExtra("aint", "1234");
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }
}