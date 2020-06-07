package com.company.electricitybillappp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.company.electricitybillappp.api.ApiConstance;
import com.company.electricitybillappp.api.AppError;

import okhttp3.ResponseBody;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {
    private HomeViewModel viewModel;

    public static void launch(Activity activity) {
        Intent intent = new Intent(activity, HomeActivity.class);
        activity.startActivity(intent);
        activity.finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        viewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        setObserver();
    }

    private void setObserver() {
        final Observer<Response<ResponseBody>> nameObserver = response -> {
            if(response.body().byteStream() != null) {
                Log.v("----------","------success--------");
            }
        };

        viewModel.getResponseLiveData().observe(this, nameObserver);

        final Observer<AppError> errorObserver = error -> {
            if(error != null) {
                Log.v("----------","------error--------");
            }
        };
        viewModel.getErrorLiveData().observe(this, errorObserver);

    }

    public void downloadFile(View view) {
        viewModel.downloadFile(ApiConstance.DOWNLOOAD_URL);
    }
}
