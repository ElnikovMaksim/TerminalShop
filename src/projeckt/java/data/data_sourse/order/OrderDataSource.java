package projeckt.java.data.data_sourse.order;

import projeckt.java.data.models.Order;

public abstract class OrderDataSource {
    private Order order;

    public abstract void createOrder(Order order);

    public abstract Order getOrder();
}
