package fr.mds.theverbproject.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import fr.mds.theverbproject.R;
import fr.mds.theverbproject.model.Collection;
import fr.mds.theverbproject.utils.CollectionClickListener;

import static fr.mds.theverbproject.activities.IconsActivity.getMeasuredPosterHeight;
import static fr.mds.theverbproject.activities.IconsActivity.getScreenWidth;
import static fr.mds.theverbproject.activities.IconsActivity.iconImagePathBuilder;

public class CollectionViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.iv_collection_poster) ImageView mIconPoster;
    @BindView(R.id.cv_collection_card) CardView mIconCard;

    public CollectionViewHolder(final View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(final Collection collection, final CollectionClickListener collectionClickListener) {
        mIconCard.setLayoutParams(new ViewGroup.LayoutParams(getScreenWidth()/2, getMeasuredPosterHeight(getScreenWidth()/2)));

        Picasso.with(mIconPoster.getContext()).load(iconImagePathBuilder(collection.getId())).placeholder(R.drawable.placeholder).fit().centerCrop().into(mIconPoster);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                collectionClickListener.onIconClick(collection);
            }
        });
    }
}
