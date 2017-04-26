package com.mycompany.myfirstapp.activity;

import android.app.Activity;
import android.os.Bundle;

import com.mycompany.myfirstapp.R;

/**
 * Created by Administrator on 2017/4/19.
 */

public class TestActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.test_time_date2 );
    }
}
