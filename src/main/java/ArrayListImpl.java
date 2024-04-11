import java.util.Arrays;
import java.util.Comparator;

/**
 * Имплементация интерфейса CustomArrayList
 */
public class ArrayListImpl<T> implements CustomArrayList<T> {

    /**
     * Размер коллекции
     */
    private int size = 0;

    /**
     * Вместимость по умолчанию
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Изначальный массив
     */
    private Object[] elements;

    /**
     * Конструктор создающий коллекцию с начальной вместимостью по умолчанию
     */
    public ArrayListImpl() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    /**
     * Конструктор создающий коллекцию с определенной начальной вместимостью
     *
     * @param capacity начальная вместимость коллекции
     */
    public ArrayListImpl(int capacity) {
        elements = new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(Object element) {
        checkCapacity();
        elements[size] = element;
        size++;
    }

    @Override
    public void add(int index, Object element) {
        checkIndex(index);
        checkCapacity();
        for (int i = elements.length - 2; i >= index; i--) {
            elements[i + 1] = elements[i];
        }
        elements[index] = element;
        size++;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < elements.length - 2; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
    }

    @Override
    public void clear() {
        Object[] empty = elements;
        for (int i = 0; i < size; i++)
            empty[i] = null;
        size = 0;
    }


    @Override
    public String toString() {
        return "ArrayListImpl{" +
                "size=" + size +
                ", elements=" + Arrays.toString(elements) +
                '}';
    }

    @Override
    public CustomArrayList<T> sort(CustomArrayList<T> list, Comparator<? super T> comparator) {
        if (list.isEmpty() || list.size() < 2)
            return list;
        ArrayListImpl<T> smaller = new ArrayListImpl<>();
        ArrayListImpl<T> greater = new ArrayListImpl<>();
        T pivot = list.get(0);
        for (int i = 1; i < list.size(); i++) {
           T j = list.get(i);
            if (comparator.compare(j, pivot) < 0)
                smaller.add(j);
            else
                greater.add(j);
        }
        smaller = (ArrayListImpl<T>) sort(smaller, comparator);
        greater = (ArrayListImpl<T>) sort(greater, comparator);
        smaller.add(pivot);

        for (int k = 0; k < greater.size; k++) {
            smaller.add(greater.get(k));
        }
        return smaller;
    }

    /**
     * Увеличивает в два раза размер коллекции
     */
    private void increaseCapacity() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    /**
     * Проверяет что индекс положительное число и не выходит за границы размера коллекции
     *
     * @param index проверяемый индекс
     */
    private void checkIndex(int index) {
        if (index < 0 || index > elements.length)
            throw new IndexOutOfBoundsException(index);
    }

    /**
     * Проверяет размер коллекции и при необходимости вызывает метод увеличения коллекции
     */
    private void checkCapacity() {
        if (size == elements.length)
            increaseCapacity();
    }
}
