import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class PriorityQueueHospital<PatientType> extends Hospital<PatientType> implements Comparator<PatientType>
{
    private Queue<PatientType> patients;
     
    public PriorityQueueHospital()
    {
        patients = new LinkedList<PatientType>();
    }
    
    @Override
    public void addPatient(PatientType patient)
    {
         //TODO figure out where in the severity list this person belongs, and add them there
    }

    @Override
    public PatientType nextPatient()
    {
       return patients.peek();
    }

    @Override
    public PatientType treatNextPatient()
    {
        return patients.remove();
    }

    @Override
    public int numPatients()
    {
        return patients.size();
    }

    @Override
    public String hospitalType()
    {
        return "PriorityQueueHospital";
    }

    @Override
    public String allPatientInfo()
    {
        String allPatients = "";
        for(PatientType o: patients)
        {
            allPatients += o.toString();
        }
        return allPatients;
    }

    @Override
    public int compare(PatientType patient1, PatientType patient2)
    {
        if(((SickPerson) patient1).getSeverity() > ((SickPerson) patient2).getSeverity()) {
            return 1;
        }else if(((SickPerson) patient1).getSeverity() < ((SickPerson) patient2).getSeverity())
        {
            return -1;
        }else
        {
            return 0;
        }
    }

}
