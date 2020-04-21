package Observer;

import java.util.HashSet;
import java.util.Set;

public abstract class Subject {
    private Set<Observer> observers;

    public Subject() {
        observers = new HashSet<Observer>();
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void unregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    protected void notifyObservers()
    {
        for (Observer observer : observers)
        {
            observer.update();
        }
    }
}
