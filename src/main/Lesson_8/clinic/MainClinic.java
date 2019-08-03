package Lesson_8.clinic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClinic {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        Registry registry = context.getBean("registry", Registry.class);
        registry.appointToDoctor();


//        Patient patient = new ChildPatient();
//        Patient patient1 = new AdultPatient();
//        Registry registry = new Registry();
//        registry.setPatient(patient);
//        registry.appointToDoctor();
//        registry.setPatient(patient1);
//        registry.appointToDoctor();
    }
}
