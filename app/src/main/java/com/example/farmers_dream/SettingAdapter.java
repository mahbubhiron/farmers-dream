package com.example.farmers_dream;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class SettingAdapter extends BaseAdapter {
    int[] img;
    String[] setting_name;
    Context context;
    private LayoutInflater inflater;
    SettingAdapter(Context context, int[] img, String[] setting_name){
        this.context = context;
        this.img = img;
        this.setting_name = setting_name;
    }
    @Override
    public int getCount() {
        return setting_name.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        if (convertView == null){
            inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.settings_sample,parent,false);
        }
        ImageView imageView = convertView.findViewById(R.id.setting_image_id);
        TextView textView = convertView.findViewById(R.id.setting_text_id);

        imageView.setImageResource(img[position]);
        textView.setText(setting_name[position]);
        return convertView;
    }
}
