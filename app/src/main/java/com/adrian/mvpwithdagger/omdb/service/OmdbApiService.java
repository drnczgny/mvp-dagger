package com.adrian.mvpwithdagger.omdb.service;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by Adrian_Czigany on 3/3/2017.
 */

public interface OmdbApiService {

    public static final String BASE_URL = "http://www.omdbapi.com/";

    @GET("/")
    Call<String> findAllMovie();

    @GET("/")
    Call<String> findMovieByYear(@QueryMap Map<String, Integer> options);

    @GET("/")
    Call<String> findMovieByTitle(@QueryMap Map<String, String> options);

//    Gson gson = new GsonBuilder().setLenient().create();
//
//    OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
//        @Override
//        public Response intercept(Chain chain) throws IOException {
//            Request newRequest  = chain.request().newBuilder()
//                    .build();
//            return chain.proceed(newRequest);
//        }
//    }).build();
//
//    public static final Retrofit retrofit = new Retrofit.Builder()
//            .baseUrl(BASE_URL)
////            .addConverterFactory(GsonConverterFactory.create(gson))
//            .addConverterFactory(ScalarsConverterFactory.create())
//            .client(client)
//            .build();

}

