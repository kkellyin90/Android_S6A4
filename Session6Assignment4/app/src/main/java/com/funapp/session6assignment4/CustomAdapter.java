package com.funapp.session6assignment4;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Keith on 7/1/2016.
 */
public class CustomAdapter extends ArrayAdapter {

    Activity context;
    String[] contacts;
    String[] phonenum;

    public CustomAdapter(Activity context, String[] contacts, String[] phonenum) {
        super(context, R.layout.contact2, contacts);
        this.context = context;
        this.contacts = contacts;
        this.phonenum = phonenum;

    }

    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.contact2, null, true);

        TextView text = (TextView) rowView.findViewById(R.id.textName);
        TextView text2 = (TextView) rowView.findViewById(R.id.textNum);

        text.setText(contacts[position]);
        text2.setText(phonenum[position]);

        return rowView;
    }
}
