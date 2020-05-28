package fr.mds.theverbproject.utils;

import fr.mds.theverbproject.model.Api;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer;
import se.akerfeldt.okhttp.signpost.SigningInterceptor;

public class RetrofitInstance {

    private static Retrofit retrofit = null;

    public static Retrofit getClient(){
        if(retrofit == null){
            OkHttpOAuthConsumer consumer = new OkHttpOAuthConsumer(Api.CONSUMER_KEY, Api.CONSUMER_SECRET);

            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(new SigningInterceptor(consumer))
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(Api.BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
