package com.mycompany.myfirstapp.activity_new;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import com.mycompany.myfirstapp.R;
import com.mycompany.myfirstapp.utils.VisitorRepo;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Administrator on 2017/4/17.
 */

public class VisitorListActivity extends ListActivity{

    private TextView tv_visit_createby,tv_visit_changeby,tv_visit_status,tv_visit_deskclrek,tv_visit_deskclrekphone,
            tv_visit_department,tv_visit_crew,tv_visit_reason,tv_visit_createtime,tv_visit_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.visit_main );
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_visitlist);
        toolbar.setTitle("访客单申请列表");//设置主标题
        toolbar.inflateMenu(R.menu.menu_visit);//设置右上角的填充菜单
       show();
    }
    public void show(){
        VisitorRepo repo = new VisitorRepo(this);
        ArrayList<HashMap<String, String>> visitorList =  repo.getVisitorList();

        ListView lv = getListView();
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tv_visit_id = (TextView) view.findViewById(R.id.tv_visitor_id);
                String visitId = tv_visit_id.getText().toString();
                Intent objIndent = new Intent(getApplicationContext(),VisitorInfoActivity.class);
                objIndent.putExtra("visitId", Integer.parseInt( visitId));
                startActivity(objIndent);
            }
        });
        ListAdapter adapter = new SimpleAdapter(VisitorListActivity.this,visitorList, R.layout.visit_item,
                new String[] { "visitId","createBy","createTime","department","crew","deskclrek","deskclrekPhone","status","reason","changeBy"},
                new int[] {R.id.tv_visitor_id, R.id.tv_visit_createby,R.id.tv_visit_createtime,R.id.tv_visit_department,R.id.tv_visit_crew,
                        R.id.tv_visit_deskclrek,R.id.tv_visit_deskclrekphone,R.id.tv_visit_status2,R.id.tv_visit_reason,R.id.tv_visit_changeby});
        setListAdapter( adapter );
    }


}
