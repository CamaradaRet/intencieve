package ru.aston.plugin_ki;

import java.util.Objects;

public class Customer implements Comparable<Customer>{
    private Integer age;
    private String name;
    private String surname;

    public Customer(int age, String name, String surname) {
        this.age = age;
        this.name = name;
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Customer other) {
        return this.age.compareTo(other.age);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || this.getClass() != other.getClass()) return false;
        Customer otherCustomer = (Customer) other;
        return age == otherCustomer.age && Objects.equals(name, otherCustomer.name) && Objects.equals(surname,otherCustomer.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name, surname);
    }
}
