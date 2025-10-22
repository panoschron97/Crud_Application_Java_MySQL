# A Crud application in java with MySQL

A CRUD (Create, Read, Update, Delete) application implemented using Java and MySQL.

## Key Features & Benefits

*   **CRUD Operations:** Provides full CRUD functionality for managing data.
*   **Java Implementation:** Built with Java for cross-platform compatibility and maintainability.
*   **MySQL Database:** Utilizes MySQL as the relational database for persistent data storage.
*   **Object-Oriented Design:** Leverages object-oriented principles for modularity and code reusability.
*   **Company, Department and Employee Entities:** Structures data around these common business entities.

## Prerequisites & Dependencies

Before you begin, ensure you have the following installed:

*   **Java Development Kit (JDK):**  Version 8 or higher.  Download from [Oracle](https://www.oracle.com/java/technologies/javase-downloads.html) or [OpenJDK](https://openjdk.java.net/).
*   **MySQL Database:**  Install MySQL Server. Download from [MySQL](https://www.mysql.com/downloads/).
*   **MySQL Connector/J:** JDBC driver for connecting Java applications to MySQL. Download from [MySQL](https://dev.mysql.com/downloads/connector/j/).  Add the .jar file to your project's classpath.
*   **IDE (Optional):**  An Integrated Development Environment (IDE) such as IntelliJ IDEA, Eclipse, or NetBeans can be helpful for development.

## Installation & Setup Instructions

1.  **Clone the Repository:**

    ```bash
    git clone https://github.com/panoschron97/Crud_Application_Java_MySQL.git
    cd Crud_Application_Java_MySQL/Java/Crud_Application_MySQL
    ```

2.  **Create the Database:**

    *   Log in to your MySQL server using the MySQL command-line tool or a GUI client (e.g., MySQL Workbench).

        ```bash
        mysql -u root -p
        ```

    *   Create a new database (e.g., `crud_db`):

        ```sql
        CREATE DATABASE crud_db;
        USE crud_db;
        ```

    *   Import the database schema from the `Application.sql` file (if provided):

        ```bash
        mysql -u root -p crud_db < Application.sql
        ```

3.  **Configure the Application:**

    *   Open the `Application.java` file (or relevant configuration file) and update the database connection details (URL, username, password) to match your MySQL setup.  For example:

        ```java
        String url = "jdbc:mysql://localhost:3306/crud_db";
        String user = "root";
        String password = "your_password";
        ```

    *   Replace `"your_password"` with the actual password for your MySQL user.

4.  **Compile the Java Code:**

    *   Using your IDE or the command line, compile the Java files:

        ```bash
        javac *.java
        ```

5.  **Run the Application:**

    *   Execute the compiled Java code:

        ```bash
        java Application
        ```

## Usage Examples

The application provides a command-line interface (or potentially a GUI, depending on the implementation) for performing CRUD operations on Companies, Departments, and Employees. Follow the on-screen instructions after running `java Application` to interact with the data.

Examples (hypothetical, based on likely functionality):

*   **Create a new Company:** The application might prompt you for the company name, address, etc.
*   **Read Employee Data:**  You could search for an employee by ID or name.
*   **Update Department Information:**  Modify a department's name or location.
*   **Delete an Employee:** Remove an employee record from the database.

## Configuration Options

The primary configuration options are related to the database connection.  These are typically found in the `Application.java` file or a separate configuration file:

*   **Database URL:**  `jdbc:mysql://hostname:port/database_name`
*   **Database Username:**  The MySQL username for accessing the database.
*   **Database Password:**  The password for the MySQL user.

## Contributing Guidelines

We welcome contributions!  To contribute:

1.  Fork the repository.
2.  Create a new branch for your feature or bug fix.
3.  Make your changes and commit them with clear, descriptive messages.
4.  Submit a pull request.

Please ensure your code adheres to the project's coding style and includes appropriate tests.

## License Information

This project does not currently have a license specified. All rights are reserved by the owner. Please contact the owner for licensing information.

## Acknowledgments

*   This project utilizes the MySQL Connector/J library for database connectivity.
