package org.felicific.application.codesweeper;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;

public class Branch_event_details extends AppCompatActivity {


    CustomRecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;


    ArrayList results;
    String get_intent;

    String[] number = { "first", "second", "third", "forth","fifth","sixth","seventh","eighth","ninth","tenth"
            ,"eleventh","twelveth" };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branch_event_details);



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        get_intent = getIntent().getStringExtra("branch_id").toString();

        MyTextView totalresult= (MyTextView)this.findViewById(R.id.tv_totalresult);
        totalresult.setText("Event Details of " + get_intent);

        Log.d("got branch ID---",get_intent);


        results = new ArrayList<DataObject_post>();
        mAdapter = new MyRecyclerAdapter_Post(results, getBaseContext());
        //new get_details().execute("http://webappfirm.com/felicific/tech.json");
        //new get_details().execute("http://felicific.org/2016/android/tech.json");
        new get_details().execute(AppConfig.TECH_JSON);
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
            progressDialog = ProgressDialog.show(Branch_event_details.this, "Loading", "Please Wait....", true, false);
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



                    String technical = obj.getString("technical");
                    JSONObject	obj2 = new JSONObject(technical);



                    mRecyclerView.setAdapter(mAdapter);
                    String branch="";
                    if(get_intent.equalsIgnoreCase("ce")){

                        branch = obj2.getString("ce");
                        Log.i("computer branch===",branch);
                    }else if(get_intent.equalsIgnoreCase("it")){

                        branch = obj2.getString("it");
                        Log.i("I.T bracnch",branch);
                    }else if(get_intent.equalsIgnoreCase("ic")){

                        branch = obj2.getString("ic");
                        Log.i("I.C branch",branch);

                    }else if(get_intent.equalsIgnoreCase("mh")){

                        branch = obj2.getString("mh");
                    }else if(get_intent.equalsIgnoreCase("ch")){

                        branch = obj2.getString("ch");
                    }else if(get_intent.equalsIgnoreCase("ec")){

                        branch = obj2.getString("ec");
                        Log.i("ec branch",branch);
                    }else if(get_intent.equalsIgnoreCase("cl")){
                        branch = obj2.getString("cl");
                    }else if(get_intent.equalsIgnoreCase("mba")){

                        branch = obj2.getString("mba");
                    }else if(get_intent.equalsIgnoreCase("bca")){

                        branch = obj2.getString("bca");
                        Log.i("bca brnach",branch);
                    }

                    JSONObject obj3 = new JSONObject(branch);

                    String event_count=obj3.getString("totalevent");

                    int event_no=Integer.parseInt(event_count);

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
