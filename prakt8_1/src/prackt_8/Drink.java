package prackt_8;

public class Drink extends MenuItem implements Alcoholable
{
    private double alcoholDegree; // number of degree in the drink
    private DrinkTypeEnum typeEnum; // type of drink (non Alcoholic or alcoholic)

    public Drink(String name, int price, String description, DrinkTypeEnum typeEnum, double alcoholDegree)
    {
        super(price, name, description);
        this.alcoholDegree = alcoholDegree;
        this.typeEnum = typeEnum;
    }
    public Drink(String name, int price, String description, DrinkTypeEnum typeEnum)
    {
        super(price, name, description);
        this.alcoholDegree = 0;
        this.typeEnum = typeEnum;
    }
    public Drink(String name, DrinkTypeEnum typeEnum)
    {
        super(0 , name, "s");
        this.alcoholDegree = 0;
        this.typeEnum = typeEnum;
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

    //check for the presence of alcohol
    public boolean isAlcoholicDrink()
    {
        if(alcoholDegree > 0)
            return true;
        else
            return false;
    }
    // return number of alcohol degree
    public double getAlcoholVol()
    {
        return alcoholDegree;
    }
    // return the type of the drink
    public DrinkTypeEnum getType()
    {
        return typeEnum;
    }

    @Override
    public String toString()
    {
        return "Drink:" + typeEnum + name + "-" + price + ",Alcohol" + alcoholDegree + "% -" + description;
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
        int result = 5;
        result = prime * result + price;
        result = prime * result + name.hashCode();
        result = prime * result + description.hashCode();
        result = prime * result + (int)alcoholDegree;
        result = prime * result + typeEnum.hashCode();
        return result;
    }
}