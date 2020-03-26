import java.util.List;

public interface PatientDAO {


    public List<Patient>getAllPatient();

    public void addPatient(Patient newPatient);

    public void updatePatient (Patient Mobile);

    public void deletePatient(int id);

    public Patient findPatient(int id);




}//interface
