# Object - Oriented Programing course - Exercise 1

**This is our second project in the OOP course.
In this project we implemented the Observer design pattern using our previous project [UndoableStringBuilder](https://github.com/AlmogShor/OOP-Ex0-2nd.git).**

Observer
In software design and engineering, the observer pattern is a software design pattern in which an object, named the subject, maintains a list of its dependents, called observers, and notifies them automatically of any state changes, usually by calling one of their methods.
![](../../Desktop/observer-2x.png)
![](../../Desktop/observer-comic-1-en-2x.png)

##UndoableString Builder
This is our own implementation for StringBuilder class with support for the undo operation.
After implementing a number of basic methods similar to the original String Builder, we created the ability to save each execution of a method in a data structure in order to enable the ability to follow the methods. Tracking the method gives us the ability to return to the original string before the method was run on it.



**[Read more and explore another usages of Observer](https://en.wikipedia.org/wiki/Observer_pattern#:~:text=In%20software%20design%20and%20engineering,calling%20one%20of%20their%20methods.)**

## UML diagram of our project
In order to understand more about the structure of the project, 
especially the structure of Observer.



![](../../Desktop/observer.png)