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
import fr.mds.theverbproject.model.Icon;
import fr.mds.theverbproject.utils.IconClickListener;

import static fr.mds.theverbproject.activities.IconsActivity.getMeasuredPosterHeight;
import static fr.mds.theverbproject.activities.IconsActivity.getScreenWidth;
import static fr.mds.theverbproject.activities.IconsActivity.iconImagePathBuilder;

public class IconViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.iv_movie_poster) ImageView mIconPoster;
    @BindView(R.id.cv_movie_card) CardView mIconCard;

    public IconViewHolder(final View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(final Icon icon, final IconClickListener iconClickListener) {
        mIconCard.setLayoutParams(new ViewGroup.LayoutParams(getScreenWidth()/2, getMeasuredPosterHeight(getScreenWidth()/2)));

        Picasso.with(mIconPoster.getContext()).load(iconImagePathBuilder(icon.getPermalink())).placeholder(R.drawable.placeholder).fit().centerCrop().into(mIconPoster);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iconClickListener.onIconClick(icon);
            }
        });
    }
}
