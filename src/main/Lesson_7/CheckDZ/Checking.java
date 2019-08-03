package Lesson_7.CheckDZ;

import java.io.File;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class Checking {

    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Checking checking = new Checking();
        Class dz = URLClassLoader.newInstance(new URL[]{new File("C:/test").toURL()}).loadClass("DZ");
       Method[] methods = dz.getDeclaredMethods();

        for (Method m :methods) {
            switch (m.getName()) {
                case "printIsPositive":
                    checking.checkPrintIsPositive(dz, m);
                    break;
                case "printWelocome":
                    checking.checkPrintWelocome(dz, m);
                    break;
                case "isLeapYear":
                    checking.checkIsLeapYear(dz, m);
                    break;
                case "calculate":
                    checking.checkCalculateInt(dz, m);
                    break;
                case "checkTwoNumbers":
                    checking.checkCheckTwoNumbers(dz, m);
                    break;
                case "isNegative":
                    checking.checkIsNegative(dz, m);
                    break;
            }
        }
    }

    private void checkPrintIsPositive(Class c, Method method) throws InvocationTargetException, IllegalAccessException {
        PrintStream newPrint = new PrintStream(System.out){
            @Override
            public void println(String yourString) {
                if (yourString.equals("Your number is positive!")){
                    super.println(method.getName() + " - correct");
                }else {
                    super.println(method.getName() + " - incorrect");
                }


            }
        };
        PrintStream defaultOut = System.out;
        System.setOut(newPrint);

        method.setAccessible(true);
        method.invoke(c, 1);

        System.setOut(defaultOut);
    }

    private void checkIsNegative(Class c, Method method) throws InvocationTargetException, IllegalAccessException {
        method.setAccessible(true);
        if ((boolean)method.invoke(c, -1)){
            System.out.println(method.getName() + " - correct");
        }else System.out.println(method.getName() + " - incorrect");
    }

    private void checkPrintWelocome(Class c, Method method) throws InvocationTargetException, IllegalAccessException {
        PrintStream newPrint = new PrintStream(System.out){
            @Override
            public void println(String yourString) {
                if (yourString.equals("Привет, Test!")){
                    super.println(method.getName() + " - correct");
                }else {
                    super.println(method.getName() + " - incorrect");
                }


            }
        };
        PrintStream defaultOut = System.out;
        System.setOut(newPrint);

        method.setAccessible(true);
        method.invoke(c, "Test");

        System.setOut(defaultOut);
    }

    private void checkIsLeapYear(Class c, Method method) throws InvocationTargetException, IllegalAccessException {
        method.setAccessible(true);
        if ((boolean)method.invoke(c, 2000)){
            System.out.println(method.getName() + " - correct");
        }else System.out.println(method.getName() + " - incorrect");
    }

    private void checkCalculateInt(Class c, Method method) throws InvocationTargetException, IllegalAccessException {
        method.setAccessible(true);
        try {
            if ((int)method.invoke(c, 1, 1, 1, 1) == 2){
                System.out.println(method.getName() + " int - correct");
            }else System.out.println(method.getName() + " int - incorrect");
        } catch (ClassCastException e) {
            checkCalculateFloat(c, method);
        }
    }

    private void checkCalculateFloat(Class c, Method method) throws InvocationTargetException, IllegalAccessException {
        method.setAccessible(true);
        try {
            if ((float)method.invoke(c, 1f, 2f, 3f, 4.0f) == 2.75){
                System.out.println(method.getName() + " float - correct");
            }else System.out.println(method.getName() + " float - incorrect");
        } catch (ClassCastException e) {
            checkCalculateInt(c, method);
        }
    }

    private void checkCheckTwoNumbers(Class c, Method method) throws InvocationTargetException, IllegalAccessException {
        method.setAccessible(true);
        if ((boolean)method.invoke(c, 7, 8)){
            System.out.println(method.getName() + " - correct");
        }else System.out.println(method.getName() + " - incorrect");
    }


}
