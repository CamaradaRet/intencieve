package ru.aston.plugin_ki;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicketServiceTest {
    @Test
    void testStandardTicketDiscount() {
        Customer customer = new Customer(25, "John", "Doe");
        Ticket ticket = new StandardTicket(100, customer, "Movie1");
        assertEquals(100, ticket.getFinalPrice());
    }


    @Test
    void testChildTicketDiscount() {
        Customer customer = new Customer(17, "Jane", "Doe");
        Ticket ticket = new ChildTicket(100, customer, "Movie2");
        assertEquals(80, ticket.getFinalPrice());
    }
//    @Test
//    void testChildTicketDiscount() {
//        Customer customer = new Customer(10, "Jane", "Doe");
//        Ticket ticket = new ChildTicket(100, customer, "Movie2");
//        assertEquals(70, ticket.getFinalPrice());
//    }

    @Test
    void testOrderTotalPrice() {
        OrderManager manager = new OrderManager();
        manager.addOrder(new StandardTicket(100, new Customer(25, "John", "Doe"), "Movie1"));
        manager.addOrder(new ChildTicket(100, new Customer(10, "Jane", "Doe"), "Movie2"));
        assertEquals(170, manager.calculateTotalPrice());
    }

    @Test
    void testSortedOrders() {
        OrderManager manager = new OrderManager();
        Customer customer = new Customer(25, "John", "Doe");
        Customer customer1 = new Customer(10, "Jane", "Doe");
        manager.addOrder(new StandardTicket(100, customer, "Movie1"));
        manager.addOrder(new ChildTicket(100, customer1, "Movie2"));
        List<Ticket> sorted = manager.getSortedOrders();
        assertEquals(10, sorted.get(0).getCustomer().getAge());
        assertEquals(25, sorted.get(1).getCustomer().getAge());
    }
//    @Test
//    void testSortedOrders() {
//        OrderManager manager = new OrderManager();
//        Customer customer = new Customer(25, "John", "Doe");
//        Customer customer1 = new Customer(17, "Jane", "Doe");
//        manager.addOrder(new StandardTicket(100, customer, "Movie1"));
//        manager.addOrder(new ChildTicket(100, customer1, "Movie2"));
//        List<Ticket> sorted = manager.getSortedOrders();
//        assertEquals(17, sorted.get(0).getCustomer().getAge());
//        assertEquals(25, sorted.get(1).getCustomer().getAge());
//    }
}
