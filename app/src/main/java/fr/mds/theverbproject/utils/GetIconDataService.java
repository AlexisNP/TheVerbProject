package fr.mds.theverbproject.utils;

import fr.mds.theverbproject.model.ResponseIconResult;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GetIconDataService {

    @GET("icon/{id}")
    Call<ResponseIconResult> getIconById(@Path("id") int id);

    @GET("icon/{term}")
    Call<ResponseIconResult> getIconByTerm(@Path("term") String term);

    @GET("icons/recent_uploads")
    Call<ResponseIconResult> getPopularMovies();

    @GET("icons/{term}")
    Call<ResponseIconResult> getIconsByTerm(@Path("term") String term);
}
