package fr.mds.theverbproject.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import fr.mds.theverbproject.R;
import fr.mds.theverbproject.model.Icon;

public class IconActivity extends AppCompatActivity {

    private static final String TAG = "IconActivity";

    private Object source_image;
    private TextView tv_created_by;
    private TextView tv_collection_name;
    private ImageView iv_icon;
    private LayoutParams iv_icon_params;
    private SeekBar sb_image_size;
    private Button btn_icon_download;
    private Button btn_icon_favorite;

    private Icon icon;

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

        // Sets progress of the SeekBar to half
        sb_image_size.setProgress(50);

        // Scales icon to a native 400dp * 400dp format
        scaleIcon(iv_icon, 400, 400);

//        Intent intent = getIntent();
//        Bundle bundle = intent.getExtras();
//        icon = (Icon) bundle.getSerializable("icon");

        sb_image_size.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            // Changes the size of the icon
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // Gets the scale factor as a value between 0.0 and 3.0
                double scale_factor = ((double) progress * 4) / 100;
                // Scales the icon by that ratio with a minimum height and width or 200dp (half native)
                scaleIcon(iv_icon, 200 * scale_factor + 200, 200 * scale_factor + 200);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        btn_icon_download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    public void run() {
                        Log.d(TAG, "DOWNLOAD");
                    }
                }).start();
            }
        });

        btn_icon_favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Favourite");
            }
        });
    }

    public void scaleIcon(ImageView img, double width, double height) {
        LayoutParams img_params = img.getLayoutParams();
        img_params.width = (int) width;
        img_params.height = (int) height;
        img.setLayoutParams(img_params);
    }

}
