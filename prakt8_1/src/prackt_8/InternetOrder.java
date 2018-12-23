package prackt_8;

import java.awt.*;

public class InternetOrder implements Order
{
    private Customer customer; // customer of order
    private int size; // number of element in array
    private MyArrayList<MenuItem> items = new MyArrayList<MenuItem>(); // array of orders

    public InternetOrder()
    {
        this.customer = null;
    }
    public InternetOrder(Customer customer, MenuItem[] items)
    {
        this.customer = customer;
    }

    private void sort(MyArrayList<MenuItem> items)
    {
        for(int i = 0; i < size - 1; i++)
            for(int j = 0; j < size - 1; j++)
            {
                if(items.get(j).getPrice() < items.get(j).getPrice())
                {
                    MenuItem item = items.get(j);
                    items.set(items.get(j+1),j);
                    items.set(item,j+1);
                }
            }
    }

    @Override
    public MenuItem get(int index)
    {
        return items.get(index);
    }
    // add item in array

    @Override
    public void add(MenuItem item)
    {
        items.add(item);
    }
    // returns name of all orders
    @Override
    public String[] itemsNames()
    {
        String[] names = new String[size];
        for(int i = 0; i < size; i++)
            names[i] = items.get(i).getName();
        return names;
    }
    // number of element in array of order
    @Override
    public int itemsQuantity()
    {
        return size;
    }
    // returns the number of elements with the given name
    @Override
    public int itemQuantity(String itemName)
    {
        int count = 0;
        for(int i = 0; i < size; i++)
            if(items.get(i).getName() == itemName)
                count++;
        return count;
    }
    // returns the number of elements with the given name
    @Override
    public int itemQuantity(MenuItem itemName)
    {
        int count = 0;
        for(int i = 0; i < size; i++)
            if(items.get(i) == itemName)
                count++;
        return count;
    }
    // returns all order
    @Override
    public MyArrayList<MenuItem> getItems()
    {
        return items;
    }
    // remove item with given name
    @Override
    public boolean remove(String item)
    {
        for(int i = 0; i < size; i++)
            if(items.get(i).getName() == item)
            {
                items.delete(i);
                return true;
            }
        return false;
    }
    // remove the selected item. if there are more than 1, delete the first
    @Override
    public boolean remove(MenuItem item)
    {
        for(int i = 0; i < size; i++)
            if(items.get(i) == item)
            {
                items.delete(i);
                return true;
            }
        return false;
    }
    // remove few element with selected name
    @Override
    public int removeFew(String itemName)
    {
        int count = 0;
        for(int i = 0; i < size; i++)
            if(items.get(i).getName() == itemName)
            {
                items.delete(i);
                count++;
            }
        return count;
    }
    // remove few element with selected name
    @Override
    public int removeFew(MenuItem item)
    {
        int count = 0;
        for(int i = 0; i < size; i++)
            if(items.get(i) == item)
            {
                items.delete(i);
                count++;
            }
        return count;
    }
    // sort the array by price decrease
    @Override
    public MyArrayList<MenuItem> sortedItemsByCostDesc()
    {
        sort(items);
        return items;
    }
    // returns total cost of order
    @Override
    public int costTotal()
    {
        int total = 0;
        for(int i = 0; i < size; i++)
            total += items.get(i).getPrice();
        return total;
    }
    // getCustomer
    @Override
    public Customer getCustomer()
    {
        return customer;
    }
    //setCustomer
    @Override
    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }
    public String toString()
    {
        String result = "Table order:" + size + '\n';
        for(int i = 0; i < size; i++)
            result += items.get(i).toString() + '\n';
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
        int result = 9;
        result = prime * result + customer.hashCode();
        result = prime * result + items.hashCode();
        result = prime * result + size;
        return result;
    }
}