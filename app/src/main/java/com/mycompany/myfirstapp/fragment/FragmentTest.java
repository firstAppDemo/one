package com.mycompany.myfirstapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mycompany.myfirstapp.R;
import com.mycompany.myfirstapp.entity.UserInfo;
import com.mycompany.myfirstapp.entity.UserInfoDb;

import java.util.List;

/**
 * Created by Administrator on 2017/4/11.
 */

public class FragmentTest extends Fragment {

    private TextView tv;
    private TextView tvs;
    private TextView tv_hobby;
    private TextView tv_sex;
    private TextView tv_remark;
    private ImageView img;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = View.inflate( getActivity(), R.layout.fragment_tab,null);


        int id = getArguments().getInt( "id" );
        String name =getArguments().getString("title");
        int age = getArguments().getInt("age");

        //根据控件的ID得到响应的控件对象
        tv =(TextView) view.findViewById(R.id.tv_userinfo_name);
        tvs=(TextView) view.findViewById(R.id.tv_userinfo_age);
        //为控件设置Text值
        tv.setText(name);
        tvs.setText(Integer.toString(age));

        List<UserInfo> userList = UserInfoDb.getUserInfo();
        UserInfo user = userList.get(id);

        //根据控件的ID得到响应的控件对象
        tv_hobby =(TextView) view.findViewById(R.id.tv_userinfo_hobby);
        tv_remark=(TextView) view.findViewById(R.id.tv_userinfo_remark);
        tv_sex=(TextView) view.findViewById(R.id.tv_userinfo_sex);
        img=(ImageView) view.findViewById(R.id.im_userinfo_img);
        //为控件设置Text值
        tv_hobby.setText(user.getHobby());
        tv_remark.setText(user.getRemark());
        tv_sex.setText(user.getSex());
        img.setImageResource(user.getImg());
        return view;
    }
}
