package object_oriented_programming.ObjectModelling;

class Doctor {
    private String name;

    Doctor(String name) {
        this.name = name;
    }

    void consult(Patient patient) {
        System.out.println("Dr." + name + " consulted " + patient.getName());
    }
}

class Patient {
    private String name;

    Patient(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }
}

class HospitalDemo {
    public static void main(String[] args) {
        Doctor doctor = new Doctor("James Bond");
        Patient patient = new Patient("Ravi");

        doctor.consult(patient);
    }
}