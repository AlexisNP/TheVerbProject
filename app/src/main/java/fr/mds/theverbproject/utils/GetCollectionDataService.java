package fr.mds.theverbproject.utils;

import fr.mds.theverbproject.model.Collection;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GetCollectionDataService {

    @GET("collection/{id}/icons")
    Call<Collection> getCollectionIconsById(@Path("id") int movieId, @Query("api_key") String userkey);

    @GET("collection/{slug}/icons")
    Call<Collection> getCollectionIconsBySlug(@Path("slug") String term, @Query("api_key") String userkey);

    @GET("collection/{id}")
    Call<Collection> getCollectionById(@Path("id") int page, @Query("api_key") String userkey);

    @GET("collection/{slug}")
    Call<Collection> getCollectionBySlug(@Path("slug") int page, @Query("api_key") String userkey);

    @GET("collections/{slug}")
    Call<Collection> getAllCollections(@Path("slug") int page, @Query("api_key") String userkey);
}
