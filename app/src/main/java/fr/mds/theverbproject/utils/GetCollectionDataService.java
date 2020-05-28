package fr.mds.theverbproject.utils;

import fr.mds.theverbproject.model.ResponseCollectionResult;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GetCollectionDataService {

    @GET("collection/{id}/icons")
    Call<ResponseCollectionResult> getCollectionIconsById(@Path("id") int id);

    @GET("collection/{slug}/icons")
    Call<ResponseCollectionResult> getCollectionIconsBySlug(@Path("slug") String slug);

    @GET("collection/{id}")
    Call<ResponseCollectionResult> getCollectionById(@Path("id") int id);

    @GET("collection/{slug}")
    Call<ResponseCollectionResult> getCollectionBySlug(@Path("slug") String slug);

    @GET("collections")
    Call<ResponseCollectionResult> getAllCollections();
}
