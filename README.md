# Wow_Cool

## 1. UML Class Diagram

![uml](https://github.com/KameriiJ/Wow_Cool/blob/master/uml.jpg)

## 2. GRASP Principles

- **Controller**: We can see this happening everywhere in *'Wow cool!!'* project because we want to provide a layer between the user interface and the Domain Model. So, we use it to control the user interface layer and basically manage objects bonded to which user interface.

- **Creator**: We use Creator principles to create many windows following our UML class diagram. For example, Main class creates Home window then HomeController class creates TimesTableChoosing window and so on.

- **High Cohesion**: We seperate responsibilities into a single responsibility. A class is fulfilling a single responsibility. Moreover, we set the name of class depends on responsibility of it.

- **Polymorphism**: We use Polymorphism where derived classes can be referenced through parent classes to generalized the start method in the interface and delegated the Main specific implementation to its classes.

- **Pure Fabrication**: Our user interfaces have their own controllers for control and calculation.

- **Information Expert**: We achieve this principle as we see in ScoreManager. ScoreManager class records scores seperate in each row by multiplicand of numbers from 2, 3,..., and 12 respectively in score.txt file and reads score from score.txt file too.

- **Indirection**: we supports low coupling and reuse potential between two elements by assigning the responsibility of mediation between them to an intermediate object. We have many classes to acheive this principle. For example, Controller classes has controller component for mediation between data (model) and its representation (view) in the model-view control pattern. This ensures that coupling between them remains low.

- **Low Coupling**: We reduce the measure of how strongly one element is connected to as we see in StageBuilder class. We use composition method to achieve this principle by lower dependency between the class.

- **Protected variations**: We protected variations in many Controller classes. We use EventHandler and overwrite itself to protected elements from the variations on other elements.  

## Contributors

- 6010545021 [Kornphon Noiprasert](https://github.com/Driveiei)
- 6010545692 [Kunyaruk Katebunlu](https://github.com/NokKbl)
- 6010546915 [Gunthee Tawewatmongkol](https://github.com/KameriiJ)