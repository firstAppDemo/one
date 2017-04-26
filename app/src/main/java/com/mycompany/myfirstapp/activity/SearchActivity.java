package com.mycompany.myfirstapp.activity;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.mycompany.myfirstapp.R;
import com.mycompany.myfirstapp.entity.Person;
import com.mycompany.myfirstapp.entity.PersonDb;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by lvxu on 2017/4/5.
 */

public class SearchActivity extends Activity {

    private ListView mListView;

    private EditText etSearch;

    private ImageView ivDeleteText;

     Handler myhandler = new Handler();

    private SimpleAdapter adapter;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.search_item );
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder( this ).addApi( AppIndex.API ).build();

        //添加EditText的文本改变的监听器
        set_eSearch_TextChanged();

        //点击图片改变状态
        set_ivDeleteText_OnClick();

        //利用mData创建Adapter
        set_mListView_adapter();

        //点击查看详情
        showInfo();
    }


    ArrayList<Map<String, Object>> mData = new ArrayList<Map<String, Object>>();


    //创建数据集mData
    private void getmData(ArrayList<Map<String, Object>> mDatas) {
        List<Person> list = PersonDb.getListPerson();
        //List<HashMap<String, Object>> data = new ArrayList<HashMap<String, Object>>();
        for (Person  person : list) {
            HashMap<String, Object> item = new HashMap<String, Object>();
            item.put("id",person.getId());
            item.put("name", person.getName());
            item.put("age", person.getAge());
            mDatas.add(item);
        }

    }

    //对mData里的数据进行更新
    Runnable eChanged = new Runnable() {

        @Override
        public void run() {
            // TODO Auto-generated method stub
            String data = etSearch.getText().toString();

            mData.clear();

            getmDataSub( mData, data );

            adapter.notifyDataSetChanged();

        }
    };
    /*准备数据*/
    private void getmDataSub(ArrayList<Map<String, Object>> mDataSubs, String data) {
        List<Person> list = PersonDb.getListPerson();
        int length = list.size();

            for (int i = 0; i < length; ++i) {
                if(list.get(i).getName().contains(data) ||String.valueOf( list.get(i).getAge() ).contains(data)  || String.valueOf( list.get(i).getId() ).contains(data)) {
                    Map<String, Object> item = new HashMap<String, Object>();
                    item.put( "id", list.get( i ).getId() );
                    item.put( "age", list.get( i ).getAge() );
                    item.put( "name", list.get( i ).getName() );
                    mDataSubs.add( item );

            }
        }
    }


    //利用mData创建Adapter
    private void set_mListView_adapter() {
        mListView = (ListView) findViewById( R.id.mListView );

        getmData( mData );

        //适配器
        adapter = new SimpleAdapter(this,mData,R.layout.person_item,
                new String[]{"id","name","age"},new int[]{R.id.id,R.id.name,R.id.age});
        mListView.setAdapter(adapter);
    }

    //添加EditText的文本改变的监听器
    private void set_eSearch_TextChanged() {
        etSearch = (EditText) findViewById( R.id.etSearch );

        etSearch.addTextChangedListener( new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                // TODO Auto-generated method stub
                //这个应该是在改变的时候会做的动作吧，具体还没用到过。
            }


            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                // TODO Auto-generated method stub
                //这是文本框改变之前会执行的动作
            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
                /**这是文本框改变之后 会执行的动作
                 * 因为我们要做的就是，在文本框改变的同时，我们的listview的数据也进行相应的变动，并且如一的显示在界面上。
                 * 所以这里我们就需要加上数据的修改的动作了。
                 */
                if (s.length() == 0) {
                    ivDeleteText.setVisibility( View.GONE );//当文本框为空时，则叉叉消失

                } else {
                    ivDeleteText.setVisibility( View.VISIBLE );//当文本框不为空时，出现叉叉
                    myhandler.post( eChanged );
                }
            }
        } );

    }
    private void set_ivDeleteText_OnClick()
    {
        ivDeleteText = (ImageView) findViewById(R.id.ivDeleteText);
        ivDeleteText.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                etSearch.setText("");
            }
        });
    }


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName( "Search Page" ) // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl( Uri.parse( "http://[ENTER-YOUR-URL-HERE]" ) )
                .build();
        return new Action.Builder( Action.TYPE_VIEW )
                .setObject( object )
                .setActionStatus( Action.STATUS_TYPE_COMPLETED )
                .build();
    }


    //点击item
    public void showInfo(){
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                switch (adapterView.getId())
                {
                    case R.id.mListView:
                        positionItemClick(position);//position 代表你点的哪一个
                        break;
                }
            }
        });
    }

    //获取当前item值，跳转下一个activity
    public void positionItemClick(int position){
        List<Person> personList = PersonDb.getListPerson();
        Person person =personList.get(position);
        //生成一个bundle对象
        Bundle bundle = new Bundle();
        //赋值
        bundle.putString("name", person.getName());
        bundle.putInt("age",person.getAge());
        bundle.putInt("id",person.getId());
        //生成一个Intent对象
        Intent intent = new Intent(SearchActivity.this, UserInfoActivity.class);
        //调用Intent的putExtras方法，将之前的bundle参数传进去
        intent.putExtras(bundle);

        startActivity(intent);
    }


    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start( client, getIndexApiAction() );
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end( client, getIndexApiAction() );
        client.disconnect();
    }
}
