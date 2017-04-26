package com.mycompany.myfirstapp.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.mycompany.myfirstapp.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/5.
 */

public class SearchActivity2 extends ActionBarActivity {
    EditText eSearch;
    ImageView ivDeleteText;
    ListView mListView;

    ArrayList<Map<String, Object>> mData = new ArrayList<Map<String, Object>>();

    ArrayList<String> mListTitle = new ArrayList<String>();
    ArrayList<String> mListText = new ArrayList<String>();

    SimpleAdapter adapter;

    Handler myhandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.search_item );

        set_eSearch_TextChanged();

        set_ivDeleteText_OnClick();

        set_mListView_adapter();

    }
    //利用mData创建Adapter
    private void set_mListView_adapter()
    {
        mListView = (ListView) findViewById(R.id.mListView);

        getmData(mData);

        adapter = new SimpleAdapter(this,mData,android.R.layout.simple_list_item_2,
                new String[]{"title","text"},new int[]{android.R.id.text1,android.R.id.text2});

        mListView.setAdapter(adapter);
    }

    //添加EditText的文本改变的监听器
    private void set_eSearch_TextChanged()
    {
        eSearch = (EditText) findViewById(R.id.etSearch);

        eSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                // TODO Auto-generated method stub
            }
            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                // TODO Auto-generated method stub
            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
                /**这是文本框改变之后 会执行的动作
                 * 因为我们要做的就是，在文本框改变的同时，我们的listview的数据也进行相应的变动，并且如一的显示在界面上。
                 * 所以这里我们就需要加上数据的修改的动作了。
                 */
                if(s.length() == 0){
                    ivDeleteText.setVisibility(View.GONE);//当文本框为空时，则叉叉消失
                }
                else {
                    ivDeleteText.setVisibility( View.VISIBLE);//当文本框不为空时，出现叉叉
                }

                myhandler.post(eChanged);
            }
        });

    }
    Runnable eChanged = new Runnable() {

        @Override
        public void run() {
            // TODO Auto-generated method stub
            String data = eSearch.getText().toString();

            mData.clear();

            getmDataSub(mData, data);

            adapter.notifyDataSetChanged();

        }
    };



    private void getmDataSub(ArrayList<Map<String, Object>> mDataSubs, String data)
    {
        int length = mListTitle.size();
        for(int i = 0; i < length; ++i){
            if(mListTitle.get(i).contains(data) || mListText.get(i).contains(data)){
                Map<String,Object> item = new HashMap<String,Object>();
                item.put("title", mListTitle.get(i));
                item.put("text",  mListText.get(i));
                mDataSubs.add(item);
            }
        }
    }


    private void set_ivDeleteText_OnClick()
    {
        ivDeleteText = (ImageView) findViewById(R.id.ivDeleteText);
        ivDeleteText.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                eSearch.setText("");
            }
        });
    }

    /**
     * ���Ԫ���� ����ʼ��mDatas
     * @param mDatas
     */

    private void getmData(ArrayList<Map<String, Object>> mDatas)
    {
        Map<String, Object> item = new HashMap<String, Object>();
        mListTitle.add("����һ������!");
        mListText.add("�����ı�.\n2014.09.18.19.50");

        item.put("title", mListTitle.get(0));
        item.put("text", mListText.get(0));
        mDatas.add(item);


        mListTitle.add("������һ������!");
        mListText.add("������һ���ı�.\n2014.09.18.19.51");

        item = new HashMap<String, Object>();
        item.put("title", mListTitle.get(1));
        item.put("text", mListText.get(1));
        mDatas.add(item);
    }
}
