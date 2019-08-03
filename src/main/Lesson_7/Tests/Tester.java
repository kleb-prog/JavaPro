package Lesson_7.Tests;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Tester {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        //start(TestClass.class);
        start("Lesson_7.Tests.TestClass");
    }

    public static void start(Class c) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Tester tester = new Tester();
        tester.go(c);
    }
    public static void start(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class c = Class.forName(className);
        Tester tester = new Tester();
        tester.go(c);
    }

    public void go(Class c) throws InvocationTargetException, IllegalAccessException, InstantiationException {

        before(c);
        tests(c);
        after(c);

    }

    void before(Class c) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Object inst = c.newInstance();
        Method[] methods = c.getMethods();
        int counter = 0;

        for (Method m:methods) {
            if (m.isAnnotationPresent(BeforeSuite.class)){
                if (counter == 0){
                    m.invoke(inst);
                    counter++;
                }else throw new RuntimeException("More then one Before method");
            }
        }
    }

    void after(Class c) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Object inst = c.newInstance();
        Method[] methods = c.getMethods();
        int counter = 0;

        for (Method m:methods) {
            if (m.isAnnotationPresent(AfterSuite.class)){
                if (counter == 0){
                    m.invoke(inst);
                    counter++;
                }else throw new RuntimeException("More then one After method");
            }
        }
    }

    void tests(Class c) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Object inst = c.newInstance();
        Method[] methods = c.getMethods();

        for (int i = 10; i > 0; i--) {
            for (Method m:methods) {
                if (m.isAnnotationPresent(Test.class)){
                    if (m.getAnnotation(Test.class).priority() == i){
                        m.invoke(inst);
                    }
                }
            }
        }

    }
}
