package com.mycompany.myfirstapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.mycompany.myfirstapp.R;
import com.mycompany.myfirstapp.entity.Person;
import com.mycompany.myfirstapp.entity.PersonDb;
import com.mycompany.myfirstapp.fragment.FragmentTest;
import com.mycompany.myfirstapp.utils.SlidingTabLayout;

import java.util.List;

/**
 * Created by Administrator on 2017/4/11.
 */

public class FragmentDynamicActivity extends AppCompatActivity{

    private static final String ACTIVITY_TAG="FragmentDynamicActivity";

    SlidingTabLayout mTab;
    ViewPager mViewPager;
    FragmentPagerAdapter mAdapter;


    protected  void onCreate(Bundle savedInstancsState){
        super.onCreate( savedInstancsState );
        setContentView( R.layout.fragment_activity_main);

        initView();
    }

    private void initView(){
        mTab = (SlidingTabLayout) findViewById( R.id.tab_fragment );
        mViewPager = (ViewPager)findViewById( R.id.viewpager_fragment );
        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            // titles作为滑动标题栏，动态添加数据进去就可以了
            List<Person> personList = PersonDb.getListPerson();
            @Override
            public Fragment getItem(int position) { // 开始动态添加fragment
                Person person =personList.get(position);
                FragmentTest fragment = new FragmentTest();
                Bundle bundle = new Bundle();
                bundle.putInt("position", position);
                bundle.putString("title", person.getName());
                bundle.putInt( "id" ,person.getId());
                bundle.putInt( "age" ,person.getAge());
                fragment.setArguments(bundle);
                return fragment;
            }

            @Override
            public int getCount() { // 添加fragment个数
                Log.v(FragmentDynamicActivity.ACTIVITY_TAG, "---------------------------");
                return personList.size();

            }

            @Override
            public CharSequence getPageTitle(int position) { // 添加fragment标题
                Person person =personList.get(position);
                return person.getName();
            }
        };
        mViewPager.setAdapter(mAdapter);

        mTab.setCustomTabView(R.layout.custom_tab, 0); // 添加头部xml，可自定义
        mTab.setSelectedIndicatorColors(0xffe8303d); // 下滑线的颜色
        mTab.setBackgroundColor(0xffffffff); // 头部背景颜色
        mTab.setViewPager(mViewPager);
    }

}
