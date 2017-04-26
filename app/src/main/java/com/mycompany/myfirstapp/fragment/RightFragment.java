package com.mycompany.myfirstapp.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mycompany.myfirstapp.R;

/**
 * Created by Administrator on 2017/4/11.
 */

public class RightFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        System.out.println("RightFragment onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        System.out.println("RightFragment onCreateView");
        return inflater.inflate( R.layout.rightfragment, container, true);
    }

    @Override
    public void onResume()
    {
        super.onResume();
        System.out.println("RightFragment onResume");
    }

    @Override
    public void onPause()
    {
        super.onPause();
        System.out.println("RightFragment onPause");
    }

    @Override
    public void onStop()
    {
        super.onStop();
        System.out.println("RightFragment onStop");
    }
}
