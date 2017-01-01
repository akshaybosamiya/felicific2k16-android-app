package org.felicific.application.codesweeper;

import android.support.v7.app.AppCompatActivity;

public class Splash_screen extends AppCompatActivity {




 /*   final int SPLASH_TIME_OUT = 3500;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);



        //new get_details().execute("http://webappfirm.com/felicific/tech.json");



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Splash_screen.this,
                        Home.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_in_left);
                finish();

            }
        }, SPLASH_TIME_OUT);

    }



    /*class get_details extends AsyncTask<String, Void, String> {

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
            progressDialog = ProgressDialog.show(Splash_screen.this, "Loading", "Please Wait--------.", true, false);
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
                    resp=resp.replace("</br>","");
                    JSONObject	obj = new JSONObject(resp);

                    Log.i("RESPONSE",result);

                    String technical = obj.getString("technical");
                    JSONObject	obj2 = new JSONObject(technical);




                    String ce = obj2.getString("ce");
                    Log.i("computer branch===",ce);
                    String it = obj2.getString("it");
                    Log.i("I.T bracnch",it);
                    String ic = obj2.getString("ic");
                    Log.i("I.C branch",ic);
                    String mh = obj2.getString("mh");
                    String ch = obj2.getString("ch");
                    String ec = obj2.getString("ec");
                    Log.i("ec branch",ec);
                    String cl = obj2.getString("cl");
                    String mba = obj2.getString("mba");
                    String bca = obj2.getString("bca");
                    Log.i("bca brnach",bca);




                    //System.out.println("gteing string are====="+add+"\n"+rcity+"\n"+rzip+"\n"+rgen+"\n"+rdob+"\n"+rphono+"\n"+rphtype);

                *//*    address.setText(add);
                    city.setText(rcity);
                    zipcode.setText(rzip);
                    gender.setSelection(adpter_gender.getPosition(rgen));
                    rdob=rdob.replace("\'", " ");
                    birthday.setText(rdob);
                    phoneno.setText(rphono);
                    phonetype.setSelection(adpter_phonetype.getPosition(rphtype));

                  *//*
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

    }*/






}
