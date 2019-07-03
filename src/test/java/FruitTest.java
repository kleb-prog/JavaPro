import Lesson_1.Box;
import Lesson_1.Fruits.Apple;
import Lesson_1.Fruits.Orange;
import org.junit.jupiter.api.Test;

public class FruitTest {
    @Test
    public void testingFruits(){
        Apple apple = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();
        Apple apple4 = new Apple();
        Apple apple5 = new Apple();

        Orange orange = new Orange();
        Orange orange2 = new Orange();
        Orange orange3 = new Orange();
        Orange orange4 = new Orange();
        Orange orange5 = new Orange();

        Box<Apple> appleBox = new Box<Apple>();
        appleBox.add(apple);
        appleBox.add(apple2);
        appleBox.add(apple3);
        appleBox.add(apple4);
        appleBox.add(apple5);

        Box<Orange> orangeBox = new Box<Orange>();
        orangeBox.add(orange);
        orangeBox.add(orange2);
        orangeBox.add(orange3);
        orangeBox.add(orange4);
        orangeBox.add(orange5);

        System.out.println(appleBox.getWeight() + "\n" + orangeBox.getWeight());

        System.out.println(appleBox.compare(orangeBox));

        Box<Apple> newAppleBox = new Box<Apple>();
        appleBox.pour(newAppleBox);

        System.out.println("Старая коробка: " + appleBox.getWeight() + "\nНовая коробка с яблоками из старой: " + newAppleBox.getWeight());
    }
}
