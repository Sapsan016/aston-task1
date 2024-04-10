import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListImplTest {

    private CustomArrayList<Integer> testList;

    @BeforeEach
    void setUp() {
        testList = new ArrayListImpl<>();
    }

    @Test
    void sizeShouldBeZero() {
        assertEquals(0, testList.size());
    }

    @Test
    void shouldAddThousandElements() {
        for (int i = 0; i < 1000; i++) {
            testList.add(i);
        }
        assertEquals(1000, testList.size());
        assertEquals(0, testList.get(0));
        assertEquals(999, testList.get(999));
    }

    @Test
    void shouldAddElementAtIndexAndShiftElementRight() {
        testList.add(8, 8);
        assertEquals(8, testList.get(8));
        testList.add(8, 9);
        assertEquals(9, testList.get(8));
        assertEquals(8, testList.get(9));
    }


    @Test
    void shouldRemoveAndShiftElementLeft() {
        testList.add(1);
        testList.add(2);
        testList.remove(0);
        assertEquals(2, testList.get(0));
    }

    @Test
    void shouldClearList() {
        testList.add(1);
        testList.clear();
        assertNull(testList.get(0));
        assertEquals(0, testList.size());
    }

    @Test
    void sort() {
    }
}