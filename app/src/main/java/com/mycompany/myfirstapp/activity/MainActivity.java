package com.mycompany.myfirstapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.mycompany.myfirstapp.R;
import com.mycompany.myfirstapp.activity_new.LoginSqlActivity;
import com.mycompany.myfirstapp.activity_new.RegisterSqlActivity;
import com.mycompany.myfirstapp.activity_new.UserListSqlActivity;
import com.mycompany.myfirstapp.activity_new.VisitorAddActivity;
import com.mycompany.myfirstapp.activity_new.VisitorDetailedActivity;
import com.mycompany.myfirstapp.activity_new.VisitorListActivity;
import com.mycompany.myfirstapp.datedialog.MainActivity3;
import com.mycompany.myfirstapp.test.MainActivity2;

public class MainActivity extends AppCompatActivity {
    //声明一个私有button
    private Button btn;

    private Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_main);

        //登录跳转
        login();
        //注册跳转
        register();
    }
    //登录
    public  void login(){
        //与布局文件的btn相关联
        btn=(Button) findViewById(R.id.btn_welcome_go);

        //给btn绑定事件
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent是一种运行时绑定（run-time binding）机制，它能在程序运行过程中连接两个不同的组件。
                //page1为先前已添加的类，并已在AndroidManifest.xml内添加活动事件
                // (<activity android:name="LoginActivity"></activity>),在存放资源代码的文件夹下下，
                Intent i = new Intent(MainActivity.this,LoginSqlActivity.class);
                //启动
                startActivity(i);
            }
        });
    }

    //注册
    public void register(){
        btn2= (Button) findViewById( R.id.btn_welcome_register );

        btn2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,RegisterSqlActivity.class);
                //启动
                startActivity(i);
            }
        } );
    }

    //创建菜单Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    //选择菜单Menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_settings:
                Toast.makeText( this, "你点击了我", Toast.LENGTH_SHORT )
                        .show();
                break;
            case R.id.action_go:
                Intent intent = new Intent(this,StudentMainActivity.class);
                startActivity(intent);
                break;
            case R.id.action_reg:
                Intent intent2 = new Intent(this,RegisterActivity.class);
                startActivity(intent2);
                break;
            case R.id.action_test:
                Intent intent3 = new Intent(this,LoginActivity.class);
                startActivity(intent3);
                break;
            case R.id.action_test2:
                Intent intent4 = new Intent(this,MainActivity3.class);
                startActivity(intent4);
                break;
            case R.id.action_test3:
                Toast.makeText( this, "你点击了我", Toast.LENGTH_SHORT )
                        .show();
                Intent intent5 = new Intent(this,VisitorDetailedActivity.class);
                startActivity(intent5);

                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart(){
        super.onStart();
        System.out.println("onStart");
    }

    @Override
    public void onResume(){
        super.onResume();
        System.out.println("onResume");
    }

    @Override
    public void onPause(){
        super.onPause();
        System.out.println("onPause");
    }

    @Override
    public void onStop(){
        super.onStop();
        System.out.println("onStop");
    }

    @Override
    public void onRestart(){
        super.onRestart();
        System.out.println("onRestart");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        System.out.println("onDestroy");
    }

}
