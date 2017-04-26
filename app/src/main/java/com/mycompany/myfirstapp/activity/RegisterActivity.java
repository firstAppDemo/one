package com.mycompany.myfirstapp.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.mycompany.myfirstapp.R;
import com.mycompany.myfirstapp.entity.Person;
import com.mycompany.myfirstapp.entity.UserInfo;

/**
 * Created by Administrator on 2017/4/6.
 */

public class RegisterActivity extends Activity {

    private EditText username;
    private EditText psd;
    private RadioButton man;
    private RadioButton woman;
    private RadioButton yao;
    private CheckBox a, b, c, d, e, f, g, h, j;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.user_register );

        init();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder( this ).addApi( AppIndex.API ).build();
    }

    private void init() {
        username = (EditText) findViewById( R.id.et_reg_username );
        psd = (EditText) findViewById( R.id.et_reg_psd );
        man = (RadioButton) findViewById( R.id.rad_man );
        woman = (RadioButton) findViewById( R.id.rad_woman );
        yao = (RadioButton) findViewById( R.id.rad_yao );
        a = (CheckBox) findViewById( R.id.ck_chess );
        b = (CheckBox) findViewById( R.id.ck_game );
        c = (CheckBox) findViewById( R.id.ck_look );
        d = (CheckBox) findViewById( R.id.ck_mountain );
        e = (CheckBox) findViewById( R.id.ck_painting );
        f = (CheckBox) findViewById( R.id.ck_reading );
        g = (CheckBox) findViewById( R.id.ck_play );
        h = (CheckBox) findViewById( R.id.ck_running );
        j = (CheckBox) findViewById( R.id.ck_singing );
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_reg_yes:
                String uName = username.getText().toString();
                if (TextUtils.isEmpty( uName )) {
                    Toast.makeText( this, "用户名不能为空", Toast.LENGTH_SHORT ).show();
                    return;
                }
                String passW = psd.getText().toString();
                if (TextUtils.isEmpty( passW )) {
                    psd.setError( "密码不能为空" );
                    return;
                }
               String sex;
                if (man.isChecked()) {
                    sex = man.getText().toString();
                } else if (woman.isChecked()) {
                    sex = woman.getText().toString();
                } else {
                    sex = yao.getText().toString();
                }
                StringBuffer s = new StringBuffer();
                if (a.isChecked()) {
                    s.append( a.getText().toString() + "," );
                }
                if (b.isChecked()) {
                    s.append( b.getText().toString() + "," );
                }
                if (c.isChecked()) {
                    s.append( c.getText().toString() + "," );
                }
                if (d.isChecked()) {
                    s.append( d.getText().toString() + "," );
                }
                if (e.isChecked()) {
                    s.append( e.getText().toString() + "," );
                }
                if (f.isChecked()) {
                    s.append( f.getText().toString() + "," );
                }
                if (g.isChecked()) {
                    s.append( g.getText().toString() + "," );
                }
                if (h.isChecked()) {
                    s.append( h.getText().toString() + "," );
                }
                if (j.isChecked()) {
                    s.append( j.getText().toString() + "," );
                }
               // UserInfo user = new UserInfo( 0, 0, "", sex, s.toString().equals( "" ) ? "" : s.toString().substring( 0, s.length() ), uName, passW );
                UserInfo user = new UserInfo();
                user.sex = sex;
                user.hobby =  s.toString().equals( "" ) ? "" : s.toString().substring( 0, s.length() );
                user.username = uName;
                user.psd = passW;
                Toast.makeText( this, "用户注册信息：" + user.toString(), Toast.LENGTH_SHORT ).show();
                break;
            case R.id.btn_reg_no:
                goBack(view);
                finish();
                break;
        }
    }
    public void goBack(View view) {
        Intent intent = new Intent();
        intent.setClass(RegisterActivity.this, MainActivity.class);
        startActivity(intent);
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName( "Register Page" ) // TODO: Define a title for the content shown.
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
