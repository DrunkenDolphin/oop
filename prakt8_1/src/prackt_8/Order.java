package prackt_8;

import java.awt.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public interface Order
{
    void add(MenuItem item);
    String[] itemsNames();
    int itemsQuantity();
    int itemQuantity(String itemName);
    int itemQuantity(MenuItem itemName);
    MenuItem get(int index);
    MyArrayList<MenuItem> getItems();
    boolean remove(String item);
    boolean remove(MenuItem item);
    int removeFew(String itemName);
    int removeFew(MenuItem item);
    MyArrayList<MenuItem> sortedItemsByCostDesc();
    int costTotal();
    Customer getCustomer();
    void setCustomer(Customer customer);
    String toString();
    int hashCode();
    boolean equals(Object object);

}