package Exercises7_3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<T> implements Iterator<T> {
    private ArrayList<T> array;
    private int position;

    public ArrayIterator(ArrayList<T> array) {
        this.array = array;
        position = 0;
    }

    @Override
    public T next() {
        if(!hasNext())
            // Запомнить!
            throw new NoSuchElementException();
        return array.get(position++);
    }

    @Override
    public boolean hasNext() {
        return position != array.size();
    }
}
