package prackt_8;



public class Main
{
        public static void main(String[] args) {
            TableOrdersManager manager = new TableOrdersManager();
            Customer customer = new Customer(20);
            TableOrder t1 = new TableOrder(customer);
            Drink drink = new Drink("Beer", 100, "Just beer", prackt_8.DrinkTypeEnum.BEER, 15);
            t1.add(drink);
            TableOrder t2 = new TableOrder(new Customer(29));
            t2.add(new Drink("Wine", 120, "Some Wine", DrinkTypeEnum.WINE, 10));
            manager.add(t1, 2);
            manager.add(t2, 3);
            System.out.println("Amount of beer " + manager.itemsQuantity("Beer"));
            int[] tables = manager.freeTableNumbers();
            System.out.println("Free tables:");
            for(int i = 0; i < tables.length; i++){
                if(tables[i]!=0)
                System.out.println(tables[i]);
            }
            System.out.println("Amount of wine " + manager.itemsQuantity("Wine"));
            System.out.println("total cost of wine and beer " + manager.ordersCostSummary());
        }
}