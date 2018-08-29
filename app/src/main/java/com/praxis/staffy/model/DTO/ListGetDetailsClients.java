package com.praxis.staffy.model.DTO;

import com.google.gson.annotations.SerializedName;
import com.praxis.staffy.model.pojo.CustomerDetails;

public class ListGetDetailsClients {
    @SerializedName("data")
    CustomerDetails objCustomerDetails;

    public CustomerDetails getObjCustomerDetails() {
        return objCustomerDetails;
    }

    public void setObjCustomerDetails(CustomerDetails objCustomerDetails) {
        this.objCustomerDetails = objCustomerDetails;
    }
}
