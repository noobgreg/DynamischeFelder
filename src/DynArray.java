import java.util.Arrays;

public class DynArray<T> {

    int size;
    int capacity;
    T[] dyn_array;

    @SuppressWarnings("unchecked")
    public DynArray() {
        size = 0;
        capacity = 1;
        dyn_array = (T[]) new Object[capacity]; //Generic Array with the capacity of 1.
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return dyn_array.length;
    }

    public T get(int pos) throws Exception {
        T element;
        if (dyn_array[pos] != null) {
            element = dyn_array[pos];
        } else {
            throw new Exception("The position you have entered is empty, please try another position!");
        }
        return element;
    }

    public T set(int pos, T e) throws Exception {
        T element = null;

        if (get(pos) != null) {
            element = dyn_array[pos];
            dyn_array[pos] = e;
        }

        return element;
    }

    public void addFirst(T e) {
        if (size == dyn_array.length) {
            changeCapacity(dyn_array.length * 2, 0, 1);
        } else {
            System.arraycopy(dyn_array, 0, dyn_array, 1, size);
        }

        dyn_array[0] = e;
        size++;
    }

    public void addLast(T e) {
        if (size == dyn_array.length) {
            changeCapacity(dyn_array.length * 2, 0, 1);
        }

        dyn_array[size] = e;
        size++;

    }

    private void changeCapacity(int capacity) {
        changeCapacity(capacity, 0, 0);
    }


    private void changeCapacity(int capacity, int readOffset, int writeOffset) {
        T[] newContent = (T[]) new Object[capacity];

        System.arraycopy(dyn_array, readOffset, newContent, writeOffset, size);

        dyn_array = newContent;
    }
}