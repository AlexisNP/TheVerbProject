package fr.mds.theverbproject.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import fr.mds.theverbproject.R;

public class IconActivity extends AppCompatActivity {

    private static final String TAG = "IconActivity";

    private TextView tv_created_by;
    private TextView tv_collection_name;
    private ImageView iv_icon;
    private SeekBar sb_image_size;
    private Button btn_icon_download;
    private Button btn_icon_favorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icon);
        setTitle("Single Icon");

        // Fetches all elements
        tv_created_by = findViewById(R.id.tv_created_by);
        tv_collection_name = findViewById(R.id.tv_collection_name);
        iv_icon = findViewById(R.id.iv_icon);
        sb_image_size = findViewById(R.id.sb_image_size);
        btn_icon_download = findViewById(R.id.btn_icon_download);
        btn_icon_favorite = findViewById(R.id.btn_icon_favorite);
    }

    public void onDownload(View v) {
        Log.d(TAG, "Downloaded");
    }

    public void onFavourite(View v) {
        Log.d(TAG, "Favourite");
    }
}
