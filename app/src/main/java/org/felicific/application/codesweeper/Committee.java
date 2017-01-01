package org.felicific.application.codesweeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Committee extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_committee);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
