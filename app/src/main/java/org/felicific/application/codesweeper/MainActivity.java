package org.felicific.application.codesweeper;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
   protected DrawerLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        if(isOnline())
        {

        }
        else
        {
            Toast.makeText(MainActivity.this, "A Internet connection isn't available", Toast.LENGTH_SHORT).show();
        }





        CardView c= (CardView) findViewById(R.id.card_tech);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, TechActivity.class);
                startActivity(intent);

            }
        });
        CardView c1 = (CardView) findViewById(R.id.card_conf);
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,NcrttmActivity.class);
                startActivity(intent);

            }
        });

        CardView c2 = (CardView) findViewById(R.id.card_cultural);
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,Cultural_grid.class);
                startActivity(intent);

            }
        });

        CardView c3 = (CardView) findViewById(R.id.card_techcult);
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,Technical_centeral.class);
                startActivity(intent);

            }
        });


    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    protected boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        } else {
            return false;
        }
    }


  /*  @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will

        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       // if (id == R.id.action_settings) {
         //   return true;
        }

        //return super.onOptionsItemSelected(item);
    }*/
  Fragment f=null;
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.technical) {
            // Handle the camera action
            Intent intent = new Intent(MainActivity.this,TechActivity.class);
            startActivity(intent);

        } else if (id == R.id.centraltech) {

            Intent intent = new Intent(MainActivity.this,Technical_centeral.class);
            startActivity(intent);


        } else if (id == R.id.cultural) {

            Intent intent = new Intent(MainActivity.this,Cultural_grid.class);
            startActivity(intent);
        } else if (id == R.id.conference) {
            Intent intent = new Intent(MainActivity.this,NcrttmActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_share) {

            Toast.makeText(MainActivity.this, "Good!! Share It!!", Toast.LENGTH_SHORT).show();

            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "Felicific 2016 Application: http://felicific.org/2016/android/felicific16.apk";
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, "Share via"));

        } else if (id == R.id.aboutus) {
            Intent intent = new Intent(MainActivity.this,AboutusActivity.class);
            startActivity(intent);

        }
        else if(id==R.id.abtfeli){
            Intent intent = new Intent(MainActivity.this,AboutFelicific.class);
            startActivity(intent);

        }
        else if(id==R.id.team){
            //Toast.makeText(MainActivity.this, "Committe clicked", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this,Committee.class);
            startActivity(intent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
