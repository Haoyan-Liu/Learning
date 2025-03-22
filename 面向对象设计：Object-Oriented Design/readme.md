# Core Concepts (核心概念)

### Object (对象)
- An entity in the program that has **state (attributes)** and **behavior (methods)**.
- Example: A "cat" can be an object with color and breed (state), and it can meow or catch mice (behavior).

### Class (类)
| Relationship (关系) | UML Symbol (符号) | Meaning (含义) |
|--------------------|-----------------|------------------------------------------------------------|
| Association (关联) | —               | One class references another （引用关系）                    |
| Aggregation (聚合) | ◇————           | "Has-a" relationship; whole-part, part can exist alone （弱拥有关系） |
| Composition (组合) | ◆————           | "Has-a" strong relationship; part can't exist alone （强拥有关系）  |
| Inheritance (继承) | ⬆︎              | "Is-a" relationship; child inherits from parent （父子关系）         |
| Realization (实现) | ╌⬆︎             | Class implements an interface （接口实现）                      |

#### Interface vs Abstract Class

| 特性 / Feature           | Interface（接口）                                                                 | Abstract Class（抽象类）                                                    |
|-------------------------|---------------------------------------------------------------------------------|---------------------------------------------------------------------------|
| 是否可以实例化          | 不能实例化                                                                       | 不能实例化                                                                 |
| 是否可以包含实现方法    | Java 8 之前不可以，Java 8+ 可有 `default` 方法实现；<br>Java 9+ 可有 `private` 方法。 | 可以有抽象方法和普通方法（可以带方法体）。                                    |
| 是否有构造函数          | 没有构造函数                                                                     | 可以有构造函数（供子类调用）。                                               |
| 变量                    | 只能定义 `public static final` 常量                                              | 可以有成员变量（实例变量、静态变量、常量等）。                                 |
| 多继承支持              | 支持（一个类可以实现多个接口）。                                                   | 不支持多继承（只能继承一个抽象类）。                                          |
| 继承/实现方式           | 使用 `implements`；一个类可以 `implements` 多个接口。                              | 使用 `extends`；一个子类只能继承一个抽象类。                                    |
| 方法访问修饰符          | 方法默认为 `public`，只能是 `public`。                                             | 方法可以是 `public`、`protected` 或包访问权限（不能是 `private` 抽象方法）。     |
| 适用场景 / 适用用途      | 定义规范、能力或行为（例如“会飞”、“可比较”）；纯规范，没有状态和代码实现。            | 抽象出一类事物的公共部分，可以包含部分实现和状态；用于代码复用和规范结合。        |

### Java 访问修饰符与可访问性关系表

| 访问修饰符     | 本类 (class itself) | 同包 (package) | 子类 (subclass)                     | 全世界 (whole world) |
|---------------|---------------------|-----------------|-------------------------------------|----------------------|
| **public**    | 可访问              | 可访问          | 可访问                              | 可访问               |
| **protected** | 可访问              | 可访问          | 可访问（包括跨包继承访问）          | 不可访问             |
| **default**   | 可访问              | 可访问          | 不可访问                            | 不可访问             |
| **private**   | 可访问              | 不可访问        | 不可访问                            | 不可访问             |


### Encapsulation (封装)
- Hiding internal implementation details and exposing only necessary interfaces.
- Prevents external code from modifying internal object states arbitrarily, ensuring data safety.

### Inheritance (继承)：Base Class（父类）Derived Class（子类）
- Child classes can inherit attributes and methods from parent classes.
- Promotes code reuse.
- Example: A "kitten" class inherits from a "cat" class and gains all basic properties and behaviors, with the ability to add its own features.

### Polymorphism (多态)：
| 特点 / Feature | 描述 / Description |
|----------------|---------------------------------|
| **概念 / Concept** | 同一个接口或方法，不同对象有不同的表现。<br>The same interface or method behaves differently based on the object. |
| **条件 / Conditions** | 需要满足继承、方法重写 (Override)、以及父类引用指向子类对象。<br>Requires inheritance, method overriding, and parent reference pointing to child object. |
| **体现 / How it works** | 方法调用根据实际对象类型决定运行时表现。<br>Method calls are determined by the actual type of the object at runtime. |
| **优势 / Advantages** | 提高程序扩展性和灵活性，降低耦合度。<br>Improves scalability, flexibility, and reduces coupling between components. |

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

# OOD Interview Types (面向对象设计面试题类型)

## 1. System Design Type (系统型)
设计一个完整系统，涉及多个对象和复杂交互。

### Examples:
- Design an Elevator System （设计电梯系统）
- Design a Parking Lot （设计停车场）
- Design a Ride-Sharing Service like Uber （设计一个打车系统）
- Design a Library Management System （设计图书馆管理系统）
- Design an ATM （设计自动取款机系统）

---

## 2. Game Design Type (小游戏设计型)
简化版游戏，考察对象设计和行为交互。

### Examples:
- Design a Tic-Tac-Toe game （设计井字棋）
- Design a Chess game （设计国际象棋）
- Design a Snake game （设计贪吃蛇）
- Design a Card Deck and card dealing system （设计一副牌的洗牌和发牌系统）

---

## 3. Workflow / Service Design (工作流 / 服务型)
涉及任务流、请求队列、状态切换。

### Examples:
- Design a Coffee Vending Machine （设计咖啡售卖机）
- Design a Notification System （设计通知推送系统）
- Design a Job Scheduler （设计任务调度器）
- Design a Printer Spooler （设计打印任务队列系统）

---

## 4. Data Structure-Focused OOD (数据结构设计型)
设计带对象封装的复杂数据结构。

### Examples:
- Design a LRU Cache (Least Recently Used Cache) （设计 LRU 缓存）
- Design a File System （设计文件系统）
- Design a HashMap （设计哈希表）
- Design a Trie (Prefix Tree) （设计前缀树）

---

## 5. E-Commerce / Business Flow Type (电商 / 业务流设计)
模拟业务场景，涉及实体关系和交易。

### Examples:
- Design an Online Shopping Cart （设计一个购物车系统）
- Design an Order Management System （设计订单管理系统）
- Design a Payment Gateway （设计支付网关）
- Design a Hotel Booking System （设计酒店预订系统）

