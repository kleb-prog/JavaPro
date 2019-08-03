package Lesson_8.clinic;

public class Doctor {

    private Patient patient;

    public Doctor(Patient patient) {
        this.patient = patient;
    }

    public void service(){
        System.out.println("Врач принял " + patient.getName());
    }
}
