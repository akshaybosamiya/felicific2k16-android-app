package org.felicific.application.codesweeper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TechActivity extends AppCompatActivity {


    List<ItemObject_gridview> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tech);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        GridView gridview = (GridView)this.findViewById(R.id.gridview);

        final List<ItemObject_gridview> allItems = getAllItemObject();
        CustomAdapter_Gridview customAdapter = new CustomAdapter_Gridview(TechActivity.this, allItems);
        gridview.setAdapter(customAdapter);


        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String selectedItem = items.get(position).getContent().toString();

                Toast.makeText(TechActivity.this, selectedItem, Toast.LENGTH_SHORT).show();
                Log.e("PLACeType", selectedItem);
                Intent result = new Intent(TechActivity.this, Branch_event_details.class);


                if(selectedItem.equalsIgnoreCase("Computer")){
                    result.putExtra("branch_id", "ce");
                }else if(selectedItem.equalsIgnoreCase("Information Technology")){
                    result.putExtra("branch_id", "it");
                }else if(selectedItem.equalsIgnoreCase("Instrumentation & Control")){
                    result.putExtra("branch_id", "ic");
                }else if(selectedItem.equalsIgnoreCase("Mechanical")){
                    result.putExtra("branch_id", "mh");
                }else if(selectedItem.equalsIgnoreCase("Chemical")){
                    result.putExtra("branch_id", "ch");
                }else if(selectedItem.equalsIgnoreCase("Electronics")){
                    result.putExtra("branch_id", "ec");
                }else if(selectedItem.equalsIgnoreCase("Civil")){
                    result.putExtra("branch_id", "cl");
                }else if(selectedItem.equalsIgnoreCase("MBA")){
                    result.putExtra("branch_id", "mba");
                }else if(selectedItem.equalsIgnoreCase("BCA-MCA")){
                    result.putExtra("branch_id", "bca");
                }
                startActivity(result);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_in_left);


            }
        });



    }


    private List<ItemObject_gridview> getAllItemObject(){
        ItemObject_gridview itemObject = null;
        items.clear();
        items.add(new ItemObject_gridview("Computer", "ce"));
        items.add(new ItemObject_gridview("Chemical", "ch"));
        items.add(new ItemObject_gridview("Civil", "civil"));
        items.add(new ItemObject_gridview("Electronics", "ec"));
        items.add(new ItemObject_gridview("Instrumentation & Control", "ic"));
        items.add(new ItemObject_gridview("Information Technology", "it"));
        items.add(new ItemObject_gridview("MBA", "mba"));
        items.add(new ItemObject_gridview("BCA-MCA", "mca"));
        items.add(new ItemObject_gridview("Mechanical", "mech"));
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

      //  overridePendingTransition(R.anim.slide_out_left, R.anim.slide_out_left);
    }






}
