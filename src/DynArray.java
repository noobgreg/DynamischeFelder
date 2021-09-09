import java.util.NoSuchElementException;

public class DynArray<T> {

    int size; // variable, die die Anzahl der Elemente im Array speichert
    int capacity; // variable, für das maximale Fassungsvermögen des Arrays
    T[] dyn_array; // das generische Array selbst

    @SuppressWarnings("unchecked")
    public DynArray() { // Konstruktor der ein Array mit 1 als max Kapazität anlegt
        size = 0;
        capacity = 1;
        dyn_array = (T[]) new Object[capacity]; // anlegen eines Arrays mit Kapazität 1
    }

    public int size() { // Methode, die die Anzahl der Elemente im Array zurückgibt
        return size;
    }

    public int capacity() { // Methode, welches das max. Fassungsvermögen zurückgibt
        return dyn_array.length;
    }

    public T get(int pos) { // Methode, welches ein Element an einer bestimmten Position liefert
        if(pos < 0 && pos >= capacity) throw new ArrayIndexOutOfBoundsException(); // pos negativ oder größer als capacity

        return dyn_array[pos]; // Element welches zurückgegeben wird
    }

    public T set(int pos, T e) { // Methode, die ein Element überschreibt
        if(pos < 0 && pos >= capacity) throw new ArrayIndexOutOfBoundsException(); // exception
        T elementToOverwrite = null; // variable welches überschrieben werden soll, falls es existiert

        if (get(pos) != null) { // wenn die angeforderte position belegt ist...
            elementToOverwrite = dyn_array[pos]; // ...dann speichere das Element, welches an der Position ist, in der Variable
            dyn_array[pos] = e; // überschreibe jetzt dieses Element mit dem neuen Element
        }

        return elementToOverwrite; // gebe das überschriebene Element zurück
    }

    public void addFirst(T e) { // Methode, die ein Element an der ersten Position einfügt
        if (size == dyn_array.length) { // wenn das array voll ist...
            changeCapacity(dyn_array.length * 2, 0, 1); //...dann erhöhe die max Kapazität
        } else { // sonst...
            System.arraycopy(dyn_array, 0, dyn_array, 1, size); // kopiere das Array und verschiebe alle Elemente um eins nach rechts
        }

        dyn_array[0] = e; // füge das Element an der ersten Position im Array ein
        size++; // erhöhe die Anzahl der Elemente im Array
    }

    public void addLast(T e) { // Methode, die ein Element an das Array dranhängen sollte
        if (size == dyn_array.length) { // wenn array voll ist,...
            changeCapacity(dyn_array.length * 2); //...dann verdopple die max Kapazität um eins
        }

        dyn_array[size] = e; // füge das neue Element an der ersten freien Stelle im array ein
        size++; // erhöhe die Anzahl der Elemente im Array

    }

    public T removeFirst() { // Methode, die das erste Element im Array entfernt
        if (size == 0) throw new NoSuchElementException(); // exaception

        T removed = dyn_array[0]; // speichere das element welches entfernt werden sollte in einer variable

        if (size-1 <= dyn_array.length / 4) { // wenn die größe des arrays nur noch 1/4 der gesamten Kapazität ausmacht...
            changeCapacity(dyn_array.length / 2, 1, 0); // ...dann halbiere die array größe und verschiebe die Elemente um eine Stelle nach links
        } else {
            System.arraycopy(dyn_array, 1, dyn_array, 0, size); // wenn nicht, dann verschiebe nur die Elemente um eins nach links
            size--; // reduziere die Anzahl der Elemente im array
        }
        return removed; // gib das entfernte Element zurück
    }

    public T removeLast() { // Methode um das letzte Element im Array zu entfernen
        if (size == 0) throw new NoSuchElementException(); // exception

        T removed = dyn_array[size-1]; // speichere das letzte Element in einer Variable
        dyn_array[size-1] = null; // und setze diese Stelle null

        if (size-1 <= dyn_array.length / 4) { // wenn size nur noch 1/4 der Kapazität ist,...
            changeCapacity(dyn_array.length / 2); // ...dann halbiere die Kapazität des Arrays
        }
        size--; // reduziere die Anzahl der Elemente im Array um eins
        return removed; // gib das entfernte Element zurück
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