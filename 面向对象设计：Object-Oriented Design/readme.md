# Core Concepts (核心概念)

### Object (对象)
- An entity in the program that has **state (attributes)** and **behavior (methods)**.
- Example: A "cat" can be an object with color and breed (state), and it can meow or catch mice (behavior).

### Class (类)
- A blueprint or template for objects.
- Objects are instances of classes.
- A class defines what attributes and methods its objects will have.

### Encapsulation (封装)
- Hiding internal implementation details and exposing only necessary interfaces.
- Prevents external code from modifying internal object states arbitrarily, ensuring data safety.

### Inheritance (继承)
- Child classes can inherit attributes and methods from parent classes.
- Promotes code reuse.
- Example: A "kitten" class inherits from a "cat" class and gains all basic properties and behaviors, with the ability to add its own features.

### Polymorphism (多态)
- The same method call can exhibit different behaviors depending on the object's type.
- Example: `animal.speak()` could result in a cat meowing or a dog barking.

---

# OOD Interview Step-by-Step Template (面向对象设计面试答题步骤模板)

## 1. Clarify Requirements (需求澄清)
- Confirm the scope and requirements with the interviewer:
  - What is the system goal?
  - Are there any specific constraints (scale, concurrency, multi-threading)?
  - What are the core and optional features?

> Example questions:
- Single user or multi-user?
- Is there a UI component?
- Is high concurrency required?
- Should we consider fault tolerance?

---

## 2. Identify Key Objects (找出主要对象)
- Extract key **nouns** from the problem statement.
- These nouns often map to objects or classes:
  - Entity objects (e.g., Car, User, Message, Floor)
  - Control objects (e.g., ElevatorController)
  - Helper objects (e.g., Timer, Display, Logger)

---

## 3. Define Relationships (定义对象关系)
- How are these objects related? (Composition / Aggregation / Inheritance)
- Which objects hold references to others?
- Are there base classes or interfaces?

---

## 4. Define Responsibilities (定义类的职责)
- For each class, define:
  - Attributes (state)
  - Methods (behavior)

---

## 5. Draw Class Diagram (画出类图)
- Draw a simple UML diagram (hand-drawn is acceptable in interviews):
  - Class names
  - Key attributes (fields)
  - Key methods (major interfaces)
  - Inheritance and composition relationships

---

## 6. Discuss Object Interactions (描述对象交互流程)
- Walk through a typical flow:
  - Who initiates the call?
  - Which object calls which?
  - Are multi-threading or state machines needed?

---

## 7. Scalability & Extensibility (讨论可扩展性和改进)
- What if the system needs to support more users?
- How to handle concurrency?
- Can any design patterns improve the solution?
- Follow SOLID principles:
  - **Single Responsibility Principle (单一职责)**
  - **Open/Closed Principle (开闭原则)**
  - **Liskov Substitution Principle (里氏替换)**
  - **Interface Segregation Principle (接口分离)**
  - **Dependency Inversion Principle (依赖倒置)**

---

##  Memory Tip (记忆口诀)
- Clarify → Identify Objects → Define Relationships → Define Responsibilities → Draw Class Diagram → Walk Through Interactions → Scalability
