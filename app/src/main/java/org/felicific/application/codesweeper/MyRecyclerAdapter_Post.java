package org.felicific.application.codesweeper;

import android.app.Dialog;
import android.app.NotificationManager;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

public class MyRecyclerAdapter_Post  extends RecyclerView
        .Adapter<MyRecyclerAdapter_Post
        .DataObject_postHolder> {
    private static String LOG_TAG = "MyRecyclerViewAdapter1";
    private ArrayList<DataObject_post> mDataset;
    private Context mContext;
    NotificationManager mNotifyManager;

    public static class DataObject_postHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        MyTextView tv_eventdate,tv_eventdatemonth,tv_title,tv_team,tv_fees,tv_contact;
        Button btn_view,btn_view_rules;


        public DataObject_postHolder(final View itemView) {
            super(itemView);



            tv_eventdate = (MyTextView) itemView.findViewById(R.id.tv_eventetdate);
            tv_eventdatemonth = (MyTextView) itemView.findViewById(R.id.tv_eventetdate_month);
            tv_title = (MyTextView) itemView.findViewById(R.id.tv_title);
            tv_fees= (MyTextView) itemView.findViewById(R.id.tv_fess);
            tv_team= (MyTextView) itemView.findViewById(R.id.tv_teamsize);
            tv_contact= (MyTextView) itemView.findViewById(R.id.tv_contact);

            btn_view=(Button) itemView.findViewById(R.id.btn_view);
            btn_view_rules=(Button) itemView.findViewById(R.id.btn_view_rules);





            // Log.i(LOG_TAG, "Adding Listener");
            itemView.setOnClickListener(this);





        }

        @Override
        public void onClick(View v) {
       //     myClickListener.onItemClick(getAdapterPosition(), v);
        }
    }

   /* public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }*/

    public MyRecyclerAdapter_Post(ArrayList<DataObject_post> myDataset,Context context) {
        mDataset = myDataset;
        mContext=context;


    }

    @Override
    public DataObject_postHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {

            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_row_cardview_home, parent, false);
            DataObject_postHolder dataObjectHolder = new DataObject_postHolder(view);

             mNotifyManager =
                (NotificationManager) view.getContext().getSystemService(Context.NOTIFICATION_SERVICE);


        return dataObjectHolder;

    }

    @Override
    public void onBindViewHolder(final DataObject_postHolder holder,final int position) {

        String date= mDataset.get(position).getmDate();
        if(date.contains("March")) {
            date = date.substring(0, date.indexOf("Mar") - 1);
            String month = mDataset.get(position).getmDate();
            month = month.substring(month.indexOf("Mar"));


            holder.tv_eventdate.setText(date);
            holder.tv_eventdatemonth.setText(month);
        }else{
            holder.tv_eventdate.setText(mDataset.get(position).getmDate());
            holder.tv_eventdatemonth.setText("");

        }

        holder.tv_title.setText(mDataset.get(position).getmTitle());
        holder.tv_team.setText(mDataset.get(position).getmteam());

        holder.tv_fees.setText(mDataset.get(position).getmFees());
        holder.tv_contact.setText(mDataset.get(position).getmContact());
       // holder.tv_team.setText(mDataset.get(position).getm);







            holder.btn_view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    final Dialog dialog = new Dialog(v.getContext());

                    dialog.setContentView(R.layout.image_post_lyout);

                    dialog.setCanceledOnTouchOutside(true);

                    final MyTextView descript = (MyTextView) dialog.findViewById(R.id.tv_description);

                    descript.setText(mDataset.get(position).getmDescription());



                    dialog.show();
//====================================================================================================
                            //========================================================================================================

                }
            });


        holder.btn_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Dialog dialog = new Dialog(v.getContext());

                dialog.setContentView(R.layout.image_post_lyout);

                dialog.setCanceledOnTouchOutside(true);

                final MyTextView descript = (MyTextView) dialog.findViewById(R.id.tv_description);

                descript.setText(mDataset.get(position).getmDescription());



                dialog.show();
//====================================================================================================
                //========================================================================================================

            }
        });

        holder.btn_view_rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Dialog dialog = new Dialog(v.getContext());

                dialog.setContentView(R.layout.image_post_lyout);

                dialog.setCanceledOnTouchOutside(true);

                final MyTextView descript = (MyTextView) dialog.findViewById(R.id.tv_description);

                descript.setText(mDataset.get(position).getmRules());



                dialog.show();
//====================================================================================================
                //========================================================================================================

            }
        });





    }

    public void addItem(DataObject_post dataObj, int index) {
        mDataset.add(index, dataObj);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }







}