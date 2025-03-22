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

#### Singleton 就是确保一个类全局只有一个对象实例，并且大家都通过 getInstance() 方法访问它。

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
