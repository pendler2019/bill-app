package com.company.electricitybillappp;

import androidx.lifecycle.LiveData;

import com.company.electricitybillappp.api.AppError;
import com.company.electricitybillappp.api.model.DownloadApiRequestModel;
import com.company.electricitybillappp.interactors.FileDownloadIntercepterImpl;
import com.company.electricitybillappp.interactors.interfaces.FileDownloadIntercepter;

import okhttp3.ResponseBody;
import retrofit2.Response;

public class HomeRepository {
    private FileDownloadIntercepter fileDownloadIntercepter = new FileDownloadIntercepterImpl();
    public void downloadFile(DownloadApiRequestModel request, LiveData<Response<ResponseBody>> responseLiveData, LiveData<AppError> errorLiveData) {
        fileDownloadIntercepter.getPdf(request,responseLiveData, errorLiveData);
    }
}
