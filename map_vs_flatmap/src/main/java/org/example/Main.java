package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Customer customer1 = new Customer("john", "john@gmail.com", Arrays.asList("397937955", "21654725"));
        Customer customer2 = new Customer("smith", "smith@gmail.com", Arrays.asList("89563865", "2487238947"));
        Customer customer3 = new Customer("peter", "peter@gmail.com", Arrays.asList("38946328654", "3286487236"));
        Customer customer4 = new Customer("kely", "kely@gmail.com", Arrays.asList("389246829364", "948609467"));
        List<Customer> customerList = new ArrayList<>(Arrays.asList(customer1, customer2, customer3, customer4));
        //print all customers object by using toString method
        customerList.forEach(System.out::println);

        //here each customer has one email address.
        //one to one mapping
        //so here using map function because of each input has one value

        List<String> email = customerList.stream().map(Customer::getEmail).collect(Collectors.toList());
        System.out.println(email);

        //each customer has multiple phone numbers
        //so here having one to many mapping
        //need to use flatmap because flatmap = map + flattering

        List<List<String>> phoneNumbers = customerList.stream()
                .map(Customer::getPhoneNumbers).collect(Collectors.toList());
        System.out.println(phoneNumbers);

        //so here need to use flatmap

        List<String> phoneNumberList = customerList.stream().flatMap(customer -> customer.getPhoneNumbers()
                .stream()).collect(Collectors.toList());
        System.out.println(phoneNumberList);

    }
}