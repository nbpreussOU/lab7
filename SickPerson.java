
public class SickPerson extends Person
{
    private int severity;
    
    //implements the constructor given in the javadoc
    public SickPerson(String name,int age, int severity)
    {
        super(name, age);
        this.severity = severity;
    }
    public int getSeverity()
    {
        return severity;
    }
    
    public int compareToImpl(Person o)
    {
        if(!o.getClass().getSimpleName().equals(this.getClass().getSimpleName()))
        {
            return 0;
            //check to see if this returns a positive or negative number
        }else if(this.getSeverity() >  ((SickPerson) o).getSeverity())
        {
            return -1;
        }else if(this.getSeverity() <  ((SickPerson) o).getSeverity())
        {
            return 1;
        }else
           //the severity is the same
        {
            return 0;
        }
    }
    
    @Override
    public String toString()
    {
        return String.format("%s Severity level %d", super.toString(), this.getSeverity());
    }
}
