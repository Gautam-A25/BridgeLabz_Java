package object_oriented_programming.Encapsulation;

interface MedicalRecord {
    void addRecord(String record);
    String viewRecords();
}

abstract class Patient {
    private int patientId;
    private String name;
    private int age;

    Patient(int id, String n, int a) {
        patientId = id;
        name = n;
        age = a;
    }

    abstract double calculateBill();

    void getPatientDetails() {
        System.out.println(name);
    }
}

class InPatient extends Patient {
    InPatient(int id, String n, int a) {
        super(id, n, a);
    }

    double calculateBill() {
        return 5000;
    }
}

public class HospitalDemo {
    public static void main(String[] args) {
        Patient p = new InPatient(1, "Aayush", 21);
        System.out.println(p.calculateBill());
    }
}
