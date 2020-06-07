package com.company.electricitybillappp.interactors.interfaces;

import androidx.lifecycle.LiveData;

import com.company.electricitybillappp.api.AppError;
import com.company.electricitybillappp.api.model.DownloadApiRequestModel;

import okhttp3.ResponseBody;
import retrofit2.Response;


public interface FileDownloadIntercepter {
    void getPdf(DownloadApiRequestModel request, LiveData<Response<ResponseBody>> responseBodyLiveData, LiveData<AppError> errorLiveData);
}
