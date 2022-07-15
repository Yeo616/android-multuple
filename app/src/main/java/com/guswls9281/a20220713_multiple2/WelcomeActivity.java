package com.guswls9281.a20220713_multiple2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class WelcomeActivity extends AppCompatActivity {

    ImageView imgChange;
    Button btnRabbit;
    Button btnTurtle;
    Button btnSave;

    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        imgChange = findViewById(R.id.imgChange);
        btnSave = findViewById(R.id.btnSave);
        btnRabbit = findViewById(R.id.btn1);
        btnTurtle = findViewById(R.id.btn2);

        // 데이터를 가져온다.
        email = getIntent().getStringExtra("email");

        btnRabbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 토끼 이미지를 셋팅한다.
                imgChange.setImageResource(R.drawable.rabbit);
            }
        });

        btnTurtle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 거북이 이미지를 셋팅한다.
                imgChange.setImageResource(R.drawable.tultle);
            }
        });


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 알러트 다이얼로그 띄운다.

                AlertDialog.Builder alert = new AlertDialog.Builder(WelcomeActivity.this);
                alert.setTitle("회원가입 완료!");
                alert.setMessage("완료 하시겠습니까???");
                alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // 새로운 액티비티를 띄운다.
                        Intent intent = new Intent(WelcomeActivity.this, Welcome2Activity.class);

                        intent.putExtra("email",email);

                        startActivity(intent);

                        // 현재의 액티비티를 종료
                        finish();
                    }
                });
                alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // 현재 이 액티비티를 종료시키는 코드
                        finish();
                    }
                });
                alert.show();

            }
    });
}}