package com.mycompany.myfirstapp.activity_new;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.mycompany.myfirstapp.R;

/**
 * Created by Administrator on 2017/4/19.
 */

public class MainInterfaceActivity extends AppCompatActivity {

    private TextView tvUserList,tvVisitList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        setContentView( R.layout.main_interface );

    }

    public void jumpUserList(View view){
        Intent i = new Intent(MainInterfaceActivity.this,UserListSqlActivity.class);
        startActivity(i);
    }

    public void jumpVisitList(View view){
        //获取Bundle的信息
        Intent i = new Intent(MainInterfaceActivity.this,VisitorListActivity.class);
        startActivity(i);
    }



   @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_interface, menu);
        return true;
    }

    //选择菜单Menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_settings://新增用户
                Toast.makeText( this, "你点击了我", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.action_addUser://新增用户
                Toast.makeText( this, "你点击了我", Toast.LENGTH_SHORT )
                        .show();
                Intent i2 = new Intent(MainInterfaceActivity.this,UserVisitorListActivity.class);
                startActivity(i2);
                break;
            case R.id.action_addVisit://申请访客单
                Bundle b=getIntent().getExtras();
                //获取Bundle的信息
                String name2 =b.getString("name");
                Bundle b2 =new Bundle();
                b2.putString( "name",name2 );
                Intent i = new Intent(MainInterfaceActivity.this,VisitorAddActivity.class);
                i.putExtras(b);
                startActivity(i);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
