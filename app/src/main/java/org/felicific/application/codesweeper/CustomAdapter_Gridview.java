package org.felicific.application.codesweeper;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

public class CustomAdapter_Gridview extends BaseAdapter {

    private LayoutInflater layoutinflater;
    private List<ItemObject_gridview> listStorage;
    private Context context;

    public CustomAdapter_Gridview(Context context, List<ItemObject_gridview> customizedListView) {
        this.context = context;
        layoutinflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        listStorage = customizedListView;
    }

    @Override
    public int getCount() {
        return listStorage.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder listViewHolder;
        if(convertView == null){
            listViewHolder = new ViewHolder();
            convertView = layoutinflater.inflate(R.layout.gridview_with_text_image, parent, false);
            listViewHolder.textInListView = (MyTextView)convertView.findViewById(R.id.category_name);
            listViewHolder.imageInListView = (ImageView)convertView.findViewById(R.id.imageView);
            convertView.setTag(listViewHolder);
        }else{
            listViewHolder = (ViewHolder)convertView.getTag();
        }

        listViewHolder.textInListView.setText(listStorage.get(position).getContent());
        int imageResourceId = this.context.getResources().getIdentifier(listStorage.get(position).getImageResource(), "drawable", this.context.getPackageName());
        //Log.d("ImageId", Integer.toString(imageResourceId));
        listViewHolder.imageInListView.setImageResource(imageResourceId);






        return convertView;
    }

    static class ViewHolder{
        MyTextView textInListView;
        ImageView imageInListView;
    }

}