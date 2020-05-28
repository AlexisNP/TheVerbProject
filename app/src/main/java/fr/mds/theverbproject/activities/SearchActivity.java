package fr.mds.theverbproject.activities;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.OnClick;
import fr.mds.theverbproject.R;
import fr.mds.theverbproject.adapter.CollectionsAdapter;
import fr.mds.theverbproject.adapter.IconsAdapter;
import fr.mds.theverbproject.model.Collection;
import fr.mds.theverbproject.model.Icon;
import fr.mds.theverbproject.model.ResponseCollectionResult;
import fr.mds.theverbproject.model.ResponseIconResult;
import fr.mds.theverbproject.utils.GetIconDataService;
import fr.mds.theverbproject.utils.IconClickListener;
import fr.mds.theverbproject.utils.RetrofitInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchActivity extends AppCompatActivity {

    private Button btn_icons;
    private Button btn_collections;
    private RecyclerView rv_icons;
    private RecyclerView rv_collections;

    private static final int FIRST_PAGE = 1;
    private static final String TAG = "searchActivity";
    private Call<ResponseIconResult> callIcons;
    private Call<ResponseCollectionResult> callCollections;
    private List<Icon> iconsResults;
    private IconsAdapter iconsAdapter;
    private List<Collection> collectionsResults;
    private CollectionsAdapter collectionsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
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





    private void loadIcons(final int page) {
        GetIconDataService iconDataService = RetrofitInstance.getClient().create(GetIconDataService.class);

        callIcons = iconDataService.getIconsByTerm("zombie");

        callIcons.enqueue(new Callback<ResponseIconResult>() {
            @Override
            public void onResponse(@NonNull Call<ResponseIconResult> call, @NonNull Response<ResponseIconResult> response) {

                if(page == 1) {
                    assert response.body() != null;
                    iconsResults = response.body().getIcons();

                    iconsAdapter = new IconsAdapter(iconsResults, new IconClickListener() {
                        @Override
                        public void onIconClick(Icon icon) {
                            Intent intent = new Intent(SearchActivity.this, IconActivity.class);
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("icon", icon);
                            intent.putExtras(bundle);
                            startActivity(intent);
                        }
                    });
                    rv_icons.setAdapter(iconsAdapter);
                } else {
                    assert response.body() != null;
                    List<Icon> icons = response.body().getIcons();
                    for(Icon icon : icons){
                        iconsResults.add(icon);
                        iconsAdapter.notifyItemInserted(iconsResults.size() - 1);
                    }
                }

            }

            @Override
            public void onFailure(@NonNull Call<ResponseIconResult> call, @NonNull Throwable t) {
                Toast.makeText(SearchActivity.this, R.string.something_went_wrong, Toast.LENGTH_SHORT).show();
            }
        });
    }

//    private void loadCollections(final int page) {
//        GetCollectionDataService collectionDataService = RetrofitInstance.getClient().create(GetCollectionDataService.class);
//
//        callCollections = collectionDataService.getCollectionBySlug("zombie");
//
//        callCollections.enqueue(new Callback<ResponseCollectionResult>() {
//            @Override
//            public void onResponse(@NonNull Call<ResponseCollectionResult> call, @NonNull Response<ResponseCollectionResult> response) {
//
//                if(page == 1) {
//                    assert response.body() != null;
//                    collectionsResults = response.body().getCollection();
//
//                    iconsAdapter = new IconsAdapter(collectionsResults, new IconClickListener() {
//                        @Override
//                        public void onIconClick(Icon icon) {
//                            Intent intent = new Intent(SearchActivity.this, IconActivity.class);
//                            Bundle bundle = new Bundle();
//                            bundle.putSerializable("icon", icon);
//                            intent.putExtras(bundle);
//                            startActivity(intent);
//                        }
//                    });
//                    rv_icons.setAdapter(iconsAdapter);
//                } else {
//                    assert response.body() != null;
//                    List<Icon> icons = response.body().getIcons();
//                    for(Icon icon : icons){
//                        iconsResults.add(icon);
//                        iconsAdapter.notifyItemInserted(iconsResults.size() - 1);
//                    }
//                }
//
//            }
//
//            @Override
//            public void onFailure(@NonNull Call<ResponseCollectionResult> call, @NonNull Throwable t) {
//                Toast.makeText(SearchActivity.this, R.string.something_went_wrong, Toast.LENGTH_SHORT).show();
//            }
//        });
//    }





    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }
    public static int getMeasuredPosterHeight(int width) {
        return (int) (width * 1.5f);
    }

    public static String iconImagePathBuilder(String imageId) {
        return "https://static.thenounproject.com/attribution/" +
                imageId + "-600.png";
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        assert connectivityManager != null;
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @OnClick(R.id.tv_no_internet_error_refresh)
    public void refreshActivity(){
        finish();
        startActivity(getIntent());
    }

}
