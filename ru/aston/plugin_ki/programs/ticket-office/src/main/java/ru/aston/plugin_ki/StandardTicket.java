package ru.aston.plugin_ki;

public class StandardTicket extends  Ticket{
    public StandardTicket(double price, Customer customer, String movieTitle) {
        super(price, customer, movieTitle);
    }


    @Override
    public double calculateDiscount() {
        return customer.getAge() > 55 ? price * 0.1 : 0;
    }
}
