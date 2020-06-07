package com.company.electricitybillappp.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

public interface ApiService {
    @GET
    @Streaming
    Call<ResponseBody> downloadPDFBytes(@Url String url);
}
