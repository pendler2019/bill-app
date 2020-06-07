package com.company.electricitybillappp.api;


import okhttp3.ResponseBody;
import retrofit2.Call;

public class ApiInterfaceImpl implements ApiInterface {
    private final ApiService apiService;

    public ApiInterfaceImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public void downloadPDFBytes(String url, AppCallback<ResponseBody> callback) {
        Call<ResponseBody> call = apiService.downloadPDFBytes(url);
        call.enqueue(callback);
    }
}
