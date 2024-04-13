import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class ArrayListImplTest {

    private CustomArrayList<Integer> testList;


    /**
     * Создает новый CustomArrayList перед каждым тестовым методом
     */
    @BeforeEach
    void setUp() {
        testList = new ArrayListImpl<>();
    }

    /**
     * Проверяет что размер нового CustomArrayList равен 0
     */
    @Test
    void sizeShouldBeZero() {
        assertEquals(0, testList.size());
    }

    /**
     * Проверяет что новый CustomArrayList не содержит элементов
     */
    @Test
    void shouldBeEmpty() {
        assertTrue(testList.isEmpty());
    }

    /**
     * Проверяет что в CustomArrayList добавляется 1000000 элементов
     */
    @Test
    void shouldAddMillionElements() {
        for (int i = 0; i < 1000000; i++) {
            testList.add(i);
        }
        assertEquals(1000000, testList.size());
        assertEquals(0, testList.get(0));
        assertEquals(999, testList.get(999));
    }

    /**
     * Проверяет что в CustomArrayList добавляются элементы по индексу и предудущий элемент сдвигается вправо
     */
    @Test
    void shouldAddElementAtIndexAndShiftElementRight() {
        testList.add(8, 8);
        assertEquals(8, testList.get(8));
        testList.add(8, 9);
        assertEquals(9, testList.get(8));
        assertEquals(8, testList.get(9));
    }

    /**
     * Проверяет что при передаче негативного индекса выбрасывается IndexOutOfBoundException
     */

    @Test
    void shouldThrowIndexOutOfBoundsExceptionWhenPassedNegativeIndex() {
        assertThrows(IndexOutOfBoundsException.class,
                () -> testList.add(-1, 1));
    }

    /**
     * Проверяет что из CustomArrayList удаляется элемент по индексу и следующий элемент сдвигается влево
     */
    @Test
    void shouldRemoveAndShiftElementLeft() {
        testList.add(1);
        testList.add(2);
        testList.remove(0);
        assertEquals(2, testList.get(0));
    }

    /**
     * Проверяет что CustomArrayList щчищается от всех элементов
     */
    @Test
    void shouldClearList() {
        testList.add(1);
        testList.clear();
        assertNull(testList.get(0));
        assertEquals(0, testList.size());
    }

    /**
     * Проверяет что в CustomArrayList сортируется
     */
    @Test
    void shouldSortElements() {
        testList.add(5);
        testList.add(3);
        testList.add(2);
        testList.add(7);
        assertEquals(2, testList.sort(testList, (Integer::compare)).get(0));
    }
}