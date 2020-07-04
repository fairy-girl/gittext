package com.example.myshopping.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myshopping.R;

public class LoginActivity extends AppCompatActivity {

    private SharedPreferences preferences;
    private String username;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //当用户打开时候，获取之前文件里的用户和密码

        //用户名和密码正确，记住密码
        //第一个参数：记住信息保存到哪个文件
        //第二个参数：保存模式
        preferences = getSharedPreferences("login",MODE_PRIVATE);
        username=preferences.getString("username","");
        password=preferences.getString("password","");
        if (username.equals("abc") && password.equals("123")){
            Intent intent=new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }

        //找到用户名和密码输入框控件对象
        final EditText usernameET=findViewById(R.id.usernameET);
        final EditText passwordET=findViewById(R.id.passwordET);

        Button loginBtn=findViewById(R.id.btn_login);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = usernameET.getText().toString();
                password = passwordET.getText().toString();
                //判断用户名和密码的字符串相等
                if (TextUtils.isEmpty(username)){
                    Toast.makeText(LoginActivity.this, "用户名不能为空！", Toast.LENGTH_SHORT).show();
                }else if (TextUtils.isEmpty(password)){
                    Toast.makeText(LoginActivity.this, "密码不能为空！", Toast.LENGTH_SHORT).show();
                }else if (username.equals("abc")&& password.equals("123")){

                    //往文件中保存的用户名和密码
                    SharedPreferences.Editor editor= preferences.edit();
                    editor.putString("username", username);
                    editor.putString("password", password);
                    editor.apply();
                    //用户名和密码正确，实现页面跳转
                    Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(LoginActivity.this, "用户名或密码错误！", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
