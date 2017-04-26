package com.mycompany.myfirstapp.activity_new;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mycompany.myfirstapp.R;
import com.mycompany.myfirstapp.entity.UserInfo;
import com.mycompany.myfirstapp.utils.UserInfoRepo;

/**
 * Created by Administrator on 2017/4/14.
 */

public class UserInfoSqlActivity extends ActionBarActivity implements View.OnClickListener{

    private TextView tv_name;
    private TextView tv_age;
    private TextView tv_hobby;
    private TextView tv_sex;
    private TextView tv_remark;
    private ImageView img;
    private Button btnDel,btnCloss,btnUpp;
    private int userinfo_id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.userinfo_details );

        //根据控件的ID得到响应的控件对象
        tv_name =(TextView) findViewById(R.id.tv_userinfo_name);
        tv_age=(TextView)findViewById(R.id.tv_userinfo_age);
        tv_hobby =(TextView) findViewById(R.id.tv_userinfo_hobby);
        tv_remark=(TextView) findViewById(R.id.tv_userinfo_remark);
        tv_sex=(TextView) findViewById(R.id.tv_userinfo_sex);
        img=(ImageView) findViewById(R.id.im_userinfo_img);

        Intent intent = getIntent();
        userinfo_id =intent.getIntExtra("ids", 0);

        btnDel =(Button) findViewById( R.id.btn_usersql_del );
        btnDel.setOnClickListener(this);
        btnCloss =(Button) findViewById( R.id.btn_usersql_closs );
        btnCloss.setOnClickListener(this);
        btnUpp =(Button) findViewById( R.id.btn_usersql_upp );
        btnUpp.setOnClickListener(this);

        show(userinfo_id);
    }

    public  void show(int ids){
        UserInfoRepo repo = new UserInfoRepo( this );
        UserInfo user = repo.getUserInfoById(  ids );

        //为控件设置Text值
        tv_age.setText(String.valueOf(  user.getAge() ) );
        tv_name.setText( user.getUsername() );
        tv_hobby.setText(user.getHobby());
        tv_remark.setText(user.getRemark());
        tv_sex.setText(user.getSex());
        img.setImageResource(user.getImg());
    }

    //创建菜单Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_user_sql, menu);
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
            case R.id.action_update:
                Toast.makeText( this, "你点击了我", Toast.LENGTH_SHORT )
                        .show();
                break;

            case R.id.action_del:
                Toast.makeText( this, "你点击了我", Toast.LENGTH_SHORT )
                        .show();
                break;

            case R.id.action_jump:
                Toast.makeText( this, "你点击了我", Toast.LENGTH_SHORT )
                        .show();
                break;

        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_usersql_del:
                UserInfoRepo repo = new UserInfoRepo( this );
                repo.delete( userinfo_id );
                Toast.makeText(getApplicationContext(), "\"UserInfoRepo Record Deleted", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(UserInfoSqlActivity.this,UserListSqlActivity.class);
                startActivity(i);
                break;
            case R.id.btn_usersql_closs:
                finish();
                break;
            case R.id.btn_usersql_upp:
                UserInfoRepo repos = new UserInfoRepo( this );
                UserInfo user = repos.getUserInfoById(  userinfo_id );

                String name = tv_name.getText().toString();
                String age =tv_age.getText().toString();
                String hobby = tv_hobby.getText() .toString();
                String sex = tv_sex.getText().toString();
                Bundle bundle = new Bundle();
                //赋值
                bundle.putString("age", age);
                bundle.putString("hobby", hobby);
                bundle.putString("sex", sex);
                bundle.putString("psd", user.getPsd());
                bundle.putString("createtime", user.getCreateTime());
                bundle.putString( "name" ,name );


                bundle.putInt( "userid",userinfo_id );
                Intent i2 = new Intent(UserInfoSqlActivity.this,UserUpdateActivity.class);
                i2.putExtras( bundle );
                startActivity(i2);
                break;
        }

    }
}
