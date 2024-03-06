# Tutorial 1  
  
Faris Zhafir Faza
2206081931
Pemrograman Lanjut A

## Module 1

**Reflection 1**  
You already implemented two new features using Spring Boot. Check again your source code and evaluate the coding standards that you have learned in this module. Write clean code principles and secure coding practices that have been applied to your code.  If you find any mistake in your source code, please explain how to improve your code.
I've done some code principle for example : 
- Descriptive name for variables and function
- Short code for function and only does one job
- No comment needed

For secure code, I've done :
- Using POST request for create a product

**Reflection 2**  
1. After writing the unit test, how do you feel? How many unit tests should be made in a class? How to make sure that our unit tests are enough to verify our program? It would be good if you learned about code coverage. Code coverage is a metric that can help you understand how much of your source is tested. If you have 100% code coverage, does that mean your code has no bugs or errors?
My feeling after writing a unit test is that I become more enlightened about what needs to be considered to test an application. There is no definite number regarding how many unit tests should be made, but the unit tests that are made must cover over 80% of the code. In addition, the unit tests created must test corner cases, positive cases, and also negative cases. 100% code coverage does not necessarily mean that the code is free from bugs, but in my opinion, it is sufficient for a unit test.

2. Suppose that after writing the CreateProductFunctionalTest.java along with the corresponding test case, you were asked to create another functional test suite that verifies the number of items in the product list. You decided to create a new Java class similar to the prior functional test suites with the same setup procedures and instance variables.  
What do you think about the cleanliness of the code of the new functional test suite? Will the new code reduce the code quality? Identify the potential clean code issues, explain the reasons, and suggest possible improvements to make the code cleaner!
In my opinion, the code will become less clean due to code duplication. With code duplication, the code will be more difficult to maintain. In my opinion, the solution to this problem is to just combine the two files to reduce code duplication.

## Module 2

**Reflection 1** 
1. List the code quality issue(s) that you fixed during the exercise and explain your strategy on fixing them. 
- Unused Import: During the exercise, I noticed that there were some import statements in the code that were not being used. Unused imports can lead to confusion and make the code harder to read, as it’s not clear why they are there. To fix this issue, I went through the code to identify which imports were not being used. I then removed these unused import statements from the code.
- Unnecessary ‘public’ Modifier: I also found that some methods in the code were declared as ‘public’ unnecessarily. In Java, the ‘public’ modifier means that the method can be accessed from anywhere, which might not always be desirable or necessary. To fix this, I reviewed the code to determine which methods did not need to be ‘public’. I then changed these methods to ‘private’ or ‘protected’, as appropriate, to limit their scope and accessibility.

2. Look at your CI/CD workflows (GitHub)/pipelines (GitLab). Do you think the current implementation has met the definition of Continuous Integration and Continuous Deployment? Explain the reasons (minimum 3 sentences)!
In my current setup, I’ve implemented Continuous Integration (CI) effectively. Every time I push or make a pull request, my CI workflow is triggered. It’s like giving my code a quick check-up every time it’s updated. It ensures everything still works together and it’s running tests to catch any bugs.
I use Koyeb for the Continuous Deployment (CD), Koyeb has also put into action some CI/CD to automate the deployment process each time there’s a pull, push, or merge from the repository.

## Module 3

**Reflection1**
1. Explain what principles you apply to your project!
- Single Responsibility Principle (SRP) : 
    - Move CarController from ProductController.java to a new file called CarController.java
    - Remove extends ProductController in CarController class 
- Open-Closed Principle (OCP) : 
    - Changed private CarServiceImpl carService; to private CarService carService;
- Liskov Substitution Principle (LSP) : 
    - Remove extends ProductController in CarController class 
- Interface Segregation Principle (ISP):
    - In this project, I have already implemented CarService and ProductService, each of which has already implemented an interface.
- Dependency Inversion Principle (DIP):
    - In this project, CarServiceImpl and ProductServiceImpl each depend on their own interfaces, namely CarService and ProductService.

2. Explain the advantages of applying SOLID principles to your project with examples.
- Single Responsibility Principle (SRP):
    - Advantage: Simplifies maintenance and testing by ensuring a class has only one reason to change.
    - Example: By moving CarController from ProductController.java to a new file called CarController.java, i’ve separated the responsibilities. This means changes to car-related features won’t affect product-related code.
- Open-Closed Principle (OCP):
    - Advantage: Enhances a system’s reusability by allowing classes to be extended without modifying them.
    - Example: Changing private CarServiceImpl carService; to private CarService carService; allows for different implementations of CarService to be used without altering the class that uses it.
- Liskov Substitution Principle (LSP):
    - Advantage: Ensures that subclasses can stand in for their parent classes without causing errors.
    - Example: Removing extends ProductController in CarController class ensures that CarController can be used wherever a controller is expected without inheriting potentially irrelevant or conflicting behavior from ProductController.
- Interface Segregation Principle (ISP):
    - Advantage: Prevents classes from being forced to implement interfaces they don’t use, reducing the impact of changes.
    - Example: Implementing CarService and ProductService separately ensures that changes to one service interface don’t affect classes that only use the other service.
- Dependency Inversion Principle (DIP):
    - Advantage: Reduces the dependency on concrete classes and enhances the flexibility to change dependencies.
    - Example: Having CarServiceImpl and ProductServiceImpl depend on their own interfaces (CarService and ProductService) rather than concrete classes allows for easier substitution and testing.

3. Explain the disadvantages of not applying SOLID principles to your project with examples.
- Single Responsibility Principle (SRP):
    - Disadvantage: A class with multiple responsibilities becomes harder to modify, understand, and test.
    - Example: If CarController also handles product-related logic, any change to product features could accidentally affect car-related functionality, leading to a fragile codebase.
- Open-Closed Principle (OCP):
    - Disadvantage: Without OCP, adding new functionality often requires modifying existing code, which can introduce bugs.
    - Example: If CarServiceImpl is not designed to be extended, adding a new type of car service would require altering the existing class, potentially breaking existing functionality.
- Liskov Substitution Principle (LSP):
    - Disadvantage: Violating LSP can lead to unexpected behavior when subclasses are used in place of their parent class.
    - Example: If CarController extends ProductController and changes some fundamental behavior, it may not be usable as a ProductController, leading to runtime errors.
- Interface Segregation Principle (ISP):
    - Disadvantage: Classes that implement large interfaces are forced to implement methods they don’t use, making the code more complex and less maintainable.
    - Example: If CarService includes methods specific to products, the CarServiceImpl must implement these irrelevant methods, leading to confusing code.
- Dependency Inversion Principle (DIP):
    - Disadvantage: Relying on concrete classes rather than abstractions can make the code less flexible and more difficult to refactor.
    - Example: If CarServiceImpl directly depends on a concrete ProductRepository class, switching to a different storage solution would require significant changes to the CarServiceImpl.

## Module 4

**Reflection1**

1. Reflect based on Percival (2017) proposed self-reflective questions (in “Principles and Best Practice of Testing” submodule, chapter “Evaluating Your Testing Objectives”), whether this TDD flow is useful enough for you or not. If not, explain things that you need to do next time you make more tests.
- The tests should be written in a way that they are easy to understand and maintain. They should be clear about what they are testing and what the expected outcomes are.
- The tests should cover not only the typical use cases but also edge cases that might cause the system to behave unexpectedly.
- The tests should cover all parts of the code to ensure that any changes or additions to the code do not break existing functionality.
- Each test should be able to run independently of the others. This makes it easier to pinpoint the cause when a test fails.
- The tests should produce the same results each time they are run, regardless of the environment in which they are executed.

2. You have created unit tests in Tutorial. Now reflect whether your tests have successfully followed F.I.R.S.T. principle or not. If not, explain things that you need to do the next time you create more tests.
- I’ve adhered to the F.I.R.S.T principles in my testing approach, ensuring that my tests are executed promptly to maintain a smooth development process. I’ve categorized my tests into two types: unit tests and functional tests. In my unit tests, I’ve made sure to avoid dependencies on other subsystems or functions. My tests are designed to be non-interfering and state-independent, meaning they don’t alter function states or rely on other test cases. To prevent redundancy and ensure proper cleanup of objects, I’ve utilized dummies, mocks, setUp, and tearDown techniques. My tests yield consistent results across multiple runs. In situations where my function calls other functions, I’ve employed Test Double techniques. My tests are self-verifying due to the use of strict assertions. Lastly, my tests are comprehensive and timely, as they examine all possible outcomes, errors, and results, including both successful and unsuccessful scenarios.