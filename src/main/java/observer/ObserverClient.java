package observer;
import java.util.ArrayList;
// "Subject"
abstract class Subject {//Observable
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	
	public void attach(Observer observer){
		observers.add(observer);
	}
	public void detach(Observer observer) {
		observers.remove(observer);
	}
	public void notifyObservers() {
		for (Observer o : observers)    
			o.update();
	}
}
class ConcreteSubject extends Subject {//Observable
	private String subjectState;
	public String getSubjectState() {
		return subjectState; 
	}
	public void setSubjectState (String value) { 
		subjectState = value; 
	}
}

interface  Observer {
	public void update();
}
class ConcreteObserver implements Observer{//Observer
	private String name;
	private String observerState;
	private ConcreteSubject subject;
	public ConcreteObserver (ConcreteSubject subject, String name)  {
		this.subject = subject;
		this.name = name;
	}
	public void update(){
		observerState = subject.getSubjectState();
		System.out.printf("Observer %s's new state is: %s\n", name, observerState );
	}
}
public class ObserverClient {
	public static void main(String[] args) {
		// Configure Observer structure
		ConcreteSubject s = new ConcreteSubject();
		ConcreteObserver Tzili = new ConcreteObserver(s, "Tzili");
		ConcreteObserver Gili = new ConcreteObserver(s, "Gili");
		ConcreteObserver Nili = new ConcreteObserver(s, "Nili");
		s.attach(Tzili);
		s.attach(Gili);
		s.attach(Nili);
		// Change subject and notify observers
		s.setSubjectState("Homework 1 is ready!");
		s.notifyObservers();
		System.out.println();
		s.setSubjectState("Homework 2 is ready!");
		s.notifyObservers();
		////
		s.detach(Gili);
		System.out.println();
		s.setSubjectState("Homework 3 is ready!");
		s.notifyObservers();
	}
}
