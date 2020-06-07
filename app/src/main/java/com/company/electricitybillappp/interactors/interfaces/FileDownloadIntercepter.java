package com.company.electricitybillappp.interactors.interfaces;

import androidx.lifecycle.LiveData;

import com.company.electricitybillappp.api.AppError;

import okhttp3.ResponseBody;
import retrofit2.Response;


public interface FileDownloadIntercepter {
    void getPdf(String url, LiveData<Response<ResponseBody>> responseBodyLiveData, LiveData<AppError> errorLiveData);
}
