package com.praxis.staffy.model.DAO.client;

import android.util.Log;

import com.praxis.staffy.model.pojo.CustomerDetails;
import java.util.ArrayList;

public class CustomerDetailDAO implements CustomerDetailInterface
{
    public static CustomerDetailDAO instance;
    ArrayList<CustomerDetails> listcustomerDetails;
    private CustomerDetailDAO()
    {
        listcustomerDetails=new ArrayList<>();
    }
    public static CustomerDetailDAO getInstance()
    {
        if(instance==null)
        {
            instance=new CustomerDetailDAO();
        }
        return instance;
    }



    @Override
    public ArrayList<CustomerDetails> getCustomerDetails() {
        return listcustomerDetails;
    }

    @Override
    public int getPosicion(int id_client) {
        for(int a=0;a<listcustomerDetails.size();a++)
        {
            if(listcustomerDetails.get(a).getIdCliente()==id_client)
            {
                return a;
            }
        }
        return -1;
    }

    @Override
    public void updateCustomer(int position, CustomerDetails customerDetails) {
         this.listcustomerDetails.set(position,customerDetails);
    }

    @Override
    public void setCustomerDetails(ArrayList<CustomerDetails> customerDetails) {
        this.listcustomerDetails = customerDetails;
    }

    @Override
    public boolean addCustomerDetail(CustomerDetails customerDetail)
    {
        return listcustomerDetails.add(customerDetail);
    }


    @Override
    public CustomerDetails searchCustomerDetails(Integer id_cliente)
    {
        for(int a=0;a<listcustomerDetails.size();a++)
        {
            if(listcustomerDetails.get(a).getIdCliente().toString().equalsIgnoreCase(id_cliente.toString()))
            {
                return listcustomerDetails.get(a);
            }
        }
        return null;
    }

    @Override
    public boolean existCustomer(CustomerDetails customerDetails)
    {
        if(searchCustomerDetails(customerDetails.getIdCliente())==null)
        {
            return false;
        }else
        {
            return true;
        }
    }
}
