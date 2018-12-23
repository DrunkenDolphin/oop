package prackt_8;

public abstract class MenuItem
{
    protected int price; // price of u're dish or drink
    protected String name; // name of u're dish or drink
    protected String description; // description
    public MenuItem(){
        price = -1;
        name = "s";
        description = "s";
    }
    public MenuItem(int price, String name, String description)
    {
        this.price = price;
        this.name = name;
        this.description = description;
    }

    public int getPrice()
    {
        return price;
    }
    public String getName()
    {
        if(this!=null)
            return name;
        return " ";
    }
    public String getDescription()
    {
        return description;
    }

    // override method "toString"
    @Override
    public String toString()
    {
        return "MenuItem:" + price + ",Name:" + name;
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
        int result = 2;
        result = prime * result + price;
        result = prime * result + name.hashCode();
        result = prime * result + description.hashCode();
        return result;
    }
}