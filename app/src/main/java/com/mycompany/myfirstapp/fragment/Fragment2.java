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

public class Fragment2 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle){
        return inflater.inflate( R.layout.fragment2,null );
    }
}
