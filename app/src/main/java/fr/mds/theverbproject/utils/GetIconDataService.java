package fr.mds.theverbproject.utils;

import fr.mds.theverbproject.model.IconPageResult;
import fr.mds.theverbproject.model.ResponseResult;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GetIconDataService {

    @GET("icon/{id}")
    Call<IconPageResult> getIconById(@Path("id") int movieId, @Query("api_key") String userkey);

    @GET("icon/{term}")
    Call<IconPageResult> getIconByTerm(@Path("term") String term);

    @GET("icons/recent_uploads")
    Call<IconPageResult> getPopularMovies(@Query("page") int page, @Query("api_key") String userkey);

    @GET("icons/{term}")
    Call<ResponseResult> getIconsByTerm(@Path("term") String term);
}
