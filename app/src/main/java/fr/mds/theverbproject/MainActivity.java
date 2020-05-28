package fr.mds.theverbproject;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import fr.mds.theverbproject.activities.CollectionActivity;
import fr.mds.theverbproject.activities.CollectionsActivity;
import fr.mds.theverbproject.activities.IconActivity;
import fr.mds.theverbproject.activities.IconsActivity;
import fr.mds.theverbproject.activities.ProfileActivity;

public class MainActivity extends AppCompatActivity {

    private Button main_allCollections;
    private Button main_singleCollection;
    private Button main_allIcons;
    private Button main_singleIcon;
    private Button main_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_allCollections = findViewById(R.id.main_allCollections);
        main_singleCollection = findViewById(R.id.main_singleCollection);
        main_allIcons = findViewById(R.id.main_allIcons);
        main_singleIcon = findViewById(R.id.main_singleIcon);
        main_profile = findViewById(R.id.main_profile);


    }

    public void startCollectionsActivity (View v) {
        Intent i = new Intent(this, CollectionsActivity.class);
        startActivity(i);
    }

    public void startCollectionActivity (View v) {
        Intent i = new Intent(this, CollectionActivity.class);
        startActivity(i);
    }

    public void startIconsActivity (View v) {
        Intent i = new Intent(this, IconsActivity.class);
        startActivity(i);
    }

    public void startIconActivity (View v) {
        Intent i = new Intent(this, IconActivity.class);
        startActivity(i);
    }

    public void startProfileActivity (View v) {
        Intent i = new Intent(this, ProfileActivity.class);
        startActivity(i);
    }
}
