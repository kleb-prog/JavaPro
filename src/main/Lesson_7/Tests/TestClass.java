package Lesson_7.Tests;

public class TestClass {

    @BeforeSuite
    public void init(){
        System.out.println("Инициализация");
    }

    @Test(priority = 3)
    public void test1(){
        System.out.println("Test1");
    }

    @Test(priority = 10)
    public void test2(){
        System.out.println("Test2");
    }

    @Test(priority = 2)
    public void test3(){
        System.out.println("Test3");
    }

    @AfterSuite
    public void close(){
        System.out.println("Завершение");
    }
}
