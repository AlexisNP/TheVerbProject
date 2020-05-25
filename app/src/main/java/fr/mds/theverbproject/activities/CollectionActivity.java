package fr.mds.theverbproject.activities;

        import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;

        import fr.mds.theverbproject.R;

public class CollectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);
        setTitle("Single Collection");
    }
}
