package com.guswls9281.a20220713_multiple2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class Welcome2Activity extends AppCompatActivity {
    TextView txt;
    TextView txtSp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome2);

        // 넘겨받은 데이터 처리
        String email = getIntent().getStringExtra("email");

        // 화면과 연결
        txt = findViewById(R.id.txt);
        txtSp = findViewById(R.id.txtSP);

        // 데이터를 화면에 셋팅
        txt.setText(email+"님, 안녕하세요");

        // 쉐어드 프리퍼런스에서 데이터를 가져오는 방법
        SharedPreferences sp = getSharedPreferences("Multiple2",MODE_PRIVATE);
        String savedEmail = sp.getString("email","없음");

        txtSp.setText("저장되었던 이메일은: " + savedEmail);

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}