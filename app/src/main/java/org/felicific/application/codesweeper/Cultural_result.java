package org.felicific.application.codesweeper;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;

public class Cultural_result extends AppCompatActivity {

    CustomRecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;


    ArrayList results;
    String get_intent;

    String[] number = { "first", "second", "third", "fourth","fifth","sixth","seventh","eighth","ninth","tenth"
            ,"eleventh","twelveth" };
    

    MyTextView totalresult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cultural_result);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        get_intent = getIntent().getStringExtra("branch_id").toString();

        totalresult= (MyTextView)this.findViewById(R.id.tv_totalresult);

        Log.d("got branch ID---",get_intent);


        results = new ArrayList<DataObject_post>();
        mAdapter = new MyRecyclerAdapter_Post(results, getBaseContext());
        //new get_details().execute("http://webappfirm.com/felicific/cultural.json");
        //http://felicific.org/2016/android/cultural.json
        //new get_details().execute("http://felicific.org/2016/android/cultural.json");
        //new get_details().execute("http://felicific.org/2016/android/culturalsb.json");
        new get_details().execute(AppConfig.CULTURAL_JSON);
        // Initialize recycler view
        mRecyclerView = (CustomRecyclerView) findViewById(R.id.eventdetails);
        mRecyclerView.setHasFixedSize(true);


        final LinearLayoutManager mLayoutManager;
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);



    }

    class get_details extends AsyncTask<String, Void, String> {

        private final static String TAG = "LoginActivity";

        protected ProgressDialog progressDialog;
        private URLSuppoter SuppURL;

        @Override
        protected void onPreExecute()
        {


            System.out.println("On PRe Execute----done-------");
            super.onPreExecute();
            Log.d(TAG, "Executan do onPreExecute de EfetuaLogin");

            
            progressDialog = ProgressDialog.show(Cultural_result.this, "Loading", "Please Wait....", true, false);
        }


        @Override
        protected String doInBackground(String... urls) {

            System.out.println("On do in back ground----done-------");
            InputStream inputStream = null;
            Log.d(TAG, "Executando doInBackground de EfetuaLogin");
            SuppURL = new URLSuppoter();
            return SuppURL.GET(urls[0]);

        }


        @Override
        protected void onPostExecute(String result)
        {

            super.onPostExecute(result);

            System.out.println("OnpostExecute----done-------");

            Log.d(TAG, "Login passou persistindo info de login local no device");

            if(result.isEmpty() || result == null){


                progressDialog.dismiss();

            }

            else{


                try {
                    String resp= result.toString().replace("\\\\","");

                    JSONObject obj = new JSONObject(resp);

                    Log.i("RESPONSE",result);



                    String technical = obj.getString("cultural");
                    JSONObject	obj2 = new JSONObject(technical);



                    mRecyclerView.setAdapter(mAdapter);
                    String branch="";
                    if(get_intent.equalsIgnoreCase("tuesday")){

                        branch = obj2.getString("tuesday");
                        Log.i("computer branch===",branch);



                        JSONObject obj3 = new JSONObject(branch);

                        String event_date=obj3.getString("date");
                        totalresult.setText("Cultural Event of "+event_date);


                        String event_host=obj3.getString("host");


                        int event_no=11;

                        for (int j=0;j<event_no;j++){

                            JSONObject obj4= new JSONObject(obj3.getString(number[j]));

                            String Ptitle=obj4.getString("name");
                            String Pfee=obj4.getString("tagline");
                            String Pteam=obj4.getString("time");
                            String Pcontact=obj4.getString("coordinators");
                            String Pdisc=obj4.getString("description");
                            String Prules=obj4.getString("rules");
                            String Pvanue=obj4.getString("venue");


                            DataObject_post post_1 = new DataObject_post(event_host ,Ptitle,"Tag lines: "+Pfee,"Time: "+Pteam+"\nVenue: "+Pvanue,
                                    "Coordinators: "+Pcontact,Pdisc,Prules);
                            results.add(post_1);


                        }



                    }else if(get_intent.equalsIgnoreCase("wednesday")){


                        branch = obj2.getString("wednesday");
                        Log.i("computer branch===",branch);



                        JSONObject obj3 = new JSONObject(branch);

                        String event_date=obj3.getString("date");
                        totalresult.setText("Cultural Event of "+event_date);


                        String event_host=obj3.getString("host");


                        int event_no=11;

                        for (int j=0;j<event_no;j++){

                            JSONObject obj4= new JSONObject(obj3.getString(number[j]));

                            String Ptitle=obj4.getString("name");
                            String Pfee=obj4.getString("tagline");
                            String Pteam=obj4.getString("time");
                            String Pcontact=obj4.getString("coordinators");
                            String Pdisc=obj4.getString("description");
                            String Prules=obj4.getString("rules");
                            String Pvanue=obj4.getString("venue");


                            DataObject_post post_1 = new DataObject_post(event_host ,Ptitle,"Tag lines: "+Pfee,"Time: "+Pteam+"\nVenue: "+Pvanue,
                                    "Coordinators: "+Pcontact,Pdisc,Prules);
                            results.add(post_1);


                        }

                    }else if(get_intent.equalsIgnoreCase("thursday")){


                        branch = obj2.getString("thursday");
                        Log.i("computer branch===",branch);



                        JSONObject obj3 = new JSONObject(branch);

                        String event_date=obj3.getString("date");
                        totalresult.setText("Cultural Event of "+event_date);


                        String event_host=obj3.getString("host");


                        int event_no=7;

                        for (int j=0;j<event_no;j++){

                            JSONObject obj4= new JSONObject(obj3.getString(number[j]));

                            String Ptitle=obj4.getString("name");
                            String Pfee=obj4.getString("tagline");
                            String Pteam=obj4.getString("time");
                            String Pcontact=obj4.getString("coordinators");
                            String Pdisc=obj4.getString("description");
                            String Prules=obj4.getString("rules");
                            String Pvanue=obj4.getString("venue");


                            DataObject_post post_1 = new DataObject_post(event_host ,Ptitle,"Tag lines: "+Pfee,"Time: "+Pteam+"\nVenue: "+Pvanue,
                                    "Coordinators: "+Pcontact,Pdisc,Prules);
                            results.add(post_1);


                        }
                    }else if(get_intent.equalsIgnoreCase("friday")){



                        branch = obj2.getString("friday");
                        Log.i("computer branch===",branch);



                        JSONObject obj3 = new JSONObject(branch);

                        String event_date=obj3.getString("date");
                        totalresult.setText("Cultural Event of "+event_date);


                        String event_host=obj3.getString("host");


                        int event_no=8;

                        for (int j=0;j<event_no;j++){

                            JSONObject obj4= new JSONObject(obj3.getString(number[j]));

                            String Ptitle=obj4.getString("name");
                            String Pfee=obj4.getString("tagline");
                            String Pteam=obj4.getString("time");
                            String Pcontact=obj4.getString("coordinators");
                            String Pdisc=obj4.getString("description");
                            String Prules=obj4.getString("rules");
                            String Pvanue=obj4.getString("venue");


                            DataObject_post post_1 = new DataObject_post(event_host ,Ptitle,"Tag lines: "+Pfee,"Time: "+Pteam+"\nVenue: "+Pvanue,
                                    "Coordinators: "+Pcontact,Pdisc,Prules);
                            results.add(post_1);


                        }
                    }else  if(get_intent.equalsIgnoreCase("shutterbugs")){

                        branch = obj2.getString("shutterbugs");
                        Log.i("computer branch===",branch);



                        JSONObject obj3 = new JSONObject(branch);
                        totalresult.setText("Shutterbugs Events");

                        int event_no=3;

                        for (int j=0;j<event_no;j++){
                            JSONObject obj4= new JSONObject(obj3.getString(number[j]));

                            String Pdate=obj4.getString("data");
                            String Ptitle=obj4.getString("name");
                            String Pfee=obj4.getString("fees");
                            //String Pteam=obj4.getString("teamsize");
                            String Pcontact=obj4.getString("contact");
                            String Pdisc=obj4.getString("description");
                            String Prules=obj4.getString("rules");

                            DataObject_post post_1 = new DataObject_post(Pdate ,Ptitle,"Fees: "+Pfee,"Team: ",
                                    "Contact: "+Pcontact,Pdisc,Prules);
                            results.add(post_1);
                        }

                    }


                    progressDialog.dismiss();



                }

                catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                catch (Exception e2) {
                    // TODO Auto-generated catch block
                    e2.printStackTrace();
                }

                progressDialog.dismiss();
            }

        }

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
       // overridePendingTransition(R.anim.slide_out_left, R.anim.slide_out_left);


    }
}
