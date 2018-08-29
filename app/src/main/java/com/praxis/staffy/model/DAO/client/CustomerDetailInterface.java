package com.praxis.staffy.model.DAO.client;

import com.praxis.staffy.model.pojo.CustomerDetails;

import java.util.ArrayList;

public interface CustomerDetailInterface {
    boolean existCustomer(CustomerDetails customerDetails);
    CustomerDetails searchCustomerDetails(Integer id_cliente);
    boolean addCustomerDetail(CustomerDetails customerDetail);
    void setCustomerDetails(ArrayList<CustomerDetails> customerDetails);
    ArrayList<CustomerDetails> getCustomerDetails();
    int getPosicion(int id_client);
    void updateCustomer(int position, CustomerDetails customerDetails);
}
