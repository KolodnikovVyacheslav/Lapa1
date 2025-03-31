package Collections;

/**
 * Класс контейнера для хранения целых чисел. Реализован на основе динамического массива.
 */
public class Container {

    private int[] array;
    private int size;
    private int capacity;

    /**
     * Создает пустой контейнер с начальной емкостью 10.
     */
    public Container() {
        capacity = 10;
        array = new int[capacity];
        size = 0;
    }

    /**
     * Возвращает количество элементов в контейнере.
     * @return Количество элементов.
     */
    public int size() {
        return size;
    }

    /**
     * Увеличивает массив.
     * @param newCapacity Новая размерность.
     */
    private void resize(int newCapacity) {
        int[] newData = new int[newCapacity];
        System.arraycopy(array, 0, newData, 0, size);
        array = newData;
        capacity = newCapacity;
    }

    /**
     * Добавляет элемент в контейнер.
     * @param element Добавляемый элемент.
     */
    public void add(int element) {
        if (size == capacity)
            resize(capacity * 2);
        array[size++] = element;
    }

    /**
     * Извлекает элемент по индексу.
     * @param index Индекс элемента.
     * @return Элемент по заданному индексу.
     * @throws IndexOutOfBoundsException Если индекс выходит за пределы допустимого диапазона.
     */
    public int get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        return array[index];
    }

    /**
     * Удаляет элемент по индексу.
     * @param index Индекс удаляемого элемента.
     * @throws IndexOutOfBoundsException Если индекс выходит за пределы допустимого диапазона.
     */
    public void remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        for (int i = index; i < size - 1; i++)
            array[i] = array[i + 1];
        size--;
        if (size == capacity / 4)
            resize(capacity / 2);
    }
}
