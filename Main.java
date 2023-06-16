package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static final List<String[]> customerData = Arrays.asList(
            new String[]{"1", "Wayne Enterprises", "10000", "12-01-2021"},
            new String[]{"2", "Daily Planet", "-7500", "01-10-2022"},
            new String[]{"1", "Wayne Enterprises", "18000", "12-22-2021"},
            new String[]{"3", "Ace Chemical", "-48000", "01-10-2022"},
            new String[]{"3", "Ace Chemical", "-95000", "12-15-2021"},
            new String[]{"1", "Wayne Enterprises", "175000", "01-01-2022"},
            new String[]{"1", "Wayne Enterprises", "-35000", "12-09-2021"},
            new String[]{"1", "Wayne Enterprises", "-64000", "01-17-2022"},
            new String[]{"3", "Ace Chemical", "70000", "12-29-2022"},
            new String[]{"2", "Daily Planet", "56000", "12-13-2022"},
            new String[]{"2", "Daily Planet", "-33000", "01-07-2022"},
            new String[]{"1", "Wayne Enterprises", "10000", "12-01-2021"},
            new String[]{"2", "Daily Planet", "33000", "01-17-2022"},
            new String[]{"3", "Ace Chemical", "140000", "01-25-2022"},
            new String[]{"2", "Daily Planet", "5000", "12-12-2022"},
            new String[]{"3", "Ace Chemical", "-82000", "01-03-2022"},
            new String[]{"1", "Wayne Enterprises", "10000", "12-01-2021"}
    );

    //  This method is meant to parse through the List<String[]>, attain the information, and then pass it through another
    //  method to make sure no duplicates occur and that each company appears once with the correct balance
    public static List<Customer> convertToCustomerList(List<String[]> customerData) {
        List<Customer> customers = new ArrayList<>();
        for (String[] data : customerData) {
            int id = Integer.parseInt(data[0]);
            String name = data[1];
            int amount = Integer.parseInt(data[2]);
            String date = data[3];

            Customer customer = removeDuplicates(customers, id, name);

            AccountRecord accountRecord = new AccountRecord();
            accountRecord.setCharge(amount);
            accountRecord.setChargeDate(date);
            customer.getCharges().add(accountRecord);
        }
        return customers;
    }

    //  This method is meant to check if there is already a customer (same id and name) that appears in the list
    //  If it does then we return the customer
    //  If it does not then we create a new customer
    public static Customer removeDuplicates(List<Customer> customers, int id, String name) {
        for (Customer customer : customers) {
            if (customer.getId() == id && customer.getName() == name) {
                return customer;
            }
        }

        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(name);
        customers.add(customer);

        return customer;
    }

    public static void main(String[] args) {
        //  Iterates through each of the customers in the customerData and converts into List<Customer>
        List<Customer> customers = convertToCustomerList(customerData);
        for (Customer customer : customers) {
            System.out.println(customer);
        }
        // This uses the stream to filter out through the list and extract the positive accounts
        System.out.println("Positive accounts:");
        List<Customer> postiveCustomers = customers.stream().filter(checkCustomer -> checkCustomer.getBalance() >= 0).collect(Collectors.toList());

        for (Customer customer : postiveCustomers) {
            System.out.println(customer);
        }

        // This uses the stream to filter out through the list and extract the negative accounts
        System.out.println("Negative accounts:");
        List<Customer> negativeCustomers = customers.stream().filter(checkCustomer -> checkCustomer.getBalance() < 0).collect(Collectors.toList());

        for (Customer customer : negativeCustomers) {
            System.out.println(customer);
        }
    }
}
