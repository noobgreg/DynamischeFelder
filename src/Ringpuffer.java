public class Ringpuffer<T> {

    int size = 0; // initializing size variable for the ringpuffer
    T[] content = null; // array that is implemented as a ringpuffer
    int first = 0;
    int last = 0;

// constructor that creates an array of the given capacity
    public Ringpuffer(int capacity) {
        content = (T[]) new Object[capacity];
    }

// method that returns the size of the array
    public int size() {
        return size;
    }

// method that returns the element at a specific position otherwise throws exception
    public T get(int pos) {
        // if input pos is bigger than the capacity and there is no content at the pos then throw exception
        if (pos >= content.length || content[pos] == null) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return content[pos]; // if everything is correct return the value at the given position
    }

    public T set(int pos, T e) {
        if (pos >= content.length || pos == 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        else if (content[pos] == null) {
            throw new NullPointerException();
        }

        T old = content[pos];
        content[pos] = e;
        return old;
    }
    public void addFirst(T e) throws Exception {
        if (content[first] != null) {
            throw new Exception("First element full!");
        }
        content[first] = e;
        size++;
    }

    public void addLast(T e) throws Exception {
        if (content[first] != null) {
            throw new Exception("First element full!");
        }
        content[last] = e;
    }

}
