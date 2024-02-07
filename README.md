# Tutorial 1  
  
Faris Zhafir Faza
2206081931
Pemrograman Lanjut A

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
