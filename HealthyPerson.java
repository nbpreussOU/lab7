
public class HealthyPerson
{

    private int age;
    private String name;
    private String reason;
    
    //implements the constructor given in the javadoc
    public HealthyPerson(String name,int age, String reason)
    {
        this.name = name;
        this.age = age;
        this.reason = reason;
    }
    
    public int compareToImpl(Person o)
    {
        if(o.getClass().getSimpleName().equals("HealthyPerson"))
        {
            return 0;
            //check to see if this returns a positive or negative number
        }else if(this.name.compareToIgnoreCase(o.getName()) > 0)
        {
            return -1;
        }else if(this.name.compareToIgnoreCase(o.getName()) < 0)
        {
            return 1;
        }else
           //the names are the same
        {
            return 0;
        }
    }
    
    @Override
    public String toString()
    {
        return String.format("%s", this.name) + " In for " + String.format("%s",  this.name);
    }
}
