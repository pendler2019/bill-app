package com.company.electricitybillappp.api;

import okhttp3.ResponseBody;

public interface ApiInterface {
    void downloadPDFBytes(String url, AppCallback<ResponseBody> callback);
}
