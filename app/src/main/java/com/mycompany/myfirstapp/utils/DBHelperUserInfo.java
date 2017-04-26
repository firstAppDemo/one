package com.mycompany.myfirstapp.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.mycompany.myfirstapp.entity.UserInfo;
import com.mycompany.myfirstapp.entity.Visitor;

/**
 * Created by Administrator on 2017/4/13.
 */

public class DBHelperUserInfo extends SQLiteOpenHelper {
    //数据库版本号
    private static final int DATABASE_VERSION=16;

    //数据库名称
    private static final String DATABASE_NAME="user.db";

    public DBHelperUserInfo(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);

    }
    //创建用户详情表
    private static final String CREATE_TABLE_USERINFO ="CREATE TABLE "+ UserInfo.TABLE+"("
            +UserInfo.KEY_IDS+" INTEGER PRIMARY KEY AUTOINCREMENT ,"
            +UserInfo.KEY_username+" TEXT, "
            +UserInfo.KEY_hobby+" TEXT, "
            +UserInfo.KEY_sex+" TEXT, "
            +UserInfo.KEY_img+" TEXT, "
            +UserInfo.KEY_remark+" TEXT, "
            +UserInfo.KEY_department+" TEXT, "
            +UserInfo.KEY_createTime+" TEXT, "
            +UserInfo.KEY_crew+" TEXT, "
            +UserInfo.KEY_phone+" TEXT, "
            +UserInfo.KEY_text5+" TEXT, "
            +UserInfo.KEY_text4+" TEXT, "
            +UserInfo.KEY_text3+" TEXT, "
            +UserInfo.KEY_text2+" TEXT, "
            +UserInfo.KEY_age+" INTEGER, "
            +UserInfo.KEY_psd+" TEXT)";

    //创建访客表
    private static final  String CREATE_TABLE_VISITOR = "CREATE TABLE "+  Visitor.TABLE +"("
            + Visitor.KEY_visitId+" INTEGER PRIMARY KEY AUTOINCREMENT ,"
            + Visitor.KEY_changeBy+" TEXT ,"
            + Visitor.KEY_changeTime+" TEXT , "
            + Visitor.KEY_createBy+" TEXT , "
            + Visitor.KEY_createTime+" TEXT , "
            + Visitor.KEY_crew+" TEXT ,  "
            + Visitor.KEY_department+" TEXT , "
            + Visitor.KEY_deskclrek+" TEXT , "
            + Visitor.KEY_deskclrekPhone+" TEXT , "
            + Visitor.KEY_memo+" TEXT , "
            + Visitor.KEY_reason+" TEXT , "
            + Visitor.KEY_status+" TEXT , "
            + Visitor.KEY_statusTime+" TEXT , "
            + Visitor.KEY_leaveTime+" TEXT , "
            + Visitor.KEY_test2+" TEXT , "
            + Visitor.KEY_test3+" TEXT , "
            + Visitor.KEY_visitTime+" TEXT) ";
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USERINFO);
        db.execSQL(CREATE_TABLE_VISITOR);
    }




    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        //如果旧表存在，删除，所以数据将会消失
    /*    db.execSQL("DROP TABLE IF EXISTS "+ Student.TABLE);*/
        db.execSQL("DROP TABLE IF EXISTS "+ UserInfo.TABLE);
       db.execSQL("DROP TABLE IF EXISTS "+ Visitor.TABLE);
        //再次创建表

        onCreate(db);
    }
}
