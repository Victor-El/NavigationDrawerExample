package me.codeenzyme.navigationdrawerexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DrawerArrayAdapter extends ArrayAdapter<String> {
    private String[] objs;
    private Context context;


    public DrawerArrayAdapter(@NonNull Context context, @NonNull String[] objects) {
        super(context, 0, objects);
        this.objs = objects;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;

        if (listItemView == null)
            listItemView = LayoutInflater.from(context).inflate(R.layout.single_item_view, parent, false);

        ( (TextView) listItemView.findViewById(R.id.single_item_tv)).setText(objs[position]);

        return listItemView;
    }
}
