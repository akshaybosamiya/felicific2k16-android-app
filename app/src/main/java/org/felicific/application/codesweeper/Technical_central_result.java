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

public class Technical_central_result extends AppCompatActivity {


    CustomRecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;


    ArrayList results;
    String get_intent;

    String[] number = { "first", "second", "third", "forth","fifth","sixth","seventh","eighth","ninth","tenth"
            ,"eleventh","twelveth" };


    MyTextView totalresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_echnical_central_result);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        get_intent = getIntent().getStringExtra("branch_id").toString();

        totalresult= (MyTextView)this.findViewById(R.id.tv_totalresult);
        totalresult.setText("Event's Details of "+get_intent);

        Log.d("got branch ID---",get_intent);

        /*String url_codejam="http://felicific.org/2016/android/coding.json";
        String url_robo="http://felicific.org/2016/android/robotics.json";
        String url_hunt="http://felicific.org/2016/android/huntronics.json";
        String url_game="http://felicific.org/2016/android/centralgaming.json";*/


        results = new ArrayList<DataObject_post>();
        mAdapter = new MyRecyclerAdapter_Post(results, getBaseContext());

        if(get_intent.equalsIgnoreCase("code jam")){
            new get_details().execute(AppConfig.CODEJAM_JSON);
        }else if(get_intent.equalsIgnoreCase("huntronics")){
            new get_details().execute(AppConfig.HUNT_JSON);
        }else if(get_intent.equalsIgnoreCase("robotics")){
            new get_details().execute(AppConfig.ROBO_JSON);
        }else if(get_intent.equalsIgnoreCase("gaming")){
            new get_details().execute(AppConfig.GAME_JSON);
        }
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

            //inicia diálogo de progresso, mostranto processamento com servidor.
            progressDialog = ProgressDialog.show(Technical_central_result.this, "Loading", "Please Wait.....", true, false);
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


                    mRecyclerView.setAdapter(mAdapter);

                    if(get_intent.equalsIgnoreCase("code jam")){

                        String technical = obj.getString("coding");
                        JSONObject	obj2 = new JSONObject(technical);



                        Log.i("bca brnach",technical);



                            String Pdate=obj2.getString("date");
                            String Ptitle=obj2.getString("name");
                            String Pfee=obj2.getString("fees");
                            String Pteam=obj2.getString("teamsize");
                            String Pcontact=obj2.getString("contact");
                            String Pdisc=obj2.getString("description");
                            String Prules=obj2.getString("rules");

                            DataObject_post post_1 = new DataObject_post(Pdate ,Ptitle,"Fees: "+Pfee,"Team: "+Pteam,
                                    "Contact: "+Pcontact,Pdisc,Prules);
                            results.add(post_1);



                    }else if(get_intent.equalsIgnoreCase("huntronics")){



                        String technical = obj.getString("huntronics");
                        JSONObject	obj2 = new JSONObject(technical);



                        Log.i("bca brnach",technical);



                        String Pdate=obj2.getString("date");
                        String Ptitle=obj2.getString("name");
                        String Pfee=obj2.getString("fees");
                        String Pteam=obj2.getString("teamsize");
                        String Pcontact=obj2.getString("contact");
                        String Pdisc=obj2.getString("description");
                        String Prules=obj2.getString("rules");

                        DataObject_post post_1 = new DataObject_post(Pdate ,Ptitle,"Fees: "+Pfee,"Team: "+Pteam,
                                "Contact: "+Pcontact,Pdisc,Prules);
                        results.add(post_1);
                    }else if(get_intent.equalsIgnoreCase("robotics")){

                        String technical = obj.getString("Robotics");
                        JSONObject	obj3 = new JSONObject(technical);




                        int event_no=4;

                        for (int j=0;j<event_no;j++){

                            JSONObject obj4= new JSONObject(obj3.getString(number[j]));

                            String Pdate=obj4.getString("date");
                            String Ptitle=obj4.getString("name");
                            String Pfee=obj4.getString("fees");
                            String Pteam=obj4.getString("teamsize");
                            String Pcontact=obj4.getString("contact");
                            String Pdisc=obj4.getString("description");
                            String Prules=obj4.getString("rules");

                            DataObject_post post_1 = new DataObject_post(Pdate ,Ptitle,"Fees: "+Pfee,"Team: "+Pteam,
                                    "Contact: "+Pcontact,Pdisc,Prules);
                            results.add(post_1);


                        }
                    }else
                    if(get_intent.equalsIgnoreCase("gaming")){


                        String technical = obj.getString("Gaming");
                        JSONObject	obj2 = new JSONObject(technical);



                        Log.i("bca brnach",technical);



                        String Pdate=obj2.getString("date");
                        String Ptitle=obj2.getString("name");
                        String Pfee=obj2.getString("fees");
                        String Pteam=obj2.getString("teamsize");
                        String Pcontact=obj2.getString("contact");
                        String Pdisc=obj2.getString("description");
                        String Prules=obj2.getString("rules");

                        DataObject_post post_1 = new DataObject_post(Pdate ,Ptitle,"Fees: "+Pfee,"Team: "+Pteam,
                                "Contact: "+Pcontact,Pdisc,Prules);
                        results.add(post_1);


                    }






                    //System.out.println("gteing string are====="+add+"\n"+rcity+"\n"+rzip+"\n"+rgen+"\n"+rdob+"\n"+rphono+"\n"+rphtype);

                /*    address.setText(add);
                    city.setText(rcity);
                    zipcode.setText(rzip);
                    gender.setSelection(adpter_gender.getPosition(rgen));
                    rdob=rdob.replace("\'", " ");
                    birthday.setText(rdob);
                    phoneno.setText(rphono);
                    phonetype.setSelection(adpter_phonetype.getPosition(rphtype));

                  */
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

