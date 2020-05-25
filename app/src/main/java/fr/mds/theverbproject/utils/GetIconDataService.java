package fr.mds.theverbproject.utils;

import fr.mds.theverbproject.model.Icon;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GetIconDataService {

    @GET("icon/{id}")
    Call<Icon> getIconById(@Path("id") int movieId, @Query("api_key") String userkey);

    @GET("icon/{term}")
    Call<Icon> getIconByTerm(@Path("term") String term, @Query("api_key") String userkey);

    @GET("icons/recent_uploads")
    Call<Icon> getPopularMovies(@Query("page") int page, @Query("api_key") String userkey);

    @GET("icons/{term}")
    Call<Icon> getTopRatedMovies(@Path("term") int page, @Query("api_key") String userkey);
}
