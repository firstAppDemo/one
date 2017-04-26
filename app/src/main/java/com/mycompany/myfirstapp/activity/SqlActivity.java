package com.mycompany.myfirstapp.activity;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.mycompany.myfirstapp.entity.Person;


/**
 * Created by Administrator on 2017/4/12.
 */

public class SqlActivity extends Activity{

    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate( savedInstanceState );

        //打开或创建数据库
        SQLiteDatabase db = openOrCreateDatabase( "test.db", Context.MODE_PRIVATE, null);
        //如果person表存在，那么就删除person表
        db.execSQL( "DROP TABLE IF EXISTS person" );
        //创建person表
        db.execSQL( "CREATE TABLE person (_id INTEGER PRIMARY KEY AUTOINCREMENT,name VARCHAR,age SMALLINT)" );

        Person person = new Person();
        person.name = "琳琅天上";
        person.age= 12;
        //插入数据
        db.execSQL( "INSERT INTO person VALUES(NULL,?,?)",new  Object[]{person.name,person.age});

        person.name = "天美";
        person.age= 13;
        //ContentValues以键值对的形式存放数据
        ContentValues cv = new ContentValues();
        cv.put("name", person.name);
        cv.put("age", person.age);
        //插入contextValues中的数据
        db.insert( "person",null,cv );

        /*
        person.name = "david";
        person.age = 33;
        //ContentValues以键值对的形式存放数据
        ContentValues cv = new ContentValues();
        cv.put("name", person.name);
        cv.put("age", person.age);
        //插入ContentValues中的数据
        db.insert("person", null, cv);

        cv = new ContentValues();
        cv.put("age", 35);*/

        //关闭当前数据库
        db.close();
    }
}
