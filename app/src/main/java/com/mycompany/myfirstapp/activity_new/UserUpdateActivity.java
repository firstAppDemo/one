package com.mycompany.myfirstapp.activity_new;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.net.Uri;
import android.os.Bundle;
import android.sax.TextElementListener;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.mycompany.myfirstapp.R;
import com.mycompany.myfirstapp.entity.UserInfo;
import com.mycompany.myfirstapp.utils.UserInfoRepo;

import java.util.Date;

/**
 * Created by Administrator on 2017/4/20.
 */

public class UserUpdateActivity extends Activity implements View.OnClickListener {
    private final  String Hellow ="UserUpdateActivity";

    private EditText username, phone, reason;
    private RadioButton cai, bao, xin, shi, xiao, ren, yi, er, san, si, wu, liu;
    private TextView tv_userupp_id;
    private Button yes, no;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.usersql_upp );

        init();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder( this ).addApi( AppIndex.API ).build();
    }

    public void init() {
        Bundle b=getIntent().getExtras();
        String uName =b.getString( "name" );
        int userId = b.getInt( "userid" );


        yes = (Button) findViewById( R.id.btn_userupp_yes );
        no = (Button) findViewById( R.id.btn_userupp_no );
        yes.setOnClickListener( this );
        no.setOnClickListener( this );


        tv_userupp_id = (TextView) findViewById( R.id.tv_userupp_id );
        tv_userupp_id.setText( String.valueOf(userId  ) );

        username = (EditText) findViewById( R.id.et_userupp_username );
        username.setText( uName );

        phone = (EditText) findViewById( R.id.et_userupp_phone );
        reason = (EditText) findViewById( R.id.et_userupp_reason );

        cai = (RadioButton) findViewById( R.id.rad_cai );
        bao = (RadioButton) findViewById( R.id.rad_bao );
        xin = (RadioButton) findViewById( R.id.rad_xin );
        ren = (RadioButton) findViewById( R.id.rad_ren );
        xiao = (RadioButton) findViewById( R.id.rad_xiao );
        yi = (RadioButton) findViewById( R.id.rad_1 );
        er = (RadioButton) findViewById( R.id.rad_2 );
        san = (RadioButton) findViewById( R.id.rad_3 );
        si = (RadioButton) findViewById( R.id.rad_4 );
        wu = (RadioButton) findViewById( R.id.rad_5 );
        liu = (RadioButton) findViewById( R.id.rad_6 );

    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName( "UserUpdate Page" ) // TODO: Define a title for the content shown.
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

    @Override
    public void onClick(View v) {
        if (v == findViewById( R.id.btn_userupp_yes )) {
            Bundle b=getIntent().getExtras();
            String uName =b.getString( "name" );
            String hobby =b.getString("hobby");
            String age =b.getString( "age" );
            String sex = b.getString( "sex" );
            String time = b.getString( "createtime" );
            String psd = b.getString( "psd" );

            int userId = b.getInt( "userid" );

            String dept;
            if (cai.isChecked()) {//*******dept**********
                dept = cai.getText().toString();
            } else if (bao.isChecked()) {
                dept = bao.getText().toString();
            }else if (xin.isChecked()) {
                dept = xin.getText().toString();
            }else if (xiao.isChecked()) {
                dept = xiao.getText().toString();
            }else if (shi.isChecked()) {
                dept = shi.getText().toString();
            } else {
                dept = ren.getText().toString();
            }//*******dept**********

            String crew;
            if (yi.isChecked()) {//*******crew**********
                crew = yi.getText().toString();
            } else if (er.isChecked()) {
                crew = er.getText().toString();
            }else if (san.isChecked()) {
                crew = san.getText().toString();
            }else if (si.isChecked()) {
                crew = si.getText().toString();
            }else if (wu.isChecked()) {
                crew = wu.getText().toString();
            } else {
                crew = liu.getText().toString();
            }//*******crew*************
            SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
            Date date = new Date(  );
            String nowTime = sdf.format( date );

            String  name = username.getText().toString();
            String iPhone = phone.getText().toString();
            String iRemark =reason.getText().toString();

            UserInfoRepo repo = new UserInfoRepo( this );

            if(name.equals( "" )|| iPhone.equals( "" ) ||iRemark.equals( "" ) ||iRemark.equals( "" )){
                new AlertDialog.Builder( UserUpdateActivity.this ).setTitle( "错误" )
                        .setMessage( "请将信息填写完整" ).setPositiveButton( "确定", null )
                        .show();
            }else{
                UserInfo userInfo = new UserInfo();
                userInfo.username=name;
                userInfo.department =dept;
                userInfo.crew=crew;
                userInfo.phone=iPhone;
                userInfo.remark=iRemark;
                userInfo.text2=nowTime;//修改时间
                userInfo.ids=userId;
                userInfo.age=Integer.valueOf( age );
                userInfo.hobby=hobby;
                userInfo.sex=sex;
                userInfo.psd=psd;
                userInfo.createTime=time;
                userInfo.img=R.drawable.head_3;
                Log.d(Hellow,"花落知多少：   "+dept+" "+crew+" "+ iPhone+" " + iRemark+""+hobby+""+0000+""+""+""+"");

                repo.update( userInfo );
                Toast.makeText( this, "修改成功！！！", Toast.LENGTH_SHORT ).show();
                Bundle bundle = new Bundle(  );
                bundle.putInt( "ids",userId );
                Intent i2 = new Intent(UserUpdateActivity.this,UserInfoSqlActivity.class);
                i2.putExtras( bundle );
                startActivity(i2);
            }
        }else if(v == findViewById( R.id.btn_userupp_no )){
            finish();
        }else {
            new AlertDialog.Builder( UserUpdateActivity.this ).setTitle( "错误" )
                    .setMessage( "请重新操作" ).setPositiveButton( "确定", null )
                    .show();
        }
    }
}
