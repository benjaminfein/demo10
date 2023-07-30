package structure;

import java.util.HashSet;

public class OrderTable {
    private HashSet<String> orders;

    public OrderTable(HashSet<String> orders) {
        this.orders = orders;
    }

    public HashSet<String> getOrders() {
        return orders;
    }

    public void setOrders(HashSet<String> orders) {
        this.orders = orders;
    }
}
