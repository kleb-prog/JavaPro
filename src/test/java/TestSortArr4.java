import Lesson_6.SortArr4;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestSortArr4 {

    private SortArr4 sortArr4;

    @BeforeEach
    public void init(){
        sortArr4 = new SortArr4();
    }

    @Test
    public void test1(){
        int[] arr = {1, 2, 4, 4, 2, 3, 4, 1, 7};
        int[] exp = {1, 7};
        Assertions.assertArrayEquals(exp, sortArr4.valuesAfter4(arr));
    }

    @Test void test2(){
        //Если 4 в конце

        int[] arr = {1, 2, 4, 4, 2, 3, 4, 1, 4};
        int[] exp = {};
        Assertions.assertArrayEquals(exp, sortArr4.valuesAfter4(arr));
    }

    @Test
    public void test3(){
        // Если 4 в массиве нет
        int[] arr = {1, 2, 5, 5, 2, 3, 7, 1, 1};
        Assertions.assertThrows(RuntimeException.class, () -> {sortArr4.valuesAfter4(arr);});
    }
}
