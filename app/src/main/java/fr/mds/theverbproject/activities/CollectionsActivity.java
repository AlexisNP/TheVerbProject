package fr.mds.theverbproject.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import fr.mds.theverbproject.MainActivity;
import fr.mds.theverbproject.R;

public class CollectionsActivity extends AppCompatActivity {

    private Button btn_icons;
    private Button btn_collections;
    private RecyclerView rv_icons;
    private RecyclerView rv_collections;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collections);
        setTitle("Search - Collections");

        // Init
        rv_icons = findViewById(R.id.rv_icons);
        rv_collections = findViewById(R.id.rv_collections);
        btn_icons = findViewById(R.id.btn_icons);
        btn_collections = findViewById(R.id.btn_collections);

        btn_icons.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                ViewGroup.LayoutParams lp_icons = rv_icons.getLayoutParams();
                lp_icons.height= ViewGroup.LayoutParams.WRAP_CONTENT;
                rv_icons.setLayoutParams(lp_icons);

                ViewGroup.LayoutParams lp_collections = rv_collections.getLayoutParams();
                lp_collections.height=0;
                rv_collections.setLayoutParams(lp_collections);
            }
        });

        btn_collections.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                ViewGroup.LayoutParams lp_icons = rv_icons.getLayoutParams();
                lp_icons.height= 0;
                rv_icons.setLayoutParams(lp_icons);

                ViewGroup.LayoutParams lp_collections = rv_collections.getLayoutParams();
                lp_collections.height= ViewGroup.LayoutParams.WRAP_CONTENT;
                rv_collections.setLayoutParams(lp_collections);
            }
        });
    }

}
