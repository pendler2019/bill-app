package com.company.electricitybillappp.api;

import android.content.Context;

import com.company.electricitybillappp.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkManager {
    private static final String WEB_API_ENDPOINT = BuildConfig.BASE_URL;
    private static final int    TIME_OUT                 = 30;
    private static final String BEARER                   = "Bearer";
    private static final String AUTHORIZATION            = "Authorization";
    private final ApiService apiService;
    private final Context context;

    public NetworkManager(Context context) {
        this.context = context;
        apiService = init();
    }

    private ApiService init() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(WEB_API_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getRequestInterceptor())
                .build();
        return retrofit.create(ApiService.class);
    }


    private OkHttpClient getRequestInterceptor() {
        return new OkHttpClient.Builder()
                .addInterceptor(getInterceptor())
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
                .build();
    }

    private Interceptor getInterceptor() {

        return chain -> {

            Request request;
            /*if (chain.request().url().toString().contains(
                    WEB_API_ENDPOINT)) {
                if (isLoggedIn) {
                    String access_token = PreferenceManager.getInstance()
                            .getUserAccessToken();

                    String bearer = BEARER + " " + access_token;
                    request = chain.request().newBuilder()
                            .addHeader(AUTHORIZATION, bearer).build();

                } else {
                    request = chain.request().newBuilder().build();
                }
            } else {*/
            request = chain.request().newBuilder()
                    .build();
            //}
            return chain.proceed(request);
        };
    }

    public ApiService getService() {
        return apiService;
    }
}
