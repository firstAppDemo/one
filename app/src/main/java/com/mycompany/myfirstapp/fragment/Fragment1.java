package com.mycompany.myfirstapp.fragment;


import android.app.Fragment;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mycompany.myfirstapp.R;

/**
 * Created by Administrator on 2017/4/10.
 */

public class Fragment1 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // 将layout布局文件转换成View对象
        /**inflate方法的参数
         * resource：Fragment需要加载的布局文件
         * root：加载layout的父ViewGroup
         *( attachToRoot：false表示不返回父ViewGroup)
         */

        return inflater.inflate(R.layout.fragment1,null);
    }

}
