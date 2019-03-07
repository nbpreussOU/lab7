import java.util.LinkedList;
import java.util.Queue;

public class QueueHospital<PatientType> extends Hospital<PatientType>
{
    private Queue<PatientType> patients;
    public QueueHospital()
    {
        patients = new LinkedList<PatientType>();
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
        return "QueueHospital";
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
