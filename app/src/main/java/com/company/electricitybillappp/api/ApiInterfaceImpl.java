package com.company.electricitybillappp.api;


import com.company.electricitybillappp.api.model.DownloadApiRequestModel;

import okhttp3.ResponseBody;
import retrofit2.Call;

public class ApiInterfaceImpl implements ApiInterface {

    private final ApiService apiService;

    public ApiInterfaceImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public void downloadPDFBytes(DownloadApiRequestModel request, AppCallback<ResponseBody> callback) {
        Call<ResponseBody> call = apiService.downloadPDFBytes(request.getOffice(), request.getConsumerNo(), request.getMessage());
        call.enqueue(callback);
    }
}
