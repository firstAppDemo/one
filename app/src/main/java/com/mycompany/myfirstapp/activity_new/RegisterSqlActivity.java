package com.mycompany.myfirstapp.activity_new;

import android.app.Activity;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import com.mycompany.myfirstapp.R;
import com.mycompany.myfirstapp.activity.HelloWorldActivity;
import com.mycompany.myfirstapp.activity.MainActivity;
import com.mycompany.myfirstapp.entity.UserInfo;
import com.mycompany.myfirstapp.utils.UserInfoRepo;

import java.util.Date;

/**
 * Created by Administrator on 2017/4/13.
 */

public class RegisterSqlActivity extends AppCompatActivity implements View.OnClickListener{
    private final String REGISTER_GO ="RegisterSqlActivity";

    private EditText username;
    private EditText psd;
    private RadioButton man;
    private RadioButton woman;
    private RadioButton yao;
    private CheckBox ck_chess,ck_game,ck_look,ck_mountain,ck_painting,ck_reading,ck_play,ck_running,ck_singing;
    private Button btnYes,btnNo;
    private CheckBox a, b, c, d, e, f, g, h, j;

    private int _userinfo_id=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.user_register );

        init();//btn_reg_yes
    }


    private void init() {
        btnYes = (Button) findViewById( R.id.btn_reg_yes );
        btnNo = (Button) findViewById( R.id.btn_reg_no );
        btnYes.setOnClickListener( this );
        btnNo.setOnClickListener( this );

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

     /*   ck_chess = (CheckBox) findViewById( R.id.ck_chess );
        ck_game = (CheckBox) findViewById( R.id.ck_game );
        ck_look = (CheckBox) findViewById( R.id.ck_look );
        ck_mountain = (CheckBox) findViewById( R.id.ck_mountain );
        ck_painting = (CheckBox) findViewById( R.id.ck_painting );
        ck_reading = (CheckBox) findViewById( R.id.ck_reading );
        ck_play = (CheckBox) findViewById( R.id.ck_play );
        ck_running = (CheckBox) findViewById( R.id.ck_running );
        ck_singing = (CheckBox) findViewById( R.id.ck_singing );*/
    }

    @Override
    public void onClick(View v) {
        if (v == findViewById( R.id.btn_reg_yes )) {
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

            String sex;
            if (man.isChecked()) {
                sex = man.getText().toString();
            } else if (woman.isChecked()) {
                sex = woman.getText().toString();
            } else {
                sex = yao.getText().toString();
            }

            SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
            Date date = new Date(  );
            String nowTime = sdf.format( date );
            UserInfoRepo repo = new UserInfoRepo( this );
            String name  = username.getText().toString();
            String passw = psd.getText().toString();

            if (repo.CheckIsDataAlreadyInDBorNot(name) == true) {
                Toast.makeText(this,"该用户名已被注册，注册失败",Toast.LENGTH_SHORT).show();
            }else if (TextUtils.isEmpty( name )) {
                Toast.makeText( this, "用户名不能为空", Toast.LENGTH_SHORT ).show();
                return;
            }else if (TextUtils.isEmpty( passw )) {
                psd.setError( "密码不能为空" );
                return;

            } else{
                UserInfo user = new UserInfo();
                user.hobby = s.toString().equals( "" ) ? "" : s.toString().substring( 0, s.length() );
                user.psd = passw;
                user.sex = sex;
                user.username = name;
                user.ids = _userinfo_id;
                //插入默认值
                user.age = 18;
                user.img = R.drawable.head_2;
                user.remark = "这个人很懒，什么也没留下。";
                user.createTime=nowTime;


                String u = s.toString().equals( "" ) ? "" : s.toString().substring( 0, s.length() );

                if (_userinfo_id == 0) {
                    _userinfo_id = repo.insert( user );
                    Toast.makeText( this, "注册成功，Yeah！！！"+"名字："+username.getText().toString()+"----密码：" +psd.getText().toString()
                            +"----性别--" + sex + "----爱好--" + u, Toast.LENGTH_SHORT ).show();
                    Intent intent2 = new Intent(this,MainActivity.class);
                    startActivity(intent2);
                } else {
                    // repo.update(user);
                    Toast.makeText( this, "注册失败！请你重试一次。", Toast.LENGTH_SHORT ).show();
                }
            }
            }



    }
}
