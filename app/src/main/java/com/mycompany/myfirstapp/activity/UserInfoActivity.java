package com.mycompany.myfirstapp.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.mycompany.myfirstapp.R;
import com.mycompany.myfirstapp.entity.UserInfo;
import com.mycompany.myfirstapp.entity.UserInfoDb;

import java.util.List;

/**
 * Created by Administrator on 2017/3/31.
 */

public class UserInfoActivity extends Activity{

    private TextView tv;
    private TextView tvs;
    private TextView tv_hobby;
    private TextView tv_sex;
    private TextView tv_remark;
    private ImageView img;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.userinfo_details );
        //取得从上一个Activity当中传递过来的Bundle对象
        Bundle b=getIntent().getExtras();
        //获取Bundle的信息
        String name =b.getString("name");
        int age = b.getInt("age");
        int ids = b.getInt("id");
        //根据控件的ID得到响应的控件对象
        tv =(TextView) findViewById(R.id.tv_userinfo_name);
        tvs=(TextView)findViewById(R.id.tv_userinfo_age);
        //为控件设置Text值
        tv.setText(name);
        tvs.setText(Integer.toString(age));
        //根据id查询对应用户详情信息
        show(ids);
    }

    public void show(int ids){
        List<UserInfo> userList = UserInfoDb.getUserInfo();
        UserInfo user = userList.get(ids);

        //根据控件的ID得到响应的控件对象
        tv_hobby =(TextView) findViewById(R.id.tv_userinfo_hobby);
        tv_remark=(TextView) findViewById(R.id.tv_userinfo_remark);
        tv_sex=(TextView) findViewById(R.id.tv_userinfo_sex);
        img=(ImageView) findViewById(R.id.im_userinfo_img);
        //为控件设置Text值
        tv_hobby.setText(user.getHobby());
        tv_remark.setText(user.getRemark());
        tv_sex.setText(user.getSex());
        img.setImageResource(user.getImg());
    }

}
