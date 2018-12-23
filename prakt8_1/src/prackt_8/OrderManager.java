package prackt_8;

public interface OrderManager
{
    int itemsQuantity(String name);
    int itemsQuantity(MenuItem item);
    MyArrayList<Order> getOrder();
    int ordersCostSummary();
    int ordersQuantity();
}