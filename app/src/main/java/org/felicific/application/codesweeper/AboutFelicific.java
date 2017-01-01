package org.felicific.application.codesweeper;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.net.Uri;
import android.widget.Toast;

import java.util.List;


public class AboutFelicific extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_felicific);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Button fb = (Button) findViewById(R.id.fbfeli);

        //Button insta = (Button) findViewById(R.id.instafeli);
        Button gmail = (Button) findViewById(R.id.gmailfeli);

        gmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });


        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openfb();
            }
        });



    }



    protected void openfb() {
        String facebookUrl = "https://www.facebook.com/felicific2k16";
        try {
            int versionCode = AboutFelicific.this.getPackageManager().getPackageInfo("com.facebook.katana", 0).versionCode;
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


    protected void sendEmail() {
        String[] To = {"helpdesk.felicific@gmail.com"};
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);


        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, To);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Felicific Help");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "");


        final PackageManager pm = getPackageManager();
        final List<ResolveInfo> matches = pm.queryIntentActivities(emailIntent, 0);
        ResolveInfo best = null;
        for (final ResolveInfo info : matches)
            if (info.activityInfo.packageName.endsWith(".gm") || info.activityInfo.name.toLowerCase().contains("gmail"))
                best = info;
        if (best != null)
            emailIntent.setClassName(best.activityInfo.packageName, best.activityInfo.name);

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Finished sending email", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(AboutFelicific.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
}
