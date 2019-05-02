# Wow_Cool

## UML Class Diagram

![uml](https://github.com/KameriiJ/Wow_Cool/blob/master/uml.jpg)

## GRASP Principles

- **Controller**
    We can see this happening everywhere in *'Wow cool!!'* project because we want to provide a layer between the user interface and the Domain Model. So, we use it to control the user interface layer and basically manage objects bonded to which user interface.

- **Creator**
    We use Creator principles to create many windows following our UML class diagram. For example, Main class creates Home window then HomeController class creates TimesTableChoosing window and so on.

- **High Cohesion**
    We seperate responsibilities into a single responsibility. A class is fulfilling a single responsibility. Moreover, we set the name of class depends on responsibility of it.

- **Polymorphism**
    We use Polymorphism where derived classes can be referenced through parent classes to generalized the start method in the interface and delegated the Main specific implementation to its classes.

- **Pure Fabrication**
    Our user interfaces have their own controllers for control and calculation.

