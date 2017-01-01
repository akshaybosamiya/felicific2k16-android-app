package org.felicific.application.codesweeper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Cultural_grid extends AppCompatActivity {



    List<ItemObject_gridview> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cultural_grid);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        GridView gridview = (GridView)this.findViewById(R.id.gridview);

        final List<ItemObject_gridview> allItems = getAllItemObject();
        CustomAdapter_Gridview customAdapter = new CustomAdapter_Gridview(Cultural_grid.this, allItems);
        gridview.setAdapter(customAdapter);


        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String selectedItem = items.get(position).getContent().toString();
                selectedItem=selectedItem.toLowerCase();

                Toast.makeText(Cultural_grid.this, selectedItem, Toast.LENGTH_SHORT).show();
                Log.e("PLACeType", selectedItem);
                Intent result = new Intent(Cultural_grid.this, Cultural_result.class);
                    result.putExtra("branch_id", selectedItem);
                startActivity(result);
                //overridePendingTransition(R.anim.slide_in_left, R.anim.slide_in_left);


            }
        });





    }

    private List<ItemObject_gridview> getAllItemObject(){
        ItemObject_gridview itemObject = null;
        items.clear();
        items.add(new ItemObject_gridview("Tuesday", "day1"));
        items.add(new ItemObject_gridview("Wednesday", "day2"));
        items.add(new ItemObject_gridview("Thursday", "day3"));
        items.add(new ItemObject_gridview("Friday", "day4"));
        items.add(new ItemObject_gridview("Shutterbugs", "sb"));
        /*items.add(new ItemObject("Image Three", "three"));
        items.add(new ItemObject("Image Four", "four"));
        items.add(new ItemObject("Image Five", "five"));
        items.add(new ItemObject("Image Six", "six"));
        items.add(new ItemObject("Image Seven", "seven"));
        items.add(new ItemObject("Image Eight", "eight"));
        items.add(new ItemObject("Image One", "one"));
        items.add(new ItemObject("Image Two", "two"));
        items.add(new ItemObject("Image Three", "three"));
        items.add(new ItemObject("Image Four", "four"));
        items.add(new ItemObject("Image Five", "five"));
        items.add(new ItemObject("Image Six", "six"));
        items.add(new ItemObject("Image Seven", "seven"));
        items.add(new ItemObject("Image Eight", "eight"));*/
        return items;
    }





    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // API 5+ solution
                onBackPressed();
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();

        finish();

        //overridePendingTransition(R.anim.slide_out_left, R.anim.slide_out_left);
    }






}
