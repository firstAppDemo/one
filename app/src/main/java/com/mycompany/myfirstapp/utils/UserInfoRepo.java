package com.mycompany.myfirstapp.utils;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.mycompany.myfirstapp.activity_new.LoginSqlActivity;
import com.mycompany.myfirstapp.entity.Student;
import com.mycompany.myfirstapp.entity.UserInfo;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Administrator on 2017/4/13.
 */

public class UserInfoRepo {
    private DBHelperUserInfo dbHelper;

    public UserInfoRepo(Context context) {
        dbHelper = new DBHelperUserInfo( context );
    }

    public int insert(UserInfo userInfo) {
        //打开连接，写入数据
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( UserInfo.KEY_age, userInfo.age );
        values.put( UserInfo.KEY_hobby, userInfo.hobby );
        values.put( UserInfo.KEY_img, userInfo.img );
        values.put( UserInfo.KEY_psd, userInfo.psd );
        values.put( UserInfo.KEY_remark, userInfo.remark );
        values.put( UserInfo.KEY_sex, userInfo.sex );
        values.put( UserInfo.KEY_username, userInfo.username );

        values.put( UserInfo.KEY_department, userInfo.department );
        values.put( UserInfo.KEY_crew, userInfo.crew );
        values.put( UserInfo.KEY_createTime, userInfo.createTime );
        values.put( UserInfo.KEY_phone, userInfo.phone );
        values.put( UserInfo.KEY_text2, userInfo.text2 );
        values.put( UserInfo.KEY_text3, userInfo.text3 );
        values.put( UserInfo.KEY_text4, userInfo.text4 );
        values.put( UserInfo.KEY_text5, userInfo.text5 );

        long ids = db.insert( UserInfo.TABLE, null, values );
        db.close();
        return (int) ids;
    }

    //删除
    public void delete(int ids) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete( UserInfo.TABLE, UserInfo.KEY_IDS + "=?", new String[]{String.valueOf( ids )} );
        db.close();
    }

    //删除
    public void delete2(String  text5) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete( UserInfo.TABLE, UserInfo.KEY_text5 + "=?", new String[]{String.valueOf( text5 )} );
        db.close();
    }

    //修改
    public void update(UserInfo userInfo) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( UserInfo.KEY_age, userInfo.age );
        values.put( UserInfo.KEY_hobby, userInfo.hobby );
        values.put( UserInfo.KEY_img, userInfo.img );
        values.put( UserInfo.KEY_psd, userInfo.psd );
        values.put( UserInfo.KEY_remark, userInfo.remark );
        values.put( UserInfo.KEY_sex, userInfo.sex );
        values.put( UserInfo.KEY_username, userInfo.username );
        values.put( UserInfo.KEY_department, userInfo.department );
        values.put( UserInfo.KEY_crew, userInfo.crew );
        values.put( UserInfo.KEY_createTime, userInfo.createTime );
        values.put( UserInfo.KEY_phone, userInfo.phone );
        values.put( UserInfo.KEY_text2, userInfo.text2 );
        values.put( UserInfo.KEY_text3, userInfo.text3 );
        values.put( UserInfo.KEY_text4, userInfo.text4 );
        values.put( UserInfo.KEY_text5, userInfo.text5 );
        db.update( UserInfo.TABLE, values,   " ids=? ",new String[]{String.valueOf( userInfo.ids )} );

    }

    //查询
    public ArrayList<HashMap<String, String>> getUserInfoList() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT " +
                UserInfo.KEY_IDS + "," +
                UserInfo.KEY_username + "," +
                UserInfo.KEY_psd + "," +
                UserInfo.KEY_sex + "," +
                UserInfo.KEY_hobby + "," +
                UserInfo.KEY_img + "," +
                UserInfo.KEY_remark + "," +
                UserInfo.KEY_department + "," +
                UserInfo.KEY_crew + "," +
                UserInfo.KEY_createTime + "," +
                UserInfo.KEY_phone + "," +
                UserInfo.KEY_text2 + "," +
                UserInfo.KEY_text3 + "," +
                UserInfo.KEY_text4 + "," +
                UserInfo.KEY_text5 + "," +
                UserInfo.KEY_age + " FROM " + UserInfo.TABLE+" where " + UserInfo.KEY_text5 + " is null";
        ArrayList<HashMap<String, String>> userinfoList = new ArrayList<HashMap<String, String>>();
        Cursor cursor = db.rawQuery( selectQuery, null );
        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> userinfo = new HashMap<String, String>();
                userinfo.put( "ids", cursor.getString( cursor.getColumnIndex( UserInfo.KEY_IDS ) ) );
                userinfo.put( "username", cursor.getString( cursor.getColumnIndex( UserInfo.KEY_username ) ) );
                userinfo.put( "age", cursor.getString( cursor.getColumnIndex( UserInfo.KEY_age ) ) );
                userinfo.put( "hobby", cursor.getString( cursor.getColumnIndex( UserInfo.KEY_hobby ) ) );
                userinfo.put( "img", cursor.getString( cursor.getColumnIndex( UserInfo.KEY_img ) ) );
                userinfo.put( "remark", cursor.getString( cursor.getColumnIndex( UserInfo.KEY_remark ) ) );
                userinfo.put( "sex", cursor.getString( cursor.getColumnIndex( UserInfo.KEY_sex ) ) );
                userinfo.put( "psd", cursor.getString( cursor.getColumnIndex( UserInfo.KEY_psd ) ) );

                userinfo.put( "department", cursor.getString( cursor.getColumnIndex( UserInfo.KEY_department ) ) );
                userinfo.put( "crew", cursor.getString( cursor.getColumnIndex( UserInfo.KEY_crew ) ) );
                userinfo.put( "phone", cursor.getString( cursor.getColumnIndex( UserInfo.KEY_createTime ) ) );
                userinfo.put( "createTime", cursor.getString( cursor.getColumnIndex( UserInfo.KEY_phone ) ) );
                userinfo.put( "text2", cursor.getString( cursor.getColumnIndex( UserInfo.KEY_text2 ) ) );
                userinfo.put( "text3", cursor.getString( cursor.getColumnIndex( UserInfo.KEY_text3 ) ) );
                userinfo.put( "text4", cursor.getString( cursor.getColumnIndex( UserInfo.KEY_text4 ) ) );
                userinfo.put( "text5", cursor.getString( cursor.getColumnIndex( UserInfo.KEY_text5 ) ) );
                userinfoList.add( userinfo );
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return userinfoList;
    }

    public UserInfo getUserInfoById(int Id) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT " +
                UserInfo.KEY_IDS + "," +
                UserInfo.KEY_username + "," +
                UserInfo.KEY_psd + "," +
                UserInfo.KEY_sex + "," +
                UserInfo.KEY_hobby + "," +
                UserInfo.KEY_img + "," +
                UserInfo.KEY_remark + "," +
                UserInfo.KEY_age + "," +
                UserInfo.KEY_department + "," +
                UserInfo.KEY_crew + "," +
                UserInfo.KEY_createTime + "," +
                UserInfo.KEY_phone + "," +
                UserInfo.KEY_text2 + "," +
                UserInfo.KEY_text3 + "," +
                UserInfo.KEY_text4 + "," +
                UserInfo.KEY_text5 +
                " FROM " + UserInfo.TABLE
                + " WHERE " +
                UserInfo.KEY_IDS + "=?";
        int iCount = 0;
        UserInfo userInfo = new UserInfo();
        Cursor cursor = db.rawQuery( selectQuery, new String[]{String.valueOf( Id )} );
        if (cursor.moveToFirst()) {
            do {
                userInfo.ids = cursor.getInt( cursor.getColumnIndex( UserInfo.KEY_IDS ) );
                userInfo.username = cursor.getString( cursor.getColumnIndex( UserInfo.KEY_username ) );
                userInfo.psd = cursor.getString( cursor.getColumnIndex( UserInfo.KEY_psd ) );
                userInfo.img = cursor.getInt( cursor.getColumnIndex( UserInfo.KEY_img ) );
                userInfo.remark = cursor.getString( cursor.getColumnIndex( UserInfo.KEY_remark ) );
                userInfo.hobby = cursor.getString( cursor.getColumnIndex( UserInfo.KEY_hobby ) );
                userInfo.sex = cursor.getString( cursor.getColumnIndex( UserInfo.KEY_sex ) );
                userInfo.age = cursor.getInt( cursor.getColumnIndex( UserInfo.KEY_age ) );
                userInfo.department = cursor.getString( cursor.getColumnIndex( UserInfo.KEY_department ) );
                userInfo.createTime = cursor.getString( cursor.getColumnIndex( UserInfo.KEY_createTime ) );
                userInfo.crew = cursor.getString( cursor.getColumnIndex( UserInfo.KEY_crew ) );
                userInfo.phone = cursor.getString( cursor.getColumnIndex( UserInfo.KEY_phone) );
                userInfo.text2 = cursor.getString( cursor.getColumnIndex( UserInfo.KEY_text2 ) );
                userInfo.text3 = cursor.getString( cursor.getColumnIndex( UserInfo.KEY_text3 ) );
                userInfo.text4 = cursor.getString( cursor.getColumnIndex( UserInfo.KEY_text4 ) );
                userInfo.text5 = cursor.getString( cursor.getColumnIndex( UserInfo.KEY_text5 ) );
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return userInfo;
    }

    //登录用
    public boolean login(String username, String password) {
        SQLiteDatabase sdb = dbHelper.getReadableDatabase();
        //String sql="select * from user where username=? and password=?";
        String sql = "select * from user where " + UserInfo.KEY_username + " =? " + "and"
                + UserInfo.KEY_psd + " = ?";
        Cursor cursor = sdb.rawQuery( sql, new String[]{username, password} );
        if (cursor.moveToFirst() == true) {
            cursor.close();
            return true;
        }
        return false;
    }

    // 判断输入的用户是否正确
    public Boolean isUserinfo(String name, String pwd) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql = "select * from " + UserInfo.TABLE + " where " + UserInfo.KEY_username + " =? " + " and "
                + UserInfo.KEY_psd + " = ?";
        Cursor cursor = db.rawQuery( sql, new String[]{name, pwd} );
        if (cursor.getCount() <= 0) {
            cursor.close();
            return false;
        } else {
            cursor.close();
            return true;
        }
    }

    //检验用户名是否已存在
    public boolean CheckIsDataAlreadyInDBorNot(String value) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String Query = "Select * from  " + UserInfo.TABLE + "  where  " + UserInfo.KEY_username + "  =?";
        Cursor cursor = db.rawQuery( Query, new String[]{value} );
        if (cursor.getCount() > 0) {
            cursor.close();
            return true;
        }
        cursor.close();
        return false;
    }


    //根据用户查询用户资料
    public UserInfo findUserinfo(String value) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String Query = "Select * from  " + UserInfo.TABLE + "  where  " + UserInfo.KEY_username + "  =?";
        UserInfo userInfo = new UserInfo();
        Cursor cursor = db.rawQuery( Query, new String[]{value} );
        if (cursor.moveToFirst()) {
            do {
                userInfo.ids = cursor.getInt( cursor.getColumnIndex( UserInfo.KEY_IDS ) );
                userInfo.username = cursor.getString( cursor.getColumnIndex( UserInfo.KEY_username ) );
                userInfo.psd = cursor.getString( cursor.getColumnIndex( UserInfo.KEY_psd ) );
                userInfo.img = cursor.getInt( cursor.getColumnIndex( UserInfo.KEY_img ) );
                userInfo.remark = cursor.getString( cursor.getColumnIndex( UserInfo.KEY_remark ) );
                userInfo.hobby = cursor.getString( cursor.getColumnIndex( UserInfo.KEY_hobby ) );
                userInfo.sex = cursor.getString( cursor.getColumnIndex( UserInfo.KEY_sex ) );
                userInfo.age = cursor.getInt( cursor.getColumnIndex( UserInfo.KEY_age ) );
                userInfo.department = cursor.getString( cursor.getColumnIndex( UserInfo.KEY_department ) );
                userInfo.createTime = cursor.getString( cursor.getColumnIndex( UserInfo.KEY_createTime ) );
                userInfo.crew = cursor.getString( cursor.getColumnIndex( UserInfo.KEY_crew ) );
                userInfo.phone = cursor.getString( cursor.getColumnIndex( UserInfo.KEY_phone) );
                userInfo.text2 = cursor.getString( cursor.getColumnIndex( UserInfo.KEY_text2 ) );
                userInfo.text3 = cursor.getString( cursor.getColumnIndex( UserInfo.KEY_text3 ) );
                userInfo.text4 = cursor.getString( cursor.getColumnIndex( UserInfo.KEY_text4 ) );
                userInfo.text5 = cursor.getString( cursor.getColumnIndex( UserInfo.KEY_text5 ) );
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return userInfo;
    }

    //查询
    public ArrayList<HashMap<String, String>> getUserVisitorList() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT " +
                UserInfo.KEY_IDS + "," +
                UserInfo.KEY_username + "," +
                UserInfo.KEY_psd + "," +
                UserInfo.KEY_sex + "," +
                UserInfo.KEY_hobby + "," +
                UserInfo.KEY_img + "," +
                UserInfo.KEY_remark + "," +
                UserInfo.KEY_department + "," +
                UserInfo.KEY_crew + "," +
                UserInfo.KEY_createTime + "," +
                UserInfo.KEY_phone + "," +
                UserInfo.KEY_text2 + "," +
                UserInfo.KEY_text3 + "," +
                UserInfo.KEY_text4 + "," +
                UserInfo.KEY_text5 + "," +
                UserInfo.KEY_age + " FROM " + UserInfo.TABLE +" where " + UserInfo.KEY_text5 + " is not null";
        ArrayList<HashMap<String, String>> userinfoList = new ArrayList<HashMap<String, String>>();
        Cursor cursor = db.rawQuery( selectQuery, null );
        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> userinfo = new HashMap<String, String>();
                userinfo.put( "ids", cursor.getString( cursor.getColumnIndex( UserInfo.KEY_IDS ) ) );
                userinfo.put( "username", cursor.getString( cursor.getColumnIndex( UserInfo.KEY_username ) ) );
                userinfo.put( "age", cursor.getString( cursor.getColumnIndex( UserInfo.KEY_age ) ) );
                userinfo.put( "hobby", cursor.getString( cursor.getColumnIndex( UserInfo.KEY_hobby ) ) );
                userinfo.put( "img", cursor.getString( cursor.getColumnIndex( UserInfo.KEY_img ) ) );
                userinfo.put( "remark", cursor.getString( cursor.getColumnIndex( UserInfo.KEY_remark ) ) );
                userinfo.put( "sex", cursor.getString( cursor.getColumnIndex( UserInfo.KEY_sex ) ) );
                userinfo.put( "psd", cursor.getString( cursor.getColumnIndex( UserInfo.KEY_psd ) ) );

                userinfo.put( "department", cursor.getString( cursor.getColumnIndex( UserInfo.KEY_department ) ) );
                userinfo.put( "crew", cursor.getString( cursor.getColumnIndex( UserInfo.KEY_crew ) ) );
                userinfo.put( "phone", cursor.getString( cursor.getColumnIndex( UserInfo.KEY_createTime ) ) );
                userinfo.put( "createTime", cursor.getString( cursor.getColumnIndex( UserInfo.KEY_phone ) ) );
                userinfo.put( "text2", cursor.getString( cursor.getColumnIndex( UserInfo.KEY_text2 ) ) );
                userinfo.put( "text3", cursor.getString( cursor.getColumnIndex( UserInfo.KEY_text3 ) ) );
                userinfo.put( "text4", cursor.getString( cursor.getColumnIndex( UserInfo.KEY_text4 ) ) );
                userinfo.put( "text5", cursor.getString( cursor.getColumnIndex( UserInfo.KEY_text5 ) ) );
                userinfoList.add( userinfo );
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return userinfoList;
    }
}
