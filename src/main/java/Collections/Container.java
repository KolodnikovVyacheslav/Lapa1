package Collections;

public class Container {

    private int[] array;
    private int size;
    private int capacity;

    public Container() {
        capacity = 10;
        array = new int[capacity];
        size = 0;
    }

    public int size() {
        return size;
    }

    private void resize(int newCapacity) {
        int[] newData = new int[newCapacity];
        System.arraycopy(array, 0, newData, 0, size);
        array = newData;
        capacity = newCapacity;
    }

    public void add(int element) {
        if (size == capacity)
            resize(capacity * 2);
        array[size++] = element;
    }

    public int get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        return array[index];
    }

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
