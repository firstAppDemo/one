package com.mycompany.myfirstapp.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
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

/**
 * Created by Administrator on 2017/3/31.
 */

public class HelloWorldActivity extends Activity {

    private ListView myListView;
    private Button searchView;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.person_main );


        myListView = (ListView) findViewById(R.id.list_list);
        myListView.setTextFilterEnabled(true);
        //searchView = (SearchView) findViewById(R.id.searchView);
        //searchView.setOnQueryTextListener(this);
        //展示listview
        show();
        //跳转到详情页面
        showInfo();
        //跳转到搜索页面
        search();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

    }

   public void search(){
        searchView = (Button) findViewById( R.id.btn_search );
        searchView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HelloWorldActivity.this,SearchActivity.class);
                //启动
                startActivity(i);
            }
        } );

    }

    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    private void show() {
        List<Person> list = PersonDb.getListPerson();
        List<HashMap<String, Object>> data = new ArrayList<HashMap<String, Object>>();
        for (Person  person : list) {
            HashMap<String, Object> item = new HashMap<String, Object>();
            item.put("id",person.getId());
            item.put("name", person.getName());
            item.put("age", person.getAge());
            data.add(item);

        }

        //适配器
        SimpleAdapter adapter = new SimpleAdapter(this,data,R.layout.person_item,
                new String[]{"id","name","age"},new int[]{R.id.id,R.id.name,R.id.age});
        myListView.setAdapter(adapter);


        //为查询文本框注册监听器

    }

    //点击item
    public void showInfo(){
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                switch (adapterView.getId())
                {
                    case R.id.list_list:
                        positionItemClick(position);//position 代表你点的哪一个
                        break;
                }
            }
        });
    }
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
        Intent intent = new Intent(HelloWorldActivity.this, UserInfoActivity.class);
        //调用Intent的putExtras方法，将之前的bundle参数传进去
        intent.putExtras(bundle);

        startActivity(intent);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_list_jump:
               goFragment( view );
                break;
        }
    }

    public void goFragment(View view){
        Intent intent = new Intent();
        intent.setClass(HelloWorldActivity.this, FragmentDynamicActivity.class);
        startActivity(intent);
    }
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("HelloWorld Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
