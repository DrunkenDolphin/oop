package prackt_8;

import java.awt.*;

public class TableOrdersManager implements OrderManager
{
    private MyArrayList<Order> orders = new MyArrayList<Order>();

    // func to resize the array

    //add order to table. Receives number of table and order
    public void add(Order order, int tableNumber)
    {
        orders.set(order,tableNumber);
    }
    // add order to table. Receives the dish and table number
    public void add(MenuItem item, int tableNumber)
    {
        orders.get(tableNumber).add(item);
    }
    //return first free table
    public int freeTableNumber()
    {
        for(int i = 0; i < orders.size(); i++)
            if(orders.get(i) == null)
                return i;
        return -1;
    }
    //return all free table
    public int[] freeTableNumbers()
    {
        int[] tables = new int[orders.size()];
        int count = 0;
        for(int i = 0; i < orders.size(); i++)
            if(orders.get(i) == null)
            {
                tables[count] = i;
                count++;
            }
        return tables;
    }
    // return order by order number
    public Order getOrder(int tableNumber)
    {
        return orders.get(tableNumber);
    }
    // removes the order by table number
    public void remove(int tableNumber)
    {
        orders.delete(tableNumber);
    }
    // removes the order by order number
    public int remove(Order order)
    {
        for(int i = 0; i < orders.size(); i++)
            if(orders.get(i) == order)
            {
                orders.delete(i);
                return i;
            }
        return -1;

    }
    // removes all matches from the specified order
    public int removeAll(Order order)
    {
        int count = 0;
        for(int i = 0; i < orders.size(); i++)
            if(orders.get(i) == order)
            {
                orders.delete(i);
            }
        if(count == 0)
            return -1;
        return count;
    }
    // returns numbers of ordering dish. Receive name of order
    @Override
    public int itemsQuantity(String name)
    {
        int count = 0;
        for(int i = 0; i < orders.size(); i++) {
            if(orders.get(i) != null){
                count += orders.get(i).itemQuantity(name);
            }
        }
        return count;
    }
    // returns numbers of ordering dish. Receive object of order (dish or drink)
    @Override
    public int itemsQuantity(MenuItem item)
    {
        int count = 0;
        for(int i = 0; i < orders.size(); i++) {
            for (int j = 0; j < orders.size(); j++) {
                if (orders.get(i).get(j) == item)
                    count++;
            }
        }
        return count;
    }
    @Override
    public MyArrayList<Order> getOrder()
    {
        return orders;
    }
    // returns total cost of all orders
    @Override
    public int ordersCostSummary()
    {
        int cost = 0;
        for(int i = 0; i < orders.size(); i++)
            if(orders.get(i) != null){
                cost += orders.get(i).costTotal();
            }
        return cost;
    }

    @Override
    public int ordersQuantity()
    {
        return orders.size();
    }
    // override method "toString"
    @Override
    public String toString()
    {
        String result = "Table order:" + orders.size() + '\n';
        //for(int i = 0; i < size; i++)
        //result += orders[i]. + ":" + orders[i].getCustomer();
        return result;
    }
    // compare objects
    @Override
    public boolean equals(Object object)
    {
        if(object == null || object.getClass() != this.getClass())
            return false;
        if(object == this)
            return true;
        else
            return false;
    }
    // hash code of u're object
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + orders.hashCode();
        return result;
    }
}