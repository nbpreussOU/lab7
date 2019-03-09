import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueHospital<PatientType> extends Hospital<PatientType> implements Comparator<PatientType>
{
    private PriorityQueue<PatientType> patients;
     
    public PriorityQueueHospital()
    {
        patients = new PriorityQueue<PatientType>();
    }
    
    @Override
    public void addPatient(PatientType patient)
    {
        patients.add(patient);
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
        return ((Person) patient1).compareToImpl((Person) patient2);
    }

}
