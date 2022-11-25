package com.example.juicify;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class JuiceAdapter extends ArrayAdapter<Juice> {
    public JuiceAdapter(Context context, ArrayList<Juice> juiceAdapterArrayList){
        super(context,0,juiceAdapterArrayList);
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        Juice juice = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_juice_adapter, parent, false);
        }

        TextView tvName = (TextView)convertView.findViewById(R.id.songTextView);
        TextView tvPosition = (TextView)convertView.findViewById(R.id.eraTextView);

        tvName.setText(juice.getSong());
        tvPosition.setText(juice.getEra());

        return convertView;

    }

}


