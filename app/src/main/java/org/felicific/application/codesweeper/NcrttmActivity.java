package org.felicific.application.codesweeper;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NcrttmActivity extends AppCompatActivity {

    Button bro1,ppr1,sample1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ncrttm);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        bro1 = (Button) findViewById(R.id.bro);
        ppr1 = (Button) findViewById(R.id.ppr);
        sample1 = (Button) findViewById(R.id.sample);


        bro1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/file/d/0B3XoeJ1CSNuPLXVGVVZ6Z1Fobmc/view")));



            }
        });

        ppr1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/open?id=0B4sgi_l6SWkBbHlrTmxFc0tCQU0")));

            }
        });

        sample1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://felicific.org/2016/m/downloads/sample%20poster%20NCRTEM16.pdf")));

            }
        });




    }
}
