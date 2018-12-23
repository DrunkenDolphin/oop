package prackt_8;

public class Dish extends MenuItem
{
    public Dish(int price, String name, String description)
    {
        super(price, name, description);
    }
    public Dish(String name, String description)
    {
        super(0 , name, description);
    }
    public int getPrice()
    {
        return price;
    }
    public String getName()
    {
        return name;
    }
    public String getDescription()
    {
        return description;
    }
    @Override
    public String toString()
    {
        return "Dish:" + name + price + description;
    }
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
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 3;
        result = prime * result + price;
        result = prime * result + name.hashCode();
        result = prime * result + description.hashCode();
        return result;
    }
}