import java.nio.BufferOverflowException;
import java.util.NoSuchElementException;

public class Ringpuffer<T> {

    int size = 0; // initializing size variable for the ringpuffer
    T[] array; // array that is implemented as a ringpuffer
    int first = 0;
    int last = 0;

// Konstruktor, der ein array der Größe erstellt welches übergeben wird
    public Ringpuffer(int capacity) {
        array = (T[]) new Object[capacity]; // Erstellung des Arrays der übergebenen Größe
    }

    public int size() { // Methode, die die Größe des arrays zurückgibt
        return size;
    }

    public T get(int pos) { // Methode, die das Element an der übergebenen Position liefert
        if (pos >= array.length) {// exception, falls pos größer oder gleich der max array kapazität ist
            throw new ArrayIndexOutOfBoundsException();
        }
        else if (array[pos] == null) {// exception, wenn das angefragte Objekt nicht  belegt ist
            throw new NullPointerException();
        }
        return array[pos]; // wenn keine exception geworfen wird, dann gebe das element an der pos zurück

    }

    public T set(int pos, T e) { // methode, die das übergebene objekt an pos einfügt und das alte zurück gibt
        if (pos >= array.length ) { // exception, falls pos größer oder gleich der max array kapazität ist
            throw new ArrayIndexOutOfBoundsException();
        }
        else if (array[pos] == null) { // exception, falls das element an der pos nicht belegt ist
            throw new NullPointerException();
        }

        T old = array[pos]; // speichere das alte Element in einer Variable
        array[pos] = e; // überschreibe das alte Element mit dem neuen Element
        return old; // gib das alte Element zurück
    }

    public void addFirst(T e) { // Methode, die ein Element an erster Stelle einfügen sollte.
        if (size == array.length) {
            throw new BufferOverflowException();
        }

        array[first] = e;
        size++;
    }
    public T removeFirst() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        T temp = array[first];
        array[first] = null;
        size--;
        first++;
        first = first % array.length;

        if (size == 0) {
            first = last = -1;
        }
        return temp;
    }

    public void addLast(T e) throws Exception {
        if (array[first] != null) {
            throw new Exception("First element full!");
        }
        array[last] = e;
    }

}
