package com.mycompany.myfirstapp.activity_new;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.mycompany.myfirstapp.R;
import com.mycompany.myfirstapp.entity.UserInfo;
import com.mycompany.myfirstapp.utils.UserInfoRepo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/4/24.
 */

public class VisitorDetailedActivity extends Activity implements View.OnClickListener{

    private EditText tvName, tvDept, tvPhone, tvStyle, tvNumber;
    private TextView tvRandom;
    private Button btnSave, btnDown, btnDel;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.visit_detailed_visitor );

        init();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder( this ).addApi( AppIndex.API ).build();
    }

    public void init() {

        btnDel = (Button) findViewById( R.id.bt_visit_deta_del );
        btnDown = (Button) findViewById( R.id.bt_visit_deta_down );
        btnSave = (Button) findViewById( R.id.bt_visit_deta_save);
        btnSave.setOnClickListener( this );

        Bundle bundle = getIntent().getExtras();
        String random= bundle.getString( "random" );

        tvName =(EditText) findViewById( R.id.et_visitdeta_name );
        tvDept= (EditText) findViewById( R.id.et_viitdeta_dept );
        tvPhone =(EditText) findViewById( R.id.et_viitdeta_phone );
        tvStyle =(EditText) findViewById( R.id.et_viitdeta_style);
        tvNumber  =(EditText) findViewById( R.id.et_viitdeta_number );
        tvRandom =(TextView) findViewById( R.id.et_visitdeta_random );
        tvRandom.setText( random );
    }

    @Override
    public void onClick(View view) {
        Bundle bundle = getIntent().getExtras();
        String random =bundle.getString( "random" );
        Date dateN = new Date(  );
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒"  );
        String now = sdf.format( dateN );
        switch (view.getId()){
            case R.id.bt_visit_deta_save:


                String name = tvName.getText().toString();
                String dept = tvDept.getText().toString();
                String phone = tvPhone.getText().toString();
                String style = tvStyle.getText().toString();
                String number = tvNumber.getText().toString();
                //String num = "(^d{18}$)(^d{15}$)";
               /* Pattern pattern = Pattern.compile(num);
                Matcher matcher = pattern.matcher(number);
                Boolean b = matcher.matches();*/
                // String random = tvRandom.getText().toString();
                if(name .equals( "" )|| dept.equals( "" )||phone.equals( "" ) || style.equals( "" )||number.equals(  "")){
                    new AlertDialog.Builder( VisitorDetailedActivity.this ).setTitle( "友情提示" )
                            .setMessage( "所填内容不能为空").setPositiveButton( "确定", null )
                            .show();
                }else{
                    UserInfoRepo repo = new UserInfoRepo( this );
                    UserInfo userInfo = new UserInfo();
                    userInfo.department=dept;
                    userInfo.username=name;
                    userInfo.phone=phone;
                    userInfo.text3=style;//证件类型
                    userInfo.text4=number;//证件号
                    userInfo.text5=random;
                    userInfo.createTime =now;
                    repo.insert( userInfo );
                    new AlertDialog.Builder( VisitorDetailedActivity.this ).setTitle( "友情提示！" )
                            .setMessage( "随机号："+ random).setPositiveButton( "确定", null )
                            .show();
                    Toast.makeText( this, "ok，了！"+random, Toast.LENGTH_SHORT ).show();
                }
                break;
            case R.id.bt_visit_deta_down:
                Bundle bundle2 =new Bundle(  );
                bundle2.putString( "random",random );
                Intent intent = new Intent( this, VisitorDetailedActivity.class );
                intent.putExtras(bundle2  );
                startActivity( intent );
                break;
            case R.id.bt_visit_deta_del:
                UserInfoRepo repo = new UserInfoRepo( this );
                repo.delete2( random );
                Toast.makeText( this, "ok，了！"+random, Toast.LENGTH_SHORT ).show();
                break;
        }

    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName( "VisitorDetailed Page" ) // TODO: Define a title for the content shown.
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
