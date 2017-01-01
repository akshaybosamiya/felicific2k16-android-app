package org.felicific.application.codesweeper;


import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class AboutusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button img_fb= (Button) findViewById(R.id.img_f);
        Button img_t = (Button)findViewById(R.id.img_t);


        Button img_fbv= (Button) findViewById(R.id.fbfeli);
        Button img_tv = (Button)findViewById(R.id.img_t1);

        Button tvrfb = (Button) findViewById(R.id.tvrsirfb);


        img_fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Test", "onClickListener ist gestartet");
                String facebookUrl = "https://www.facebook.com/akshaybosamiya";
                try {
                    int versionCode = AboutusActivity.this.getPackageManager().getPackageInfo("com.facebook.katana", 0).versionCode;
                    if (versionCode >= 3002850) {
                        Uri uri = Uri.parse("fb://facewebmodal/f?href=" + facebookUrl);
                        startActivity(new Intent(Intent.ACTION_VIEW, uri));
                        ;
                    } else {
                        // open the Facebook app using the old method (fb://profile/id or fb://pro
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    // Facebook is not installed. Open the browser
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(facebookUrl)));
                }
            }
        });

        img_t.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                try {
                    // Check if the Twitter app is installed on the phone.
                    AboutusActivity.this.getPackageManager().getPackageInfo("com.twitter.android", 0);

                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setClassName("com.twitter.android", "com.twitter.android.ProfileActivity");
                    // Don't forget to put the "L" at the end of the id.
                    intent.putExtra("user_id", 2915276197L);
                    startActivity(intent);
                } catch (PackageManager.NameNotFoundException e) {
                    // If Twitter app is not installed, start browser.
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/arbosamiya")));
                }
            }
        });



        img_fbv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Test", "onClickListener ist gestartet");
                String facebookUrl = "https://www.facebook.com/vimox.shah";
                try {
                    int versionCode = AboutusActivity.this.getPackageManager().getPackageInfo("com.facebook.katana", 0).versionCode;
                    if (versionCode >= 3002850) {
                        Uri uri = Uri.parse("fb://facewebmodal/f?href=" + facebookUrl);
                        startActivity(new Intent(Intent.ACTION_VIEW, uri));
                        ;
                    } else {
                        // open the Facebook app using the old method (fb://profile/id or fb://pro
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    // Facebook is not installed. Open the browser
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(facebookUrl)));
                }
            }
        });

        img_tv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                try {
                    // Check if the Twitter app is installed on the phone.
                    AboutusActivity.this.getPackageManager().getPackageInfo("com.twitter.android", 0);

                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setClassName("com.twitter.android", "com.twitter.android.ProfileActivity");
                    // Don't forget to put the "L" at the end of the id.
                    intent.putExtra("user_id", 280942481L);
                    startActivity(intent);
                } catch (PackageManager.NameNotFoundException e) {
                    // If Twitter app is not installed, start browser.
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/Vimox_shah")));
                }
            }
        });

        tvrfb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Test", "onClickListener ist gestartet");
                String facebookUrl = "https://www.facebook.com/tushar.ratanpara";
                try {
                    int versionCode = AboutusActivity.this.getPackageManager().getPackageInfo("com.facebook.katana", 0).versionCode;
                    if (versionCode >= 3002850) {
                        Uri uri = Uri.parse("fb://facewebmodal/f?href=" + facebookUrl);
                        startActivity(new Intent(Intent.ACTION_VIEW, uri));
                        ;
                    } else {
                        // open the Facebook app using the old method (fb://profile/id or fb://pro
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    // Facebook is not installed. Open the browser
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(facebookUrl)));
                }
            }
        });

    }
}
