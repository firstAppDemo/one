package com.mycompany.myfirstapp.activity_new;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.mycompany.myfirstapp.R;
import com.mycompany.myfirstapp.utils.UserInfoRepo;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Administrator on 2017/4/13.
 */

public class UserListSqlActivity extends ListActivity implements android.view.View.OnClickListener{

    private final String USER_INFO = "UserListSqlActivity";

    private TextView tvName,tvSex,tvHobby,tvId,tvImg,tvAge;

    private Button btnDel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.usersql_main );

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_usersql);
       /* toolbar.setNavigationIcon(R.mipmap.back);//设置导航栏图标
        toolbar.setLogo(R.mipmap.quantou);//设置app logo*/
        toolbar.setTitle("用户列表");//设置主标题
        toolbar.inflateMenu(R.menu.menu_visit);//设置右上角的填充菜单
        show();
    }

    //listview
    public void show(){
        UserInfoRepo repo = new UserInfoRepo(this);
        ArrayList<HashMap<String, String>> userinfoList =  repo.getUserInfoList();

        ListView lv = getListView();
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tvId = (TextView) view.findViewById(R.id.tv_item_id);
                String userinfoId = tvId.getText().toString();
                Intent objIndent = new Intent(getApplicationContext(),UserInfoSqlActivity.class);
                objIndent.putExtra("ids", Integer.parseInt( userinfoId));
                startActivity(objIndent);
            }
        });
        ListAdapter adapter = new SimpleAdapter(UserListSqlActivity.this,userinfoList, R.layout.usersql_item, new String[] { "ids","username","hobby","sex","age","img","remark"},
                new int[] {R.id.tv_item_id, R.id.tv_item_name,R.id.tv_item_hobby,R.id.tv_item_sex,R.id.tv_item_age,R.id.img_item_img,R.id.tv_item_remark,});
       setListAdapter( adapter );
    }




    @Override
    public void onClick(View view) {
      /*  if (view == findViewById( R.id.btn_item_del )) {
            tvId = (TextView) view.findViewById( R.id.tv_item_id );
            String userinfoId = tvId.getText().toString();
           *//* UserInfoRepo repo = new UserInfoRepo( this );
            repo.delete( Integer.valueOf( userinfoId ) );*//*
            Log.d(USER_INFO,"UserInfo=--------------"+userinfoId);
            Toast.makeText( this, "UserInfo Record Deleted =----"+userinfoId, Toast.LENGTH_SHORT );
            finish();
        }*/
    }
}
