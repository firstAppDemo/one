package com.mycompany.myfirstapp.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2017/4/10.
 */

public class MyFragment extends Fragment {

    private int content_layout;

    public MyFragment(int content) {
        this.content_layout = content;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(content_layout,container,false);
        return view;
    }
}
