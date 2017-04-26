package com.mycompany.myfirstapp.activity_new;

import android.app.Activity;
import android.content.Intent;
import android.media.audiofx.Visualizer;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mycompany.myfirstapp.R;
import com.mycompany.myfirstapp.entity.Visitor;
import com.mycompany.myfirstapp.utils.UserInfoRepo;
import com.mycompany.myfirstapp.utils.VisitorRepo;

/**
 * Created by Administrator on 2017/4/20.
 */

public class VisitorInfoActivity extends Activity implements View.OnClickListener{

    private TextView visitid, createTime, createBy, changeBy, changeTime,
            department, crew, deskclrek, deskclrekPhone, reason, memo, status, statusTime, visitTime, leaveTime;

    private Button btndel,btncloss,btnupp;

    private int visit_id = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.visit_info );

        //根据控件的ID得到响应的控件对象
        changeBy =(TextView) findViewById( R.id.tv_visitinfo_changeby );
        createTime =(TextView) findViewById( R.id.tv_visitinfo_createtime );
        createBy =(TextView) findViewById( R.id.tv_visitinfo_createby );
        changeTime =(TextView) findViewById( R.id.tv_visitinfo_changetime );
        department =(TextView) findViewById( R.id.tv_visitinfo_dept );
        crew =(TextView) findViewById( R.id.tv_visitinfo_crew );
        deskclrek =(TextView) findViewById( R.id.tv_visitinfo_desk );
        deskclrekPhone =(TextView) findViewById( R.id.tv_visitinfo_deskphone );
        reason =(TextView) findViewById( R.id.tv_visitinfo_reason );
        memo =(TextView) findViewById( R.id.tv_visitinfo_memo );
        status =(TextView) findViewById( R.id.tv_visitinfo_status );
        statusTime =(TextView) findViewById( R.id.tv_visitinfo_statustime );
        visitTime =(TextView) findViewById( R.id.tv_visitinfo_visittime );
        leaveTime =(TextView) findViewById( R.id.tv_visitinfo_leavetime );
        visitid=(TextView) findViewById( R.id.tv_visitinfo_id );

        btnupp = (Button) findViewById( R.id.btn_visitinfo_upp);
        btncloss = (Button) findViewById( R.id.btn_visitinfo_closs);
        btndel = (Button) findViewById( R.id.btn_visitinfo_del);

        btnupp.setOnClickListener( this );
        btncloss.setOnClickListener( this );
        btndel.setOnClickListener( this );

        Intent intent = getIntent();
        visit_id =intent.getIntExtra("visitId", 0);

        show(visit_id);
    }

    public void show(int visit_id){
        VisitorRepo visitorRepo = new VisitorRepo( this );
        Visitor v = visitorRepo.getById( visit_id );

        visitid.setText( String.valueOf( v.getVisitId()  ) );
        createTime.setText( v.getCreateTime() );
        createBy.setText( v.getCreateBy() );
        changeBy.setText( v.getChangeBy() );
        changeTime.setText( v.getChangeTime() );;
        department.setText( v.getDepartment() );
        crew.setText( v.getCrew() );
        deskclrek.setText( v.getDeskclrek() );
        deskclrekPhone.setText( v.getDeskclrekPhone() );
        reason.setText( v.getReason() );
        memo.setText( v.getMemo() );
        status.setText( v.getStatus() );
        statusTime.setText( v.getStatusTime() );
        visitTime.setText( v.getVisitTime() );
        leaveTime.setText( v.getLeaveTime() );

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_visitinfo_del:
                VisitorRepo repo = new VisitorRepo( this );
                repo.delete( visit_id );
                Toast.makeText(getApplicationContext(), "\"UserInfoRepo Record Deleted", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(VisitorInfoActivity.this,VisitorListActivity.class);
                startActivity(i);
                break;
            case R.id.btn_visitinfo_closs:
                finish();
                break;
            case R.id.btn_visitinfo_upp:
                String name = createBy.getText().toString();
                String statu =status.getText().toString();
                String visitids =visitid.getText().toString();
                String createBys =createBy.getText().toString();
                String createTimes =createTime.getText().toString();
                String changeBys =changeBy.getText().toString();
                String changeTimes =changeTime.getText().toString();
                String departments =department.getText().toString();
                String deskclrekPhones =deskclrekPhone.getText().toString();
                String crews =crew.getText().toString();
                String deskclreks =deskclrek.getText().toString();
                String reasons =reason.getText().toString();
                String memos =memo.getText().toString();
                String statusTimes =statusTime.getText().toString();
                String visitTimes =visitTime.getText().toString();
                String leaveTimes =leaveTime.getText().toString();



                Bundle b =new Bundle();

                b.putString( "name",name );
                b.putInt( "visitids",visit_id );
                b.putString( "createBys",createBys );
                b.putString( "createTimes",createTimes );
                b.putString( "changeBys",changeBys );
                b.putString( "changeTimes",changeTimes );
                b.putString( "departments",departments );
                b.putString( "deskclrekPhones",deskclrekPhones );
                b.putString( "crews",crews );
                b.putString( "deskclreks",deskclreks );
                b.putString( "reasons",reasons );
                b.putString( "memos",memos );
                b.putString( "statusTimes",statusTimes );
                b.putString( "visitTimes",visitTimes );
                b.putString( "leaveTimes",leaveTimes );
                b.putString( "status",statu );

                Intent i2 = new Intent(VisitorInfoActivity.this,VisitorUpdateActivity.class);
                i2.putExtras(b  );
                startActivity(i2);
                break;
        }
    }
}
