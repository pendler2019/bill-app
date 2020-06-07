package com.company.electricitybillappp.api;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AppCallback<T> implements Callback<T> {
    private LiveData<Response<T>> responseLiveData;
    private LiveData<AppError> errorLiveData;

    public AppCallback(LiveData<Response<T>> responseLiveData, LiveData<AppError> errorLiveData) {
        this.responseLiveData = responseLiveData;
        this.errorLiveData = errorLiveData;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        ((MutableLiveData<Response<T>>)responseLiveData).postValue(response);
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        t.printStackTrace();
        ((MutableLiveData<AppError>)errorLiveData).postValue(new AppError());
    }
}
