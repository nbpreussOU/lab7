import java.util.Deque;
import java.util.LinkedList;

public class StackHospital<PatientType> extends Hospital<PatientType>
{
    private Deque<PatientType> patients;
    public StackHospital()
    {
        patients = new LinkedList<PatientType>();
    }
    
    @Override
    public void addPatient(PatientType patient)
    {
         patients.addFirst(patient);       
    }

    @Override
    public PatientType nextPatient()
    {
       return patients.getFirst();
    }

    @Override
    public PatientType treatNextPatient()
    {
        return patients.removeFirst();
    }

    @Override
    public int numPatients()
    {
        return patients.size();
    }

    @Override
    public String hospitalType()
    {
        return "StackHospital";
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

}
