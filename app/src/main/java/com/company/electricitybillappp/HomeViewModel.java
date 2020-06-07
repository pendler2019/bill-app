package com.company.electricitybillappp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.company.electricitybillappp.api.AppError;
import com.company.electricitybillappp.api.model.DownloadApiRequestModel;

import okhttp3.ResponseBody;
import retrofit2.Response;

public class HomeViewModel extends ViewModel {
    private HomeRepository repository = new HomeRepository();

    private LiveData<Response<ResponseBody>> responseLiveData = new MutableLiveData<>();
    private LiveData<AppError> errorLiveData = new MutableLiveData<>();

    public void downloadFile() {
        DownloadApiRequestModel request = new DownloadApiRequestModel("", "", "View Bill");
        repository.downloadFile(request, responseLiveData, errorLiveData);
    }

    public LiveData<Response<ResponseBody>> getResponseLiveData() {
        return responseLiveData;
    }

    public LiveData<AppError> getErrorLiveData() {
        return errorLiveData;
    }
}
