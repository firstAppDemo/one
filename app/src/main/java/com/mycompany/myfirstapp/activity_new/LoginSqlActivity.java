package com.mycompany.myfirstapp.activity_new;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mycompany.myfirstapp.R;
import com.mycompany.myfirstapp.utils.DBHelperUserInfo;
import com.mycompany.myfirstapp.utils.UserInfoRepo;

/**
 * Created by Administrator on 2017/4/14.
 */

public class LoginSqlActivity extends AppCompatActivity {

    private DBHelperUserInfo dbHelper;
    private EditText username;
    private EditText passwordEt;
    private Button login;
    private TextView attempts;


    int counter = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.user_login );

        username = (EditText) findViewById(R.id.et_login_username);
        passwordEt = (EditText) findViewById(R.id.et_login_password);
        login = (Button) findViewById(R.id.btn_login2);
        attempts = (TextView) findViewById(R.id.tv_attempts);
        attempts.setText(Integer.toString(counter));
    }

    public void login(View view) {
        UserInfoRepo repo = new UserInfoRepo( this );
        String name = username.getText().toString();
        String password = passwordEt.getText().toString();

        if (name.equals("") || password.equals("") || repo.isUserinfo(name,password) ==false){
            // 弹出消息框
            new AlertDialog.Builder(LoginSqlActivity.this).setTitle("错误")
                    .setMessage("账号密码不正确请重新填写").setPositiveButton("确定", null)
                    .show();
            counter--;
            Toast.makeText(getApplicationContext(), "账号密码不正确，"+"你还有 "+counter+"次机会",
                    Toast.LENGTH_SHORT).show();
            attempts.setBackgroundColor( Color.RED);
            attempts.setText(Integer.toString(counter));
            if (counter == 0) {
                login.setEnabled(false);
            }
        }else if (repo.isUserinfo(name,password) ==true){
            Toast.makeText(getApplicationContext(), "正在登录，请稍等......登录", Toast.LENGTH_SHORT).show();
            //生成一个bundle对象
            Bundle bundle = new Bundle();
            //赋值
            bundle.putString("name", name);
            Intent i = new Intent(LoginSqlActivity.this,MainInterfaceActivity.class);
            i.putExtras(bundle);
            startActivity(i);
        }else {
            new AlertDialog.Builder(LoginSqlActivity.this).setTitle("错误")
                    .setMessage("未知错误哟").setPositiveButton("确定", null)
                    .show();
        }
    }

}
