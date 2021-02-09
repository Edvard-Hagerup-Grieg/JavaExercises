package Exercises6_2;

import java.util.ArrayList;

public class ObservableStringBuilder implements Observable{
    private StringBuilder stringBuilder;
    private ArrayList<Observer> observers = new ArrayList<>();

    public ObservableStringBuilder(String string) {
        stringBuilder = new StringBuilder(string);
    }

    public int getObservers() {
        return observers.size();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        if(!observers.isEmpty()) {
            for(Observer observer : observers) {
                observer.update();
            }
        }
    }

    public ObservableStringBuilder append(String string) {
        stringBuilder.append(string);
        notifyObservers();
        return this;
    }

    public ObservableStringBuilder insert(int start, String string) {
        stringBuilder.insert(start, string);
        notifyObservers();
        return this;
    }

    public ObservableStringBuilder replace(int start, int end, String string) {
        stringBuilder.replace(start, end, string);
        notifyObservers();
        return this;
    }

    public ObservableStringBuilder delete(int start, int end) {
        stringBuilder.delete(start, end);
        notifyObservers();
        return this;
    }

    public ObservableStringBuilder reverse() {
        stringBuilder.reverse();
        notifyObservers();
        return this;
    }

    @Override
    public String toString() {
        return stringBuilder.toString();
    }
}
