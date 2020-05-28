package fr.mds.theverbproject.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import fr.mds.theverbproject.R;
import fr.mds.theverbproject.model.Collection;
import fr.mds.theverbproject.utils.CollectionClickListener;
import fr.mds.theverbproject.viewholder.CollectionViewHolder;

public class CollectionsAdapter extends RecyclerView.Adapter<CollectionViewHolder> {

    private final CollectionClickListener collectionClickListener;
    private List<Collection> collectionList = new ArrayList<>();

    public CollectionsAdapter(List<Collection> collectionList, CollectionClickListener collectionClickListener) {
        this.collectionList = collectionList;
        this.collectionClickListener = collectionClickListener;
    }

    @Override
    public CollectionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.icon_card_view, parent, false);
        return new CollectionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CollectionViewHolder holder, int position) {
        Collection collection = this.collectionList.get(position);
        holder.bind(collection, collectionClickListener);
    }

    @Override
    public int getItemCount() {
        return this.collectionList.size();
    }

    @Override
    public void onViewRecycled(CollectionViewHolder holder) {
        super.onViewRecycled(holder);
    }

    public void filterList(ArrayList<Collection> filteredList) {
        collectionList = filteredList;
        notifyDataSetChanged();
    }
}
