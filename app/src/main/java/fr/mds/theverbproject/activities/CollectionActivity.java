package fr.mds.theverbproject.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import fr.mds.theverbproject.R;
import fr.mds.theverbproject.adapter.IconListAdapter;
import fr.mds.theverbproject.model.Icon;

public class CollectionActivity extends AppCompatActivity {

    public static final String TAG = "Single Collection";

    private TextView tv_by_author;
    private LinearLayout ll_container_collection;
    private RecyclerView rv_list_icons;
    private ArrayList<Icon> listIcons = new ArrayList<>();
    private IconListAdapter iconListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);
        setTitle("Single Collection");

        tv_by_author = findViewById(R.id.tv_by_author);
        ll_container_collection = findViewById(R.id.ll_container_collection);
        rv_list_icons = findViewById(R.id.rv_list_icons);

        iconListAdapter = new IconListAdapter(this, listIcons);

//        rv_list_icons.setAdapter(iconListAdapter);
//        rv_list_icons.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Icon selectedIcon = rv_list_icons.get(position);
//
//                Log.d(TAG, "OnIconSelected " + position);
//
//                Intent intent = new Intent(CollectionActivity.this, IconActivity.class);
//                intent.putExtra("Icon", selectedIcon);
//                intent.putExtra("index", position );
//                CollectionActivity.this.startActivityForResult(intent, 5);
//
//            }
//        });

    }
}
