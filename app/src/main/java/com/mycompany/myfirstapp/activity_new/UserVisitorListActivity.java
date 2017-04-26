package com.mycompany.myfirstapp.activity_new;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.mycompany.myfirstapp.R;
import com.mycompany.myfirstapp.utils.UserInfoRepo;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Administrator on 2017/4/25.
 */

public class UserVisitorListActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.usersql_mains );

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_usersqls);
        toolbar.setTitle("用户列表");//设置主标题
        toolbar.inflateMenu(R.menu.menu_visit);//设置右上角的填充菜单
        show();
    }

    //listview
    public void show(){
        UserInfoRepo repo = new UserInfoRepo(this);
        ArrayList<HashMap<String, String>> userinfoList =  repo.getUserVisitorList();

        ListAdapter adapter = new SimpleAdapter(UserVisitorListActivity.this,userinfoList, R.layout.usersql_items, new String[] { "text5","username","department","phone","text3","text4","createTime"},
                new int[] {R.id.tv_users_random, R.id.tv_users_name,R.id.tv_users_dept,R.id.tv_users_phone,R.id.tv_users_text3,R.id.tv_users_text4,R.id.tv_users_createTime,});
        setListAdapter( adapter );
    }

}
