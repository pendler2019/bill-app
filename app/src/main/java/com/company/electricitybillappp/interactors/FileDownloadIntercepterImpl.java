package com.company.electricitybillappp.interactors;

import androidx.lifecycle.LiveData;

import com.company.electricitybillappp.api.ApiManager;
import com.company.electricitybillappp.api.AppCallback;
import com.company.electricitybillappp.api.AppError;
import com.company.electricitybillappp.interactors.interfaces.FileDownloadIntercepter;

import okhttp3.ResponseBody;
import retrofit2.Response;

public class FileDownloadIntercepterImpl implements FileDownloadIntercepter {

    @Override
    public void getPdf(String url, LiveData<Response<ResponseBody>> responseBodyLiveData, LiveData<AppError> errorLiveData) {
        ApiManager.getInstance().getAPI().downloadPDFBytes(url, new AppCallback<>(responseBodyLiveData, errorLiveData));
    }
}
