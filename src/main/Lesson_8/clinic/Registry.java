package Lesson_8.clinic;

public class Registry {
    private Patient patient;
    private Doctor doctor;


    public void appointToDoctor(){
        doctor = new Doctor(patient);
        doctor.service();
    }


    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
