package com.company.electricitybillappp.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DownloadApiRequestModel {

    @SerializedName("office")
    @Expose
    private String office;

    @SerializedName("t_consumer-no_0")
    @Expose
    private String consumerNo;



    public DownloadApiRequestModel(String office, String consumerNo, String message) {
        this.office = office;
        this.consumerNo = consumerNo;
        this.message = message;
    }

    @SerializedName("b_submit_0")
    @Expose
    private String message;



    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getConsumerNo() {
        return consumerNo;
    }

    public void setConsumerNo(String consumerNo) {
        this.consumerNo = consumerNo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
