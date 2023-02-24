package com.springdemo.helloworld;

import java.util.function.Consumer;

public class CustomerBuilder {

    private final String firstName;
    private final String lastName;
    private Integer age;
    private String address;
    private String sex;


    public CustomerBuilder(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public CustomerBuilder with(Consumer<CustomerBuilder> consumer){
        consumer.accept(this);
        return this;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Customer build(){
           return new Customer(this);


    }

    public class Customer {
        private  String firstName;
        private  String lastName;
        private Integer age;
        private String address;
        private String sex;

        public Customer(CustomerBuilder builder) {
            this.firstName = builder.firstName;
            this.lastName = builder.lastName;
            this.age = builder.age;
            this.address = builder.address;
            this.sex = builder.sex;
        }

        public Customer(String firstName, String lastName, Integer age, String address, String sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.address = address;
            this.sex = sex;
        }


        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }
    }


}
