package ru.aston.plugin_ki;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OrderManager {
    private List<Ticket> orders = new ArrayList<>();

    public void addOrder(Ticket ticket) {
        orders.add(ticket);
    }

    public double calculateTotalPrice() {
        return orders.stream().mapToDouble(Ticket::getFinalPrice).sum();
    }

    public List<Ticket> getSortedOrders() {
        return orders.stream().sorted(Comparator.comparing(o -> o.getCustomer().getAge())).collect(Collectors.toList());
    }
}
