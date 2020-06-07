package com.company.electricitybillappp.api;

import com.company.electricitybillappp.api.model.DownloadApiRequestModel;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Streaming;

public interface ApiService {
    @FormUrlEncoded
    @POST(ApiConstance.DOWNLOOAD_URL)
    @Streaming
    Call<ResponseBody> downloadPDFBytes(@Field("office") String ofice, @Field("t_consumer-no_0") String consumerNo, @Field("b_submit_0") String message);
}
