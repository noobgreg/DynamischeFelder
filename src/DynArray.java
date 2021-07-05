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
        }
        else {
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
        T[] tmp = dyn_array;

        if (size() == capacity()) { // if the array is full, then...
            extendCapacity();
        } else {
            for (int i=0; i<size(); i++) {
                dyn_array[i+1] = tmp[i];
            }

        }
        dyn_array[0] = e;
        size++;

    }

    public void extendCapacity() {
        T[] temp = null;
        if (capacity() == size()) {
            temp = (T[]) new Object[size*2]; // initialize a double size array of array
            {
                for (int i = 0; i<size; i++) {
                    temp[i] = dyn_array[i];
                }
            }
        }
        dyn_array = temp;
        capacity = capacity*2;
    }
}






















