
public class HealthyPerson extends Person
{

    private int age;
    private String name;
    private String reason;
    
    //implements the constructor given in the javadoc
    public HealthyPerson(String name,int age, String reason)
    {
        super(name, age);
        this.reason = reason;
    }
    
    public String getReason()
    {
        return reason;
    }
    
    public int compareToImpl(Person o)
    {
        if(!o.getClass().getSimpleName().equals(this.getClass().getSimpleName()))
        {
            return 0;
            //check to see if this returns a positive or negative number
        }else if(this.getName().compareToIgnoreCase(o.getName()) > 0)
        {
            return -1;
        }else if(this.getName().compareToIgnoreCase(o.getName()) < 0)
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
        return String.format("%s In for %s", super.toString(), this.getReason());
    }
}
