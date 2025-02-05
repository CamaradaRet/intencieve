package ru.aston.plugin_ki;

public class ChildTicket extends Ticket{
    public ChildTicket(double price, Customer customer, String movieTitle) {
        super(price, customer, movieTitle);
    }
    @Override
    public double calculateDiscount() {
        if (customer.getAge() <= 18 && customer.getAge() > 14){
            return price * 0.2;
        }else if(customer.getAge() <= 14){
            return price * 0.3;
        }
        return 0;
    }
}
