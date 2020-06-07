package com.company.electricitybillappp.api;

import com.company.electricitybillappp.api.model.DownloadApiRequestModel;

import okhttp3.ResponseBody;

public interface ApiInterface {
    void downloadPDFBytes(DownloadApiRequestModel request, AppCallback<ResponseBody> callback);
}
