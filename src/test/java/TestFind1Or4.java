import Lesson_6.Find1Or4;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestFind1Or4 {

    private Find1Or4 find1Or4;

    @BeforeEach
    public void init(){
        find1Or4 = new Find1Or4();
    }

    @Test
    public void test1(){
        int[] arr = {1, 2, 4, 4, 2, 3, 4, 1, 7};

        Assertions.assertTrue(find1Or4.isContinued1Or4(arr));
    }

    @Test
    public void test2(){
        // Нет ни 1, ни 4
        int[] arr = {2, 2, 5, 5, 2, 3, 9, 8, 7};

        Assertions.assertFalse(find1Or4.isContinued1Or4(arr));
    }

    @Test
    public void test3(){
        // Только единицы
        int[] arr = {2, 2, 1, 5, 2, 3, 1, 8, 7};

        Assertions.assertFalse(find1Or4.isContinued1Or4(arr));
    }

    @Test
    public void test4(){
        // Пустой
        int[] arr = {};

        Assertions.assertFalse(find1Or4.isContinued1Or4(arr));
    }
}
