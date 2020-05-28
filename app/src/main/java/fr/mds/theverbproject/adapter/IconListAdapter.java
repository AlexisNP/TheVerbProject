package fr.mds.theverbproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import java.util.ArrayList;

import fr.mds.theverbproject.R;
import fr.mds.theverbproject.model.Icon;

public class IconListAdapter extends ArrayAdapter<Icon> {

    public IconListAdapter(Context context, ArrayList<Icon> listIcons) {
        super(context, 0, listIcons);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Icon icon = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_icon, parent, false);
        }

//        RelativeLayout rl_container_icon = convertView.findViewById(R.id.rl_container_icon);
//        ImageView iv_icon = convertView.findViewById(R.id.iv_icon);


//        iv_icon.setText(icon.getPreview_url());
//        tv_date.setText(formatter.format(quote.getCreationDate()));

        return convertView;
    }
}
