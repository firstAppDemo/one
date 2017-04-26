package com.mycompany.myfirstapp.activity_new;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.mycompany.myfirstapp.R;
import com.mycompany.myfirstapp.entity.UserInfo;
import com.mycompany.myfirstapp.entity.Visitor;
import com.mycompany.myfirstapp.test.MainActivity2;
import com.mycompany.myfirstapp.utils.UserInfoRepo;
import com.mycompany.myfirstapp.utils.VisitorRepo;

import java.text.ParseException;
import java.util.Date;

/**
 * Created by Administrator on 2017/4/21.
 */

public class VisitorUpdateActivity extends Activity implements View.OnClickListener {

    private EditText createTime, createBy, changeBy, changeTime,
            department, crew, deskclrek, deskclrekPhone, reason, memo, status, statusTime, visitTime, leaveTime;

    private Button btnSub, btnclose;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.visit_main_update );

        Toolbar toolbar = (Toolbar) findViewById( R.id.toolbar_upp );
        toolbar.setTitle( "修改访客单" );//设置主标题
       /* toolbar.setNavigationIcon(R.mipmap.back);//设置导航栏图标
        toolbar.setLogo(R.mipmap.quantou);//设置app logo*//*
        toolbar.inflateMenu( R.menu.menu_visit );//设置右上角的填充菜单*/

        init();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder( this ).addApi( AppIndex.API ).build();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder( this ).addApi( AppIndex.API ).build();
    }

    public void init() {
        Bundle b = getIntent().getExtras();
        //获取Bundle的信息
        String name2 = b.getString( "name" );
        int visitids = b.getInt( "visitids" );
        String createBys = b.getString( "createBys" );
        String createTimes = b.getString( "createTimes" );
        String changeBys = b.getString( "changeBys" );
        String changeTimes = b.getString( "changeTimes" );
        String departments = b.getString( "departments" );
        String deskclrekPhones = b.getString( "deskclrekPhones" );
        String crews = b.getString( "crews" );
        String deskclreks = b.getString( "deskclreks" );
        String reasons = b.getString( "reasons" );
        String memos = b.getString( "memos" );
        String statusTimes = b.getString( "statusTimes" );
        String visitTimes = b.getString( "visitTimes" );
        String leaveTimes = b.getString( "leaveTimes" );
        String statu = b.getString( "status" );


        UserInfoRepo userInfoRepo = new UserInfoRepo( this );
        UserInfo userInfo= userInfoRepo.findUserinfo( name2 );

        btnSub = (Button) findViewById( R.id.btn_visitupp_sub );
        btnclose = (Button) findViewById( R.id.btn_visitupp_desc );
        btnSub.setOnClickListener( this );
        btnclose.setOnClickListener( this );

        createBy = (EditText) findViewById( R.id.et_visitupp_createBy );
        createBy.setText( name2 );

        department = (EditText) findViewById( R.id.et_visitupp_department );
        department.setText( departments );

        crew = (EditText) findViewById( R.id.et_visitupp_crew );
        crew.setText( userInfo.crew );

        deskclrek = (EditText) findViewById( R.id.et_visitupp_deskclrek );
        deskclrek.setText( deskclreks );

        deskclrekPhone = (EditText) findViewById( R.id.et_visitupp_deskclrekPhone );
        deskclrekPhone.setText( deskclrekPhones );

        reason = (EditText) findViewById( R.id.et_visitupp_reason );
        reason.setText( reasons );

        memo = (EditText) findViewById( R.id.et_visitupp_memo );
        memo.setText( memos );

        status = (EditText) findViewById( R.id.et_visitupp_status );
        status.setText( statu );
        status.setKeyListener(null);

        visitTime = (EditText) findViewById( R.id.et_visitupp_visitTime );
        visitTime.setText( visitTimes );

        leaveTime = (EditText) findViewById( R.id.et_visitupp_leaveTime );
        leaveTime.setText( leaveTimes );
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_visitupp_sub:
                Bundle b = getIntent().getExtras();
                int id = b.getInt( "visitids" );

                SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
                SimpleDateFormat formatter = new SimpleDateFormat( "yyyy年MM月dd日" );
                Date curDate = new Date();//获取当前时间

                String nowsTime = sdf.format( curDate );
                String nowTime = formatter.format( curDate );

                String s1 = " 08:30:00";
                String s2 = " 17:00:00";
                VisitorRepo repo =new VisitorRepo( this );

                String c = createBy.getText().toString();
                String e = department.getText().toString();
                String f = deskclrek.getText().toString();
                String g = deskclrekPhone.getText().toString();
                String h = reason.getText().toString();
                String j = memo.getText().toString();
                String k = status.getText().toString();
                String vtime = visitTime.getText().toString();
                String ltime = leaveTime.getText().toString();
                String n = crew.getText().toString();
                if (vtime.equals( "" ) || ltime.equals( "" )||c.equals( "" ) ||e.equals( "" )||f.equals( "" )
                        ||f.equals( "" )||g.equals( "" )||h.equals( "" )||j.equals( "" )||k.equals( "" )) {
                    new AlertDialog.Builder( VisitorUpdateActivity.this ).setTitle( "错误" )
                            .setMessage( "请将信息填写完整" ).setPositiveButton( "确定", null )
                            .show();
                }else {
                    String visittimes = vtime + s1;
                    String leavetimes = ltime + s2;
                    Date visittime = null;
                    Date leavetime = null;
                    try {
                        visittime = sdf.parse( visittimes );
                        leavetime = sdf.parse( leavetimes );
                    } catch (ParseException e1) {
                        e1.printStackTrace();
                    }

                    if (curDate.getTime() > visittime.getTime()) {
                        new AlertDialog.Builder( VisitorUpdateActivity.this ).setTitle( "错误" )
                                .setMessage( "您所输入的时间不能早于当前时间" ).setPositiveButton( "确定", null )
                                .show();
                    } else if (curDate.getTime() > leavetime.getTime()) {
                        new AlertDialog.Builder( VisitorUpdateActivity.this ).setTitle( "错误" )
                                .setMessage( "您所输入的时间不能早于当前时间" ).setPositiveButton( "确定", null )
                                .show();
                        return;
                    } else if (visittime.getTime() > leavetime.getTime()) {
                        new AlertDialog.Builder( VisitorUpdateActivity.this ).setTitle( "错误" )
                                .setMessage( "您所输入的离开时间不能早于来访时间" ).setPositiveButton( "确定", null )
                                .show();
                        return;
                    } else {
                        Visitor visitor = new Visitor();
                        visitor.changeBy = f;
                        visitor.changeTime = nowsTime;
                        visitor.createBy = c;
                        visitor.createTime = nowTime;
                        visitor.department = e;
                        visitor.deskclrek = f;
                        visitor.deskclrekPhone = g;
                        visitor.reason = h;
                        visitor.memo = j;
                        visitor.status = k;
                        visitor.statusTime = nowsTime;
                        visitor.visitTime = visittimes;
                        visitor.leaveTime = leavetimes;
                        visitor.crew = n;
                        visitor.visitId = id;
                        repo.update( visitor );
                        Toast.makeText( this, "修改成功。", Toast.LENGTH_SHORT ).show();

                        Intent i2 = new Intent(VisitorUpdateActivity.this,MainInterfaceActivity.class);

                        startActivity(i2);
                    }
                }
                break;
            case R.id.btn_visitupp_desc:
                finish();
                break;
        }
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName( "VisitorUpdate Page" ) // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl( Uri.parse( "http://[ENTER-YOUR-URL-HERE]" ) )
                .build();
        return new Action.Builder( Action.TYPE_VIEW )
                .setObject( object )
                .setActionStatus( Action.STATUS_TYPE_COMPLETED )
                .build();
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
