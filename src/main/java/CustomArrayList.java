import java.util.Comparator;

/**
 * Своя реализация коллекции ArrayList
 *
 * @param <T> тип элементов в коллекции
 */
public interface CustomArrayList<T> {

    /**
     * Возвращвет размер коллекции
     *
     * @return размер коллекции
     */
    int size();

    /**
     * Возвращает true усли коллекция не содержит элементов
     */
    boolean isEmpty();

    /**
     * Добавляет элемент в конец коллекции
     *
     * @param element элемент который добавляется в коллекцию
     */
    void add(T element);

    /**
     * Добавляет элемент в коллекцию на указанный индекс
     *
     * @param index   индекс указывающий куда следует поместить элемент
     * @param element элемент который добавляется в коллекцию
     */
    void add(int index, T element);

    /**
     * Возвращает элемент коллекции по индексу
     *
     * @param index индекс возвращаемого элемента
     * @return элемент найденный по индексу
     * @throws IndexOutOfBoundsException если переданный индекс меньше 0 или больше размера коллекции
     */
    T get(int index);

    /**
     * Удаляет элемент из коллекции по инделсу
     *
     * @param index индекс удаляемого элемента
     */
    void remove(int index);

    /**
     * Очищает коллекцию полностью
     */

    void clear();

    /**
     * Сортирует коллекцию используя переданный Comparator
     */
    CustomArrayList<T> sort(CustomArrayList<T> list, Comparator<? super T> comparator);
}
