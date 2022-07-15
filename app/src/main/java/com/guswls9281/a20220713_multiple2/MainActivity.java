package com.guswls9281.a20220713_multiple2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText editEmail;
    EditText editPasswd1;
    EditText editPasswd2;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editEmail = findViewById(R.id.editEmail);
        editPasswd1 = findViewById(R.id.editPasswd1);
        editPasswd2 = findViewById(R.id.editPasswd2);
        btnRegister = findViewById(R.id.btnRegister);

        String email = editEmail.getText().toString().trim();

        // 1. 버튼을 누르면 다음 페이지로 이동
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 1.이메일 형식 체크.

                String email = editEmail.getText().toString().trim();
                Pattern pattern = Patterns.EMAIL_ADDRESS;


                // 1-1. 유저가 아무것도 입력 안했거나, 이메일 형식이 틀리면,
                // 유저한테 이메일 제대로 입력해 주세요. 알려준다.
                if(email.isEmpty() || pattern.matcher(email).matches() == false){
                    //이메일 맞음!
                    Toast.makeText(getApplicationContext(),"이메일을 제대로 입력해주십시오",Toast.LENGTH_SHORT).show();
                    return;
                }

                // 2. 비밀번호를 체크한다.
                // 비밀번호의 길이가 6자리 이상, 12자리 이하인지 체크한다.
                // 비밀번호가 서로 같은지 체크한다.
                String password1 = editPasswd1.getText().toString().trim();
                String password2 = editPasswd2.getText().toString().trim();

                if(password1.length()<6 || password1.length() >12){
                    Toast.makeText(MainActivity.this,"비밀번호 길이는 6~12자리",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(!password1.equals(password2)){
                    Toast.makeText(MainActivity.this,"비번이 맞지 않음",Toast.LENGTH_SHORT).show();
                    return;
                }

                // SharedPreferences를 이용해서, 앱 내의 저장소에 영구 저장하는 방법!!
                // 앱을 삭제하기 전까지는 영구적으로 저장됩니다.
                // 단, 앱을 삭제하면 당연히 같이 삭제됩니다.
                SharedPreferences sp = getSharedPreferences("Multiple2",MODE_PRIVATE); // 저장소이름(보통은 프로젝트 이름), 모드
                // 내 앱 저장소를 만들었다.

                SharedPreferences.Editor editor = sp.edit();
                // 이 editor한테 작업을 하면 된다.

                editor.putString("email",email);
                editor.putInt("number",365);
                editor.apply(); //저장한다는 뜻

                // 정상적으로 수행됐을 경우, 새로운 액티비티를 실행한다.

                // 다음 페이지로 이동
                Intent intent = new Intent(MainActivity.this,WelcomeActivity.class);

                intent.putExtra("email",email);

                startActivity(intent);

                // 이 액티비티는, 위의 새로운 액티비티를 실행시키고 나서,
                finish();

            }
        });




    }
}