# Object - Oriented Programing course - Exercise 1

This is our second project in the OOP course.
In this project we implemented the Observer design pattern using our previous project

## What is Observer?
In software design and engineering, the observer pattern is a software design pattern in which an object, named the subject, maintains a list of its dependents, called observers, and notifies them automatically of any state changes, usually by calling one of their methods.

![observer-2x](https://user-images.githubusercontent.com/92925727/209137313-35a0a667-0851-4098-917a-757e880eaaf9.png)
![observer-comic-1-en-2x](https://user-images.githubusercontent.com/92925727/209137318-45e166eb-368f-475d-b9c3-0e11df79ebfe.png)
**[Read more and explore another usages of Observer](https://en.wikipedia.org/wiki/Observer_pattern#:~:text=In%20software%20design%20and%20engineering,calling%20one%20of%20their%20methods.)**


## UndoableString Builder
This is our own implementation for StringBuilder class with support for the undo operation.
After implementing a number of basic methods similar to the original String Builder, we created the ability to save each execution of a method in a data structure in order to enable the ability to follow the methods. Tracking the method gives us the ability to return to the original string before the method was run on it.
You can learn more about this project here [UndoableStringBuilder](https://github.com/AlmogShor/OOP-Ex0-2nd.git).

## Observer patern using UndoableString Builder

- [x] **Member** Interfase represents the observer .
- [x] **ConcreteMember** 
  > The class contains a sallow copy of the UndoableStringBuilder database.
    - **Update** - updates the pointer to the shalow 
 

- [x] **Sender** Interfase represents the observerable.
- [x] **GroupAdmin**
  > The class contains the UdoableStringBuilder state array and a list of Customers who should receive updates on any changes made to the database.
    - **Register** - methods to register  observers.
    - **Unregister** - methods to unregister observers.
    - **Insert** - Inserts the string into this character sequence.
    - **Append** - Appends the specified string to this character sequence.
    - **Delete** - Removes the characters in a substring of this sequence.
    - **Undo** - Erases the last change done to the document, reverting it to an older state.




    
    


## UML diagram of our project
In order to understand more about the structure of the project, 
especially the structure of Observer.
![observer](https://user-images.githubusercontent.com/92925727/209137747-b6cb8a80-2ad2-43da-a7cd-81149c45a8e2.png)

##   Download and run the Project:

Download the whole project and export it by the above actions:
```
Click Code (Green Button) -> Click Download ZIP -> Choose Extract to Folder in Zip 
```


