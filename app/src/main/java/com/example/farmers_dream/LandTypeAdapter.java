package com.example.farmers_dream;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class LandTypeAdapter extends BaseAdapter {

    Context context;
    int[] area_img;
    String[] area_name;
    private LayoutInflater inflater;
    LandTypeAdapter(Context context,int[] area_img,String[] area_name){
        this.context = context;
        this.area_img = area_img;
        this.area_name = area_name;
    }
    @Override
    public int getCount() {
        return area_name.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null){

            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.land_type_sample,viewGroup,false);

        }

        ImageView imageView = view.findViewById(R.id.imageview_id);
        TextView textView = view.findViewById(R.id.textview_id);

        imageView.setImageResource(area_img[i]);
        textView.setText(area_name[i]);

        return view;
    }
}
