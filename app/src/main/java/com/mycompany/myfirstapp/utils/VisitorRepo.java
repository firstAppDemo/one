package com.mycompany.myfirstapp.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.mycompany.myfirstapp.entity.UserInfo;
import com.mycompany.myfirstapp.entity.Visitor;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Administrator on 2017/4/17.
 */

public class VisitorRepo {

    private DBHelperUserInfo dbHelper;

    public VisitorRepo(Context context) {
        dbHelper = new DBHelperUserInfo( context );
    }

    public int insert(Visitor visitor) {
        //打开连接，写入数据
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( Visitor.KEY_changeBy , visitor.changeBy );
        values.put( Visitor.KEY_changeTime , visitor.changeTime );
        values.put( Visitor.KEY_createBy , visitor.createBy );
        values.put( Visitor.KEY_createTime , visitor.createTime );
        values.put( Visitor.KEY_crew, visitor.crew );
        values.put( Visitor.KEY_department , visitor.department );
        values.put( Visitor.KEY_deskclrek , visitor.deskclrek );
        values.put( Visitor.KEY_deskclrekPhone , visitor.deskclrekPhone );
        values.put( Visitor.KEY_memo , visitor.memo );
        values.put( Visitor.KEY_reason , visitor.reason );
        values.put( Visitor.KEY_status , visitor.status );
        values.put( Visitor.KEY_statusTime , visitor.statusTime );
        values.put( Visitor.KEY_visitTime , visitor.visitTime );
        values.put( Visitor.KEY_leaveTime , visitor.leaveTime );
        values.put( Visitor.KEY_test2 , visitor.test2 );
        values.put( Visitor.KEY_test3 , visitor.test3 );
        long visitId = db.insert( Visitor.TABLE, null, values );
        db.close();
        return (int) visitId;
    }
    // 关闭数据库
    public void closeDB() {
        dbHelper.getWritableDatabase().close();
    }

    //删除
    public void delete(int visitId) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete( Visitor.TABLE, Visitor.KEY_visitId + "=?", new String[]{String.valueOf( visitId )} );
        db.close();
    }

    //修改
    public void update(Visitor visitor) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( Visitor.KEY_changeBy , visitor.changeBy );
        values.put( Visitor.KEY_changeTime , visitor.changeTime );
        values.put( Visitor.KEY_createBy , visitor.createBy );
        values.put( Visitor.KEY_createTime , visitor.createTime );
        values.put( Visitor.KEY_crew, visitor.crew );
        values.put( Visitor.KEY_department , visitor.department );
        values.put( Visitor.KEY_deskclrek , visitor.deskclrek );
        values.put( Visitor.KEY_deskclrekPhone , visitor.deskclrekPhone );
        values.put( Visitor.KEY_memo , visitor.memo );
        values.put( Visitor.KEY_reason , visitor.reason );
        values.put( Visitor.KEY_status , visitor.status );
        values.put( Visitor.KEY_statusTime , visitor.statusTime );
        values.put( Visitor.KEY_visitTime , visitor.visitTime );
        values.put( Visitor.KEY_leaveTime , visitor.leaveTime );
        values.put( Visitor.KEY_test2 , visitor.test2 );
        values.put( Visitor.KEY_test3 , visitor.test3 );
        db.update( Visitor.TABLE, values, " visitId =?", new String[]{String.valueOf( visitor.visitId )} );
    }

    //查询
    public ArrayList<HashMap<String, String>> getVisitorList() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT " +
                Visitor.KEY_visitId + "," +
                Visitor.KEY_visitTime + "," +
                Visitor.KEY_crew + "," +
                Visitor.KEY_statusTime + "," +
                Visitor.KEY_status + "," +
                Visitor.KEY_changeBy + "," +
                Visitor.KEY_changeTime + "," +
                Visitor.KEY_createTime + "," +
                Visitor.KEY_createBy + "," +
                Visitor.KEY_department + "," +
                Visitor.KEY_memo + "," +
                Visitor.KEY_reason + "," +
                Visitor.KEY_deskclrek + "," +
                Visitor.KEY_test3+ "," +
                Visitor.KEY_test2+ "," +
                Visitor.KEY_leaveTime+ "," +
                Visitor.KEY_deskclrekPhone +
                "  FROM " + Visitor.TABLE;
        ArrayList<HashMap<String, String>> visitorList = new ArrayList<HashMap<String, String>>();
        Cursor cursor = db.rawQuery( selectQuery, null );
        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> visitor = new HashMap<String, String>();
                visitor.put( "visitId", cursor.getString( cursor.getColumnIndex( Visitor.KEY_visitId ) ) );
                visitor.put( "visitTime", cursor.getString( cursor.getColumnIndex(  Visitor.KEY_visitTime ) ) );
                visitor.put( "crew", cursor.getString( cursor.getColumnIndex(  Visitor.KEY_crew  ) ) );
                visitor.put( "statusTime", cursor.getString( cursor.getColumnIndex(  Visitor.KEY_statusTime ) ) );
                visitor.put( "status", cursor.getString( cursor.getColumnIndex( Visitor.KEY_status  ) ) );
                visitor.put( "changeBy", cursor.getString( cursor.getColumnIndex(  Visitor.KEY_changeBy ) ) );
                visitor.put( "changeTime", cursor.getString( cursor.getColumnIndex(  Visitor.KEY_changeTime ) ) );
                visitor.put( "createBy", cursor.getString( cursor.getColumnIndex( Visitor.KEY_createBy ) ) );
                visitor.put( "createTime", cursor.getString( cursor.getColumnIndex( Visitor.KEY_createTime ) ) );
                visitor.put( "department", cursor.getString( cursor.getColumnIndex(   Visitor.KEY_department ) ) );
                visitor.put( "memo", cursor.getString( cursor.getColumnIndex(  Visitor.KEY_memo  ) ) );
                visitor.put( "reason", cursor.getString( cursor.getColumnIndex(  Visitor.KEY_reason  ) ) );
                visitor.put( "deskclrek", cursor.getString( cursor.getColumnIndex(   Visitor.KEY_deskclrek ) ) );
                visitor.put( "leaveTime", cursor.getString( cursor.getColumnIndex(   Visitor.KEY_leaveTime ) ) );
                visitor.put( "test2", cursor.getString( cursor.getColumnIndex(   Visitor.KEY_test2 ) ) );
                visitor.put( "test3", cursor.getString( cursor.getColumnIndex(   Visitor.KEY_test3 ) ) );
                visitor.put( "deskclrekPhone", cursor.getString( cursor.getColumnIndex( Visitor.KEY_deskclrekPhone ) ) );
                visitorList.add( visitor );
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return visitorList   ;
    }


    public Visitor getById(int visitId){
        SQLiteDatabase db=dbHelper.getReadableDatabase();
        String selectQuery = "SELECT " +
                Visitor.KEY_visitId + "," +
                Visitor.KEY_visitTime + "," +
                Visitor.KEY_crew + "," +
                Visitor.KEY_statusTime + "," +
                Visitor.KEY_status + "," +
                Visitor.KEY_changeBy + "," +
                Visitor.KEY_changeTime + "," +
                Visitor.KEY_createTime + "," +
                Visitor.KEY_createBy + "," +
                Visitor.KEY_department + "," +
                Visitor.KEY_memo + "," +
                Visitor.KEY_reason + "," +
                Visitor.KEY_deskclrek + "," +
                Visitor.KEY_test3+ "," +
                Visitor.KEY_test2+ "," +
                Visitor.KEY_leaveTime+ "," +
                Visitor.KEY_deskclrekPhone +
                " FROM " + Visitor.TABLE  + " WHERE " +
                Visitor.KEY_visitId + "=?";
        int iCount=0;
        Visitor visitor=new Visitor();
        Cursor cursor=db.rawQuery(selectQuery,new String[]{String.valueOf(visitId)});
        if(cursor.moveToFirst()){
            do{
                visitor.visitId= cursor.getInt( cursor.getColumnIndex( Visitor.KEY_visitId ));
                visitor.visitTime= cursor.getString( cursor.getColumnIndex(  Visitor.KEY_visitTime ) ) ;
                visitor.crew= cursor.getString( cursor.getColumnIndex(  Visitor.KEY_crew  ) ) ;
                visitor.statusTime= cursor.getString( cursor.getColumnIndex(  Visitor.KEY_statusTime ) );
                visitor.status = cursor.getString( cursor.getColumnIndex(Visitor.KEY_status  )  );
                visitor.changeBy= cursor.getString( cursor.getColumnIndex(  Visitor.KEY_changeBy )  );
                visitor.changeTime= cursor.getString( cursor.getColumnIndex(  Visitor.KEY_changeTime )  );
                visitor.createBy= cursor.getString( cursor.getColumnIndex( Visitor.KEY_createBy  ) );
                visitor.createTime= cursor.getString( cursor.getColumnIndex( Visitor.KEY_createTime ) );
                visitor.department= cursor.getString( cursor.getColumnIndex(   Visitor.KEY_department ) );
                visitor.memo= cursor.getString( cursor.getColumnIndex(  Visitor.KEY_memo  ) );
                visitor.reason= cursor.getString( cursor.getColumnIndex(  Visitor.KEY_reason  )  );
                visitor.deskclrek= cursor.getString( cursor.getColumnIndex(   Visitor.KEY_deskclrek )  );
                visitor.leaveTime =cursor.getString( cursor.getColumnIndex(   Visitor.KEY_leaveTime ) ) ;
                visitor.test2=cursor.getString( cursor.getColumnIndex(   Visitor.KEY_test2 ) );
                visitor.test3=cursor.getString( cursor.getColumnIndex(   Visitor.KEY_test3 ) );
                visitor.deskclrekPhone = cursor.getString( cursor.getColumnIndex( Visitor.KEY_deskclrekPhone )  );
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return visitor;
    }
}
