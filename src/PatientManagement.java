
import java.util.List;
import java.util.Scanner;

public class PatientManagement {

        public static void main(String[] args) {
            //create interface constant
            PatientDAO dao = (PatientDAO) PatientDAOImpl.PatientDAOlmpl.getInstance();

            //getAllPatient
            displayAllPatient(dao);
            //Add new Patient
            addPatient (dao);
            //update Patient
            updatePatient (dao);
            //delete Patient
            deletePatient (dao);
            //find Patient
            findPatient (dao);
        }//main
    private static void deletePatient(PatientDAO dao) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Delete Patient with ID: ");
        int id = Integer.parseInt(sc.nextLine().trim());
        dao.deletePatient(id);
    }

    private static Patient updatePatient(PatientDAO dao) {
        Patient ptt = updatePatient(dao);
        Scanner sc=new Scanner(System.in);
        System.out.print("Update new P_blood_result for Patient ID"
                +ptt.getP_ID()+":");
        String ns=String.valueOf(sc.nextLine().trim());
        ptt.setP_blood_result(ns);
        dao.updatePatient(ptt);
        System.out.println("Update Patient with ID:"+ptt.getP_ID());
        return ptt;
    }

    private static Patient findPatient(PatientDAO dao) {

        Scanner sc =new Scanner(System.in);
        System.out.print("Enter an Patient ID:");
        int id =Integer.parseInt(sc.nextLine().trim());
        Patient ptt = dao.findPatient(id);
        System.out.println(ptt.toString());
        return ptt;
    }


    private static void addPatient(PatientDAO dao) {
            Scanner sc = new Scanner(System.in);
            //input data
            System.out.print("Enter Patient p_ID:");
            int p_ID = Integer.parseInt(sc.nextLine().trim());
            System.out.print("Enter Patient p_name:");
            String p_name = sc.nextLine().trim();
            System.out.print("Enter Patient p_gender:");
            String p_gender = sc.nextLine().trim();
            System.out.print("Enter Patient p_age");
            int p_age =Integer.parseInt(sc.nextLine().trim());
            System.out.print("Enter Patient p_address:");
            String p_address = sc.nextLine().trim();
            System.out.print("Enter Patient p_blood_result:");
            String p_blood_result = sc.nextLine().trim();

            //insert data to database

        Patient newPatient = new Patient(p_ID, p_name, p_gender, p_age,p_address,p_blood_result);
            dao.addPatient(newPatient);
        }

        private static void displayAllPatient(PatientDAO dao) {
            List<Patient> myPatient = dao.getAllPatient();
            for (Patient patient : myPatient) {
                System.out.println(patient.toString());
            }
        }

    }//class


