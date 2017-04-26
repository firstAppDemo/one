package com.mycompany.myfirstapp.activity_new;


import android.app.AlertDialog;
import android.content.Intent;


import android.icu.text.SimpleDateFormat;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.mycompany.myfirstapp.R;
import com.mycompany.myfirstapp.datedialog.DateTimePickerDialog;
import com.mycompany.myfirstapp.datedialog.MainActivity3;
import com.mycompany.myfirstapp.entity.UserInfo;
import com.mycompany.myfirstapp.entity.Visitor;
import com.mycompany.myfirstapp.utils.RandomNumber;
import com.mycompany.myfirstapp.utils.UserInfoRepo;
import com.mycompany.myfirstapp.utils.VisitorRepo;

import java.text.ParseException;
import java.util.Date;


/**
 * Created by Administrator on 2017/4/17.
 */

public class VisitorAddActivity extends AppCompatActivity implements View.OnClickListener {

    private final String DDDDD = "VisitorAddActivity";

    private EditText createTime, createBy, changeBy, changeTime,
            department, crew, deskclrek, deskclrekPhone, reason, memo, status, statusTime, visitTime, leaveTime,time1,time2;

   // private NumberPicker dates, hours, minutes;
     private Button btn_choose , btn_choose2;
    private int _visit_id = 0;
    private Button btnSub, btnclose,btnMingxi;


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.visit_main_add );

        init();
        selectDate();
        String random = RandomNumber.getCode();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder( this ).addApi( AppIndex.API ).build();
    }
    //点击按钮触发事件
    public void selectDate(){
        btn_choose=(Button)this.findViewById( R.id.btn_chooses);
        btn_choose.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                showDialog();
            }
        });
        btn_choose2=(Button)this.findViewById( R.id.btn_chooses2);
        btn_choose2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                showDialog2();
            }
        });

    }
    //弹出框 选择时间
    public void showDialog()
    {
        DateTimePickerDialog dialog  = new DateTimePickerDialog(this, System.currentTimeMillis());
        dialog.setOnDateTimeSetListener(new DateTimePickerDialog.OnDateTimeSetListener()
        {
            public void OnDateTimeSet(AlertDialog dialog, long date)
            {
                visitTime = (EditText) findViewById( R.id.et_visit_visitTime );
                visitTime.setText(getStringDate(date) );
                Toast.makeText(VisitorAddActivity.this, "您输入的日期是："+getStringDate(date), Toast.LENGTH_LONG).show();
            }
        });
        dialog.show();
    }
    /**
     *弹出框 选择时间
     *
     */
    public void showDialog2()
    {
        DateTimePickerDialog dialog  = new DateTimePickerDialog(this, System.currentTimeMillis());
        /**
         * 实现接口
         */
        dialog.setOnDateTimeSetListener(new DateTimePickerDialog.OnDateTimeSetListener()
        {
            public void OnDateTimeSet(AlertDialog dialog, long date)
            {
                leaveTime = (EditText) findViewById( R.id.et_visit_leaveTime );
                leaveTime.setText(getStringDate(date) );
                Toast.makeText(VisitorAddActivity.this, "您输入的日期是："+getStringDate(date), Toast.LENGTH_LONG).show();
            }
        });
        dialog.show();
    }
    /**
     * 将长时间格式字符串转换为时间 yyyy-MM-dd HH:mm:ss
     *
     */
    public static String getStringDate(Long date)
    {
        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(date);

        return dateString;
    }

    public void init() {
        Bundle b = getIntent().getExtras();
        //获取Bundle的信息
        String name2 = b.getString( "name" );
        UserInfoRepo userInfoRepo = new UserInfoRepo( this );
        UserInfo userInfo= userInfoRepo.findUserinfo( name2 );

        btnSub = (Button) findViewById( R.id.btn_visit_sub );
        btnclose = (Button) findViewById( R.id.btn_visit_desc );
        btnMingxi =(Button) findViewById( R.id.btn_visit_mingxi );
        btnSub.setOnClickListener( this );
        btnclose.setOnClickListener( this );
        btnMingxi.setOnClickListener( this );

        createBy = (EditText) findViewById( R.id.et_visit_createBy );
        createBy.setText( name2 );

        department = (EditText) findViewById( R.id.et_visit_department );
        department.setText( userInfo.department );

        crew = (EditText) findViewById( R.id.et_visit_crew );
        crew.setText( userInfo.crew );

        deskclrek = (EditText) findViewById( R.id.et_visit_deskclrek );
        deskclrek.setText( name2 );

        deskclrekPhone = (EditText) findViewById( R.id.et_visit_deskclrekPhone );
        deskclrekPhone.setText( userInfo.phone );

        reason = (EditText) findViewById( R.id.et_visit_reason );
        memo = (EditText) findViewById( R.id.et_visit_memo );

        status = (EditText) findViewById( R.id.et_visit_status );
        status.setText( "ATIVITY" );
        status.setKeyListener(null);

       /* visitTime = (EditText) findViewById( R.id.et_visit_visitTime );
        leaveTime = (EditText) findViewById( R.id.et_visit_leaveTime );*/

       /* Date curDate = new Date();//获取当前时间
        time1= (EditText) findViewById( R.id.et_visit_time1 );
        String   time1s =getStringDate( curDate.getTime() );
        time1.setText(time1s  );
        time2= (EditText) findViewById( R.id.et_visit_time2 );*/
        /*dates = (NumberPicker)  findViewById( R.id.np_date ) ;
        hours = (NumberPicker)  findViewById( R.id.np_hour ) ;
        minutes = (NumberPicker)  findViewById( R.id.np_minute ) ;*/
    }


    public void onClick(View v) {
        String random  =RandomNumber.getCode();
        if (v == findViewById( R.id.btn_visit_sub )) {
            //SimpleDateFormat formatter = new    SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            Bundle b = getIntent().getExtras();
            //获取Bundle的信息
            DateTimePickerDialog dialog  = new DateTimePickerDialog(this, System.currentTimeMillis());
            String name2 = b.getString( "name" );
            SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
            SimpleDateFormat formatter = new SimpleDateFormat( "yyyy年MM月dd日" );
            Date curDate = new Date();//获取当前时间

            String nowsTime = sdf.format( curDate );
            String nowTime = formatter.format( curDate );

            VisitorRepo visitorRepo = new VisitorRepo( this );
            //String a = changeBy.getText().toString();
            // String b = changeTime.getText().toString();
            String c = createBy.getText().toString();
            // String d = createTime.getText().toString();
            String e = department.getText().toString();
            String f = deskclrek.getText().toString();
            String g = deskclrekPhone.getText().toString();
            String h = reason.getText().toString();
            String j = memo.getText().toString();
            String k = status.getText().toString();
            // String m = statusTime.getText().toString();
            String vtime = visitTime.getText().toString();
            String ltime = leaveTime.getText().toString();
            String n = crew.getText().toString();
           /* String time1s = time1.getText().toString();
            String time2s = time2.getText().toString();*/



            String s1 = " 08:30:00";
            String s2 = " 17:00:00";
            if (vtime.equals( "" ) || ltime.equals( "" )) {
                Toast.makeText( this, "输入时间不能为空！", Toast.LENGTH_SHORT ).show();
            }else{
                    String visittimes = vtime; //+ s1;
                    String leavetimes = ltime; //+ s2;
                    Date visittime = null;
                    Date leavetime = null;
                    try {
                        visittime = sdf.parse( visittimes );
                        leavetime = sdf.parse( leavetimes );
                    } catch (ParseException e1) {
                        e1.printStackTrace();
                    }

                if (curDate.getTime()> visittime.getTime() ) {
                    Toast.makeText( this, "您所输入的来访时间不能早于当前时间！", Toast.LENGTH_SHORT ).show();
                    new AlertDialog.Builder( VisitorAddActivity.this ).setTitle( "错误" )
                            .setMessage( "您所输入的来访时间不能早于当前时间" ).setPositiveButton( "确定", null )
                            .show();
                }else  if (curDate.getTime()>leavetime.getTime()) {
                    Toast.makeText( this, "您所输入的离开时间不能早于当前时间！", Toast.LENGTH_SHORT ).show();
                    new AlertDialog.Builder( VisitorAddActivity.this ).setTitle( "错误" )
                            .setMessage( "您所输入的离开时间不能早于当前时间" ).setPositiveButton( "确定", null )
                            .show();
                    return;
                }else if (visittime.getTime()> leavetime.getTime() ) {
                    Toast.makeText( this, "您所输入的离开时间不能早于来访时间！", Toast.LENGTH_SHORT ).show();
                    new AlertDialog.Builder( VisitorAddActivity.this ).setTitle( "错误" )
                            .setMessage( "您所输入的离开时间不能早于来访时间" ).setPositiveButton( "确定", null )
                            .show();
                    return;
                }else{
                    Visitor visitor = new Visitor();
                    visitor.changeBy = name2;
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
                    visitor.visitId = _visit_id;
                    visitor.test2= random;

                    if (_visit_id == 0) {
                        _visit_id = visitorRepo.insert( visitor );
                        Toast.makeText( this, "申请成功,请继续新增访客明细"
                                , Toast.LENGTH_SHORT ).show();
                        new AlertDialog.Builder( VisitorAddActivity.this ).setTitle( "友情提示" )
                                .setMessage( "随机数---"+random ).setPositiveButton( "确定", null )
                                .show();
                        /*Intent intent = new Intent( this, VisitorListActivity.class );
                        startActivity( intent );*/

                    } else {
                        //visitorRepo.update( visitor );
                        Toast.makeText( this, "请重新操作。", Toast.LENGTH_SHORT ).show();
                    }
                }
                }
            }else if(v ==findViewById( R.id.btn_visit_mingxi )){
                Bundle bundle = new Bundle(  );
                bundle.putString( "random",random );
                new AlertDialog.Builder( VisitorAddActivity.this ).setTitle( "友情提示" )
                    .setMessage( "随机数---"+random ).setPositiveButton( "确定", null )
                    .show();
                Intent intent = new Intent( this, VisitorDetailedActivity.class );
                intent.putExtras(bundle  );
                startActivity( intent );
        }
                }




    //创建菜单Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate( R.menu.menu_visit, menu );
        return true;
    }

    //选择菜单Menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_settings:
                Toast.makeText( this, "你点击了我", Toast.LENGTH_SHORT )
                        .show();
                break;
            case R.id.action_go:
                Toast.makeText( this, "你点击了我", Toast.LENGTH_SHORT )
                        .show();
                break;
            case R.id.action_reg:
                Toast.makeText( this, "你点击了我", Toast.LENGTH_SHORT )
                        .show();
                break;
        }

        return super.onOptionsItemSelected( item );
    }


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName( "VisitorAdd Page" ) // TODO: Define a title for the content shown.
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
