package ru.aston.plugin_ki;

public abstract class Ticket {
    protected double price;
    protected Customer customer;
    protected String movieTitle;

    public Ticket(double price, Customer user, String movieTitle) {
        this.price = price;
        this.customer = user;
        this.movieTitle = movieTitle;
    }

    public abstract double calculateDiscount();

    public double getFinalPrice() {
        return price - calculateDiscount();
    }

    public Customer getCustomer() {
        return customer;
    }
}
