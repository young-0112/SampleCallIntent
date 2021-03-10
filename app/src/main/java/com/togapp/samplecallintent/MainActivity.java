package com.togapp.samplecallintent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    //public static final int REQUEST_CODE_MESSAGE = 301;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);     // view 객체 참조

        editText = findViewById(R.id.editText);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = editText.getText().toString();    // 입력상자에 입력된 전화번호 확인

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(data));    // 전화걸기 화면 보여줄 인텐트 객체 생성
                startActivity(intent);  // 액티비티 띄우기
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                // 컴포넌트 이름을 지정할 수 있는 객체 생성
                ComponentName componentName = new ComponentName("com.togapp.samplecallintent", "com.togapp.samplecallintent.MenuActivity");
                intent.setComponent(componentName);
                startActivityForResult(intent, 201);    // 액티비티 띄우기
            }
        });

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getApplicationContext(), MessageActivity.class);
                //startActivityForResult(intent, REQUEST_CODE_MESSAGE);

                Intent intent = new Intent();
                ComponentName componentName = new ComponentName("com.togapp.samplecallintent","com.togapp.samplecallintent.MessageActivity");
                intent.setComponent(componentName);
                startActivityForResult(intent, 301);

            }
        });

    }   // onCreate end

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 301){
            Toast.makeText(getApplicationContext(), "onActivityResult 메서드 호출됨. 요청코드 : " +
                    requestCode + "결과 코드 : " + requestCode, Toast.LENGTH_SHORT).show();

            if (resultCode == RESULT_OK){
                TextView emailText = findViewById(R.id.textView2);
                String em = data.getStringExtra("email");
                if (em != null)
                emailText.setText(em);
                Toast.makeText(getApplicationContext(),"응답으로 em :" + em, Toast.LENGTH_LONG).show();
            }
        };


    }   // onActivityResult end


}