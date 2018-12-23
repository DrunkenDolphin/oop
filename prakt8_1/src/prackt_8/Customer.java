package prackt_8;

public class Customer
{
    private String firstName;
    private String secondName;
    private int age;
    private final Customer MATURE_UNKNOWN_CUSTOMER = null;
    private final Customer NOT_MATURE_UNKNOWN_CUSTOMER = null;

    public Customer()
    {
        this.firstName = " ";
        this.secondName = " ";
        this.age = -1;
    }
    public Customer(int age)
    {
        firstName = "Ilya";
        secondName = "Timofeev";
        this.age = age;
    }
    public Customer(String firstName, String secondName, int age)
    {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
    }

    public String getFirstName()
    {
        return firstName;
    }
    public String getSecondName()
    {
        return secondName;
    }
    public int getAge()
    {
        return age;
    }


    // override method "toString"
    @Override
    public String toString()
    {
        return "Customer:" + secondName + firstName + "," + age;
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
        result = prime * result + firstName.hashCode();
        result = prime * result + secondName.hashCode();
        result = prime * result + age;
        return result;
    }

}