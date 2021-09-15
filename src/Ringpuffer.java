import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.util.NoSuchElementException;

public class Ringpuffer<T> {

    int size = 0; // initializing size variable for the ringpuffer
    T[] array; // array that is implemented as a ringpuffer
    int first = 0;
    int last = -1;

// Konstruktor, der ein array der Größe erstellt welches übergeben wird
    public Ringpuffer(int capacity) {
        if(capacity < 0) {
            throw new IllegalArgumentException();
        }
        array = (T[]) new Object[capacity]; // Erstellung des Arrays der übergebenen Größe

    }

    public int size() { // Methode, die die Größe des arrays zurückgibt
        return size;
    }
    /**
     *geprüft
     */
    public T get(int pos) { // Methode, die das Element an der übergebenen Position liefert
        if (pos >= array.length) {// exception, falls pos größer oder gleich der max array kapazität ist
            throw new ArrayIndexOutOfBoundsException();
        }
        else if (array[pos] == null) {// exception, wenn das angefragte Objekt nicht  belegt ist
            throw new NullPointerException();
        }
        return array[pos]; // wenn keine exception geworfen wird, dann gebe das element an der pos zurück

    }
    /**
     *geprüft
     */
    public T set(int pos, T e) { // methode, die das übergebene objekt an pos einfügt und das alte zurückgibt
        if(!(0 <= pos && pos < size)) throw new ArrayIndexOutOfBoundsException(); // exception, wenn übergebene position außerhalb der array größe liegt

        int index = getIndex(pos); // liefert ein aktualisiertes index

        T old = array[index]; // speichert den alten wert, der gleich überschrieben wird

        array[index] = e; // setz das übergebene element an der gewünschten pos ein

        return old; // gibt den alten wert zurück
    }
    /**
     *geprüft
     */
    public void addFirst(T e) { // Methode, die ein Element an erster Stelle einfügen sollte.
        if (size == array.length) { // exception, wenn das array voll ist
            throw new BufferOverflowException();
        }
        first = offsetFromCursor(first, -1); // berechnet den abstand vom zeiger, wo das element an erster stelle eingefügt werden kann

        array[first] = e; // füge das neue element an erster Stelle ein
        size++; // erhöhe die anzahl der elemente im array
    }
    /**
     *geprüft
     */
    public T removeFirst() { // methode, die das erste element entfernt
        if (size == 0) { // wenn size 0 ist, dann gibt es kein element zu entfernen
            throw new BufferUnderflowException();
        }
        T removed = array[first]; // speichere das erste element
        array[first] = null; // setze die erste pos gleich 0

        first = offsetFromCursor(first, 1); // berechne first neu
        size--; // reduziere die anzahl der elemente im array um eins

        return removed; // gebe das entfernte element zurück
    }
    /**
     *geprüft
     */
    public void addLast(T e) { // füge an letzter Stelle ein element ein
        if(size == array.length) { // exception, wenn das array voll ist
            throw new BufferOverflowException();
        }

        last = offsetFromCursor(last, 1); // berechne "last" neu
        array[last] = e; // füge das neue element an der letzten Stelle im array ein

        size++; // erhöhe die anzahl der elemente im array um eins
    }

    /**
     *geprüft
     */
    public T removeLast() { // methode, die das letzte element entfernt
        if(size == 0) { // wenn size 0 ist, dann gibt es nichts zu entfernen
            throw new BufferUnderflowException();
        }

        T removed = array[last]; // speichere das letzte element
        array[last] = null;

        last = offsetFromCursor(last, -1); // berechne "last" neu
        size--; // reduziere die anzahl der elemente im array um eins

        return removed; // gebe das entfernte element zurück
    }

    public int getIndex(int pos) { // Helper-Methode
        return offsetFromCursor(first, pos);
    }

    public int offsetFromCursor(int cursor, int offset) { // Helper-Methode
        return (cursor + offset + array.length) % array.length;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        for(int i = 0; i < array.length; i++) {
            if(i != 0) sb.append(", ");
            if(i == first) sb.append("s");
            if(i == last) sb.append("e");

            sb.append(array[i]);
        }

        return sb.append("]").toString();
    }

}
