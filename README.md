
## ABSTRACT

The "Pizza Application" is a Java Swing-based graphical user interface designed to facilitate the process of ordering customized pizzas. Utilizing a well-organized layout, the interface presents various options like radio buttons and checkboxes to order pizzas. The application employs event handling and validation techniques to ensure accurate processing of user inputs, offering real-time feedback and error notifications. Exception handling mechanisms promptly address invalid inputs and guide users to correct their selections. Overall, the application demonstrates effective user interface design and programming practices, delivering a seamless and user-friendly experience for customizing and placing pizza orders.


## 1.0 INTRODUCTION

### 1.1 PROBLEM DEFINITION

A Pizza Shop needs a simple interface that takes the customer’s pizza order based on size of the pizza, the toppings to be added and quantity of pizza. After ordering the customer’s bill is displayed along with tax. The same customer has the option to place multiple orders and the bill gets updated accordingly. Once a customer has finished ordering a new customer can be added and the screen gets refreshed.

### 1.2 OBJECTIVES

Here is a list of tasks that need to be accomplished –

1. User-Friendly Interface: Create an intuitive Graphical user interface that allows users to interact with the application easily like enabling users to select pizza size using radio buttons and toppings using checkboxes, providing a seamless interaction flow.

2. Pizza Customization: Enable users to customize their pizza orders by selecting pizza sizes (small, medium, large) and a variety of toppings.

3. Real-Time Calculation: Implement a system to calculate the total cost of the order based on the selected pizza size and toppings, and display it to the user.

4. Order Validation: Validate user inputs to ensure that the number of pizzas ordered is a positive integer greater than zero.

5. Dynamic Updates: Update the interface in real-time to display the selected pizza size, toppings, toppings count, and total price.

6. Sales Tax Calculation: Calculate and display the applicable sales tax for the order.

7. Order Summary: Provide users with a detailed summary of their order, including selected pizza size, toppings, toppings count, number of pizzas, total price, and grand total.

8. Multiple Actions: Implement functionality for various user actions, such as calculating the price, placing another order, starting a new customer order, and exiting the application.

9. Error Handling: Handle exceptions and display appropriate error messages when users provide incorrect or incomplete information.

10. Code Structure: Organize the code into distinct classes and methods, promoting modularity and maintainability.

11. Testing and Debugging: Thoroughly test the application to identify and resolve any bugs, errors, or unexpected behavior.

12. Code Reusability: Design the codebase with a modular approach to facilitate potential future enhancements or feature additions.

### 1.3 METHODOLOGY

The project uses Java’s Swing and AWT library to create graphical user interface components. The components used are labels, radio buttons, checkboxes, text fields, buttons and text areas. The design includes arranging the UI components in panels, selecting appropriate colors and using layout managers to set up the structure of the main window. Event Handling mechanisms like ActionEvent and ActionListener are used to define the behavior for different button actions and handle user inputs and interactions.

### 1.4 REQUIREMENT SPECIFICATIONS

 **Hardware Requirements:**
Processor: Any modern processor should be sufficient.
Memory (RAM): At least 2 GB of RAM is recommended.
Storage: The application itself is very small, so minimal storage space is required.
Display: A monitor with a resolution of 1024x768 or higher is recommended for a comfortable viewing experience.

 **Software Requirements:**
Java Development Kit (JDK): You'll need a compatible JDK installed on your system to compile and run Java programs. Preferably JDK 17 as it’s the LTE version.

Integrated Development Environment (IDE): While you can use a simple text editor and command-line tools to compile and run the Java program, using an IDE can greatly simplify development and debugging. Popular options include Eclipse, IntelliJ IDEA, and NetBeans.

Java Swing Library: The Java Swing library is included with the standard JDK distribution, so you don't need to install anything separately.

Operating System: The provided code should work on various operating systems, including Windows, macOS, and Linux.


