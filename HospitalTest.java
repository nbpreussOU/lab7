import org.junit.Assert;
import org.junit.Test;

/**
 * Lab 7
 *
 * Test class for persons and hospitals
 * Did not implement tests for code that was given to me
 * 
 * @author Nathan
 */
public class HospitalTest
{
	/**
	 * Test the healthy person consrtuctor, and getReason method
	 */
	@Test
	public void healthyPersonConstructorTest()
	{
	    HealthyPerson per = new HealthyPerson("Joe", 45, "Checkup");
        Assert.assertEquals("HealthyPerson name incorect.", "Joe", per.getName());
        Assert.assertEquals("HealthyPerson age incorect", 45, per.getAge());
        Assert.assertEquals("HealthyPerson reason incorect", "Checkup", per.getReason());
	}
	
	/**
     * Test the sick person consrtuctor, and getSeverity method
     */
    @Test
    public void sickPersonConstructor()
    {
        SickPerson per = new SickPerson("Fred", 72, 9);
        Assert.assertEquals("SickPerson name incorect.", "Fred", per.getName());
        Assert.assertEquals("SickPerson age incorect", 72, per.getAge());
        Assert.assertEquals("SickPerson reason incorect", 9, per.getSeverity());
    }
    
    /**
     * Test the healthy person comparison method
     */
    @Test
    public void healthyPersonCompareToImplTest()
    {
        HealthyPerson per = new HealthyPerson("Joe", 45, "Checkup");
        HealthyPerson per1 = new HealthyPerson("Alfred", 31,  "Eye Exam");
        SickPerson per2 = new SickPerson("Fred", 31,  4);
        HealthyPerson per3 = new HealthyPerson("Alfred", 27,  "Yearly Visit");
        
        Assert.assertEquals("HealthyPerson compare class incorrect.", 0, per.compareToImpl(per2));
        Assert.assertEquals("HealthyPerson compare differnet name incorect", -1, per.compareToImpl(per1));
        Assert.assertEquals("HealthyPerson compare different name 2 incorect", 1, per1.compareToImpl(per));
        Assert.assertEquals("HealthyPerson same name incorect", 0, per3.compareToImpl(per1));
    }
    
    /**
     * Test the sick person comparison method
     */
    @Test
    public void hsickPersonCompareToImplTest()
    {
        SickPerson per = new SickPerson("Joe", 45, 2);
        SickPerson per1 = new SickPerson("Alfred", 31,  5);
        HealthyPerson per2 = new HealthyPerson("Fred", 31,  "Eye Exam");
        SickPerson per3 = new SickPerson("Alfred", 27,  2);
        
        Assert.assertEquals("SickPerson compare class incorrect.", 0, per.compareToImpl(per2));
        Assert.assertEquals("SickPerson compare differnet name incorect", 1, per.compareToImpl(per1));
        Assert.assertEquals("SickPerson compare different name 2 incorect", -1, per1.compareToImpl(per));
        Assert.assertEquals("SickPerson same severity incorect", 0, per3.compareToImpl(per));
    }
    
    /**
     * Test the healthy Person toString method
     */
    @Test
    public void healthyPersonToStringTest()
    {
        HealthyPerson per = new HealthyPerson("Fred", 72, "Eye Exam");
        Assert.assertEquals("HealthyPerson toString incorrect", "Fred, a 72-year old. In for Eye Exam", per.toString());
    }
    
    /**
     * Test the sick Person toString method
     */
    @Test
    public void sickPersonToStringTest()
    {
        SickPerson per = new SickPerson("Kyle", 19, 4);
        Assert.assertEquals("SickPerson toString incorrect", "Kyle, a 19-year old. Severity level 4", per.toString());
    }
    
    /**
     * Test the stack hospital's addPatient, nextPatient, numPatients, hospital type, and all info methods
     */
    @Test
    public void mostFunctionsStackHospitalTest()
    {
        SickPerson per = new SickPerson("Kyle", 19, 4);
        SickPerson per1 = new SickPerson("Alfred", 31,  5);
        HealthyPerson per2 = new HealthyPerson("Fred", 31,  "Eye Exam");
        SickPerson per3 = new SickPerson("Alfred", 27,  2);
        StackHospital<Person> aStack = new StackHospital<>();
        
        aStack.addPatient(per);
        aStack.addPatient(per1);
        aStack.addPatient(per2);
        aStack.addPatient(per3);
        
        Assert.assertEquals("StackHospital nextPatient incorrect", per3, aStack.nextPatient());
        Assert.assertEquals("StackHospital numPatient incorrect", 4, aStack.numPatients());
        Assert.assertEquals("StackHospital HospitalType incorrect", "StackHospital", aStack.hospitalType());
        Assert.assertEquals("StackHospital allPatientInfo incorrect", "Alfred, a 27-year old. Severity level 2Fred, a 31-year old. In for Eye ExamAlfred, a 31-year old. Severity level 5Kyle, a 19-year old. Severity level 4", aStack.allPatientInfo());
    }
    
    /**
     * Test the stack hospital's treatPatient method
     */
    @Test
    public void treatPatientStackHospital()
    {

        SickPerson per = new SickPerson("Kyle", 19, 4);
        SickPerson per1 = new SickPerson("Alfred", 31,  5);
        HealthyPerson per2 = new HealthyPerson("Fred", 31,  "Eye Exam");
        SickPerson per3 = new SickPerson("Alfred", 27,  2);
        StackHospital<Person> aStack = new StackHospital<>();
        
        aStack.addPatient(per);
        aStack.addPatient(per1);
        aStack.addPatient(per2);
        aStack.addPatient(per3);
        
        Assert.assertEquals("StackHospital treatnextPatient incorrect", per3, aStack.treatNextPatient());
        Assert.assertEquals("StackHospital treatnextPatient incorrect", per2, aStack.nextPatient());
    }
    
    /**
     * Test the queue hospital's addPatient, nextPatient, numPatients, hospital type, and all info methods
     */
    @Test
    public void mostFunctionsQueueHospitalTest()
    {
        SickPerson per = new SickPerson("Kyle", 19, 4);
        SickPerson per1 = new SickPerson("Alfred", 31,  5);
        HealthyPerson per2 = new HealthyPerson("Fred", 31,  "Eye Exam");
        SickPerson per3 = new SickPerson("Alfred", 27,  2);
        QueueHospital<Person> aQueue = new QueueHospital<>();
        
        aQueue.addPatient(per);
        aQueue.addPatient(per1);
        aQueue.addPatient(per2);
        aQueue.addPatient(per3);
        
        Assert.assertEquals("StackHospital nextPatient incorrect", per, aQueue.nextPatient());
        Assert.assertEquals("StackHospital numPatient incorrect", 4, aQueue.numPatients());
        Assert.assertEquals("StackHospital HospitalType incorrect", "QueueHospital", aQueue.hospitalType());
        Assert.assertEquals("StackHospital allPatientInfo incorrect", "Kyle, a 19-year old. Severity level 4Alfred, a 31-year old. Severity level 5Fred, a 31-year old. In for Eye ExamAlfred, a 27-year old. Severity level 2", aQueue.allPatientInfo());
    }
    
    /**
     * Test the queue hospital's treatPatient method
     */
    @Test
    public void treatPatientQueueHospital()
    {

        SickPerson per = new SickPerson("Kyle", 19, 4);
        SickPerson per1 = new SickPerson("Alfred", 31,  5);
        HealthyPerson per2 = new HealthyPerson("Fred", 31,  "Eye Exam");
        SickPerson per3 = new SickPerson("Alfred", 27,  2);
        QueueHospital<Person> aQueue = new QueueHospital<>();
        
        aQueue.addPatient(per);
        aQueue.addPatient(per1);
        aQueue.addPatient(per2);
        aQueue.addPatient(per3);
        
        Assert.assertEquals("StackHospital treatnextPatient incorrect", per, aQueue.treatNextPatient());
        Assert.assertEquals("StackHospital treatnextPatient incorrect", per1, aQueue.nextPatient());
    }
    
    /**
     * Test the priority queue hospital's addPatient, nextPatient, numPatients, hospital type, and all info methods
     */
    @Test
    public void mostFunctionsPriorityQueueHospitalTest()
    {
        SickPerson per = new SickPerson("Kyle", 19, 4);
        SickPerson per1 = new SickPerson("Alfred", 31,  5);
        HealthyPerson per2 = new HealthyPerson("Fred", 31,  "Eye Exam");
        SickPerson per3 = new SickPerson("Alfred", 27,  2);
        PriorityQueueHospital<Person> PrioQueue = new PriorityQueueHospital<>();
        
        PrioQueue.addPatient(per);
        PrioQueue.addPatient(per1);
        PrioQueue.addPatient(per2);
        PrioQueue.addPatient(per3);
        
        Assert.assertEquals("StackHospital nextPatient incorrect", per1, PrioQueue.nextPatient());
        Assert.assertEquals("StackHospital numPatient incorrect", 4, PrioQueue.numPatients());
        Assert.assertEquals("StackHospital HospitalType incorrect", "PriorityQueueHospital", PrioQueue.hospitalType());
        Assert.assertEquals("StackHospital allPatientInfo incorrect", "Alfred, a 31-year old. Severity level 5Kyle, a 19-year old. Severity level 4Fred, a 31-year old. In for Eye ExamAlfred, a 27-year old. Severity level 2", PrioQueue.allPatientInfo());
    }
    
    /**
     * Test the prioirityQueue hospital's treatPatient method
     */
    @Test
    public void treatPatientPrioirityQueueHospital()
    {

        SickPerson per = new SickPerson("Kyle", 19, 4);
        SickPerson per1 = new SickPerson("Alfred", 31,  5);
        HealthyPerson per2 = new HealthyPerson("Fred", 31,  "Eye Exam");
        SickPerson per3 = new SickPerson("Alfred", 27,  2);
        PriorityQueueHospital<Person> PrioQueue = new PriorityQueueHospital<>();
        
        PrioQueue.addPatient(per);
        PrioQueue.addPatient(per1);
        PrioQueue.addPatient(per2);
        PrioQueue.addPatient(per3);
        
        Assert.assertEquals("StackHospital treatnextPatient incorrect", per1, PrioQueue.treatNextPatient());
        Assert.assertEquals("StackHospital treatnextPatient incorrect", per, PrioQueue.nextPatient());
    }
}
