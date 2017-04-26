package com.mycompany.myfirstapp.activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.mycompany.myfirstapp.R;
import com.mycompany.myfirstapp.fragment.Fragment1;
import com.mycompany.myfirstapp.fragment.Fragment2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/10.
 */


public class FragmentActivity extends Activity implements View.OnClickListener {

    private Button movieBtn, tvBtn, animeBtn, varietyBtn;
    private List<Button> btnList = new ArrayList<Button>();
    private FragmentManager fm;
    private FragmentTransaction ft;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.fragment_main );

        findById();

        // 進入系統默認為movie

        fm = getFragmentManager();
        ft = fm.beginTransaction();

        setBackgroundColorById( R.id.movie_btn );

        ft.replace( R.id.fragment_content,new Fragment1() );
        ft.commit();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder( this ).addApi( AppIndex.API ).build();
    }

    private void findById() {
        movieBtn = (Button) this.findViewById( R.id.movie_btn );
        tvBtn = (Button) this.findViewById( R.id.tv_btn );
        animeBtn = (Button) this.findViewById( R.id.anime_btn );
        varietyBtn = (Button) this.findViewById( R.id.variety_btn );
        movieBtn.setOnClickListener( this );
        tvBtn.setOnClickListener( this );
        animeBtn.setOnClickListener( this );
        varietyBtn.setOnClickListener( this );

        btnList.add( movieBtn );
        btnList.add( tvBtn );
        btnList.add( animeBtn );
        btnList.add( varietyBtn );
    }

    private void setBackgroundColorById(int btnId) {
        for (Button btn : btnList) {
            if (btn.getId() == btnId) {
                btn.setBackgroundColor( Color.GREEN );
            } else {
                btn.setBackgroundColor( Color.BLUE );
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this addsitems to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clickshere. The action bar will
        // automatically handle clicks onthe Home/Up button, so long
        // as you specify a parentactivity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        fm = getFragmentManager();
        ft = fm.beginTransaction();
        switch (v.getId()) {

            case R.id.movie_btn:
                setBackgroundColorById(R.id.movie_btn);

                ft.replace(R.id.fragment_content, new Fragment1());
                break;

            case R.id.tv_btn:
                setBackgroundColorById(R.id.tv_btn);

                ft.replace(R.id.fragment_content, new Fragment2());
                break;

            case R.id.anime_btn:
                setBackgroundColorById(R.id.anime_btn);

              //  ft.replace(R.id.fragment_content, new AnimeFragment());
                break;

            case R.id.variety_btn:
                setBackgroundColorById(R.id.variety_btn);

              //  ft.replace(R.id.fragment_content, new VarietyFragment());
                break;

            default:
                break;
        }
        ft.commit();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName( "Fragment Page" ) // TODO: Define a title for the content shown.
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
