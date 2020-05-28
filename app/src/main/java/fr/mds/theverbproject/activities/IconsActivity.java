package fr.mds.theverbproject.activities;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fr.mds.theverbproject.R;
import fr.mds.theverbproject.adapter.IconsAdapter;
import fr.mds.theverbproject.model.Icon;
import fr.mds.theverbproject.model.ResponseResult;
import fr.mds.theverbproject.utils.GetIconDataService;
import fr.mds.theverbproject.utils.IconClickListener;
import fr.mds.theverbproject.utils.RetrofitInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IconsActivity extends AppCompatActivity {

    private static final int FIRST_PAGE = 1;
    private static final String TAG = "iconsActivity";
    private Call<ResponseResult> call;
    private List<Icon> iconsResults;
    private IconsAdapter iconsAdapter;

    @BindView(R.id.rv_icons) RecyclerView recyclerView;
    @BindView(R.id.tv_no_internet_error) ConstraintLayout mNoInternetMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icons);
        setTitle("Search - Icons");
        ButterKnife.bind(this);

        if(!isNetworkAvailable()){
            recyclerView.setVisibility(View.GONE);
            mNoInternetMessage.setVisibility(View.VISIBLE);
        }

        GridLayoutManager manager = new GridLayoutManager(this, 2);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return 1;
            }
        });
        recyclerView.setLayoutManager(manager);

        loadPage(FIRST_PAGE);
    }

    private void loadPage(final int page) {
        GetIconDataService iconDataService = RetrofitInstance.getClient().create(GetIconDataService.class);

        call = iconDataService.getIconsByTerm("zombie");

        call.enqueue(new Callback<ResponseResult>() {
            @Override
            public void onResponse(@NonNull Call<ResponseResult> call, @NonNull Response<ResponseResult> response) {

                if(page == 1) {
                    assert response.body() != null;
                    iconsResults = response.body().getIcons();

                    iconsAdapter = new IconsAdapter(iconsResults, new IconClickListener() {
                        @Override
                        public void onIconClick(Icon icon) {
                            Intent intent = new Intent(IconsActivity.this, IconsActivity.class);
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("icon", icon);
                            intent.putExtras(bundle);
                            startActivity(intent);
                        }
                    });
                    recyclerView.setAdapter(iconsAdapter);
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
            public void onFailure(@NonNull Call<ResponseResult> call, @NonNull Throwable t) {
                Toast.makeText(IconsActivity.this, R.string.something_went_wrong, Toast.LENGTH_SHORT).show();
            }
        });
    }

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
