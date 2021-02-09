package Exercises7_4;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Iterable2DArray<T> implements Iterable<T> {
    private T[][] array;
    private int positionX;
    private int positionY;

    public Iterable2DArray(T[][] array) {
        this.array = array;
        positionX = 0;
        positionY = 0;
    }

    private void positionUpdate() {
        positionY++;
        if (positionY == array[0].length) {
            positionX++;
            positionY = 0;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            @Override
            public T next() {
                if (!hasNext())
                    throw new NoSuchElementException();
                T nextItem = array[positionX][positionY];
                positionUpdate();
                return nextItem;
            }

            @Override
            public boolean hasNext() {
                return positionX != array.length;
            }

            @Override
            public void forEachRemaining(Consumer<? super T> action) {
                Objects.requireNonNull(action); // Запомнить!
                for(int y = positionY; y < array[0].length; y++)
                    action.accept(array[y][positionX]);
                for(int x = ++positionX; x < array.length; x++)
                    for(int y = 0; y < array[0].length; y++)
                        action.accept(array[x][y]);
            }
        };
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Objects.requireNonNull(action);
        for(T[] row : array)
            for(T item : row)
                action.accept(item);
    }
}
