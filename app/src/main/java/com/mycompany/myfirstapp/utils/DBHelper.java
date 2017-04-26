package com.mycompany.myfirstapp.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.mycompany.myfirstapp.entity.Student;
import com.mycompany.myfirstapp.entity.UserInfo;

/**
 * Created by Administrator on 2017/4/12.
 */

public class DBHelper extends SQLiteOpenHelper {
    //数据库版本号
    private static final int DATABASE_VERSION=4;

    //数据库名称
    private static final String DATABASE_NAME="crud.db";

    public DBHelper(Context context) {
            super(context,DATABASE_NAME,null,DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建学生表
        String CREATE_TABLE_STUDENT="CREATE TABLE "+ Student.TABLE+"("
                +Student.KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT ,"
                +Student.KEY_name+" TEXT, "
                +Student.KEY_age+" INTEGER, "
                +Student.KEY_email+" TEXT)";
        db.execSQL(CREATE_TABLE_STUDENT);
        //创建用户详情表
        String CREATE_TABLE_USERINFO="CREATE TABLE "+ UserInfo.TABLE+"("
                +UserInfo.KEY_IDS+" INTEGER PRIMARY KEY AUTOINCREMENT ,"
                +UserInfo.KEY_username+" TEXT, "
                +UserInfo.KEY_hobby+" TEXT, "
                +UserInfo.KEY_sex+" TEXT, "
                +UserInfo.KEY_img+" TEXT, "
                +UserInfo.KEY_remark+" TEXT, "
                +UserInfo.KEY_age+" INTEGER, "
                +UserInfo.KEY_psd+" TEXT)";
        db.execSQL(CREATE_TABLE_USERINFO);
    }




    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        //如果旧表存在，删除，所以数据将会消失
        db.execSQL("DROP TABLE IF EXISTS "+ Student.TABLE);
        db.execSQL("DROP TABLE IF EXISTS "+ UserInfo.TABLE);
        //再次创建表
        onCreate(db);
    }
}
