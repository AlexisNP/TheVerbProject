package fr.mds.theverbproject.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import fr.mds.theverbproject.R;
import fr.mds.theverbproject.model.Icon;
import fr.mds.theverbproject.utils.IconClickListener;
import fr.mds.theverbproject.viewholder.IconViewHolder;

public class IconsAdapter extends RecyclerView.Adapter<IconViewHolder> {

    private final IconClickListener iconClickListener;
    private List<Icon> iconList = new ArrayList<>();

    public IconsAdapter(List<Icon> iconList, IconClickListener iconClickListener) {
        this.iconList = iconList;
        this.iconClickListener = iconClickListener;
    }

    @Override
    public IconViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.icon_card_view, parent, false);
        return new IconViewHolder(view);
    }

    @Override
    public void onBindViewHolder(IconViewHolder holder, int position) {
        Icon icon = this.iconList.get(position);
        holder.bind(icon, iconClickListener);
    }

    @Override
    public int getItemCount() {
//        if (iconList == null) {
//            return -1;
//        } else {
            return this.iconList.size();
//        }
    }

    @Override
    public void onViewRecycled(IconViewHolder holder) {
        super.onViewRecycled(holder);
    }

    public void filterList(ArrayList<Icon> filteredList) {
        iconList = filteredList;
        notifyDataSetChanged();
    }
}
