#### Table of Contents
- [Project Overview](#project-overview)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Maven Dependencies](#maven-dependencies)
- [Project Structure and Key Directories](project-structure-and-key-directories)
- [Setup and Installation](#setup-and-installation)
  - [Clone and Deploy the Web Application](#clone-and-deploy-the-web-application)
  - [MySQL Database Installation and Configuration](#mysql-database-installation-and-configuration)
      - [Installation of MySQL Server Locally](#installation-of-mysql-server-locally)
      - [Installation of MySQL Workbench Locally](#installation-of-mysql-workbench-locally)
- [Running the Application](#running-the-application)
- [Contributions](#contributions)
- [License](#license)

# SAS Spring Security Web Application
---
### Project Overview
The SAS Spring Security Web Application is a Java-based account management and authentication web application.<br>
It employs Spring Framework technologies, including Spring MVC and Spring Security, and is deployed as a JAR file suitable for any Java EE web container.

---
### Features
* **User Authentication**: Log in and session management using Spring Security.
* **Account Management**: Add and manage user accounts.
* **Database Support**: Store user information in the MySQL database.
* **Password encryption**: Password hash encoded before persistence.
* **Error Handling**: Custom error responses for various scenarios.

---
### Prerequisites
* Eclipse IDE for Enterprise Java and Web Developers 2024-03 (4.31.0)
* Java 17 or newer
* Maven 3.6 or newer
* Servlet container (e.g., Tomcat 10 or newer)

---
### Maven Dependencies
- **Implementation dependencies**:
    - [spring-webmvc](https://mvnrepository.com/artifact/org.springframework/spring-webmvc)
    - [javax.servlet.jsp-api](https://mvnrepository.com/artifact/javax.servlet.jsp/javax.servlet.jsp-api)
    - [jakarta.servlet.jsp-api](https://mvnrepository.com/artifact/jakarta.servlet.jsp/jakarta.servlet.jsp-api)
    - [javax.servlet-api](https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api)
    - [jakarta.servlet-api](https://mvnrepository.com/artifact/jakarta.servlet/jakarta.servlet-api)
    - [spring-security-core](https://mvnrepository.com/artifact/org.springframework.security/spring-security-core)
    - [spring-security-web](https://mvnrepository.com/artifact/org.springframework.security/spring-security-web)
    - [spring-security-config](https://mvnrepository.com/artifact/org.springframework.security/spring-security-config)
    - [spring-orm](https://mvnrepository.com/artifact/org.springframework/spring-orm)
    - [mysql-connector-j](https://mvnrepository.com/artifact/com.mysql/mysql-connector-j)
    - [slf4j-api](https://mvnrepository.com/artifact/org.slf4j/slf4j-api)
- **Test dependencies**:
     - [junit-jupiter-api](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api)
     - [junit](https://mvnrepository.com/artifact/junit/junit)
     - [mockito-core](https://mvnrepository.com/artifact/org.mockito/mockito-core)

---
### Project Structure and Key Directories
```md
src
├── main
│   ├── java                         => Contains Java source files, including controllers, services, and configuration.
│   │   └── me
│   │       └── scriptori
│   │           └── saswebapp        => The Root Package of the Java Sprint and Spring Security Java Code.
│   │               ├── config       => Package for the Configuration files for Spring.
│   │               ├── controller   => Package for the Controllers of the Web application.
│   │               ├── dto          => Package for the Data Transfer Objects (DTO).
│   │               ├── handler      => Package for Spring MVC handles,
│   │               └── initializer  => Package with web application and servlet initializers.
│   └── webapp 
│       └── WEB-INF                  => Contains JSP views, web.xml, and other web resources like CSS and assets.
│           ├── resources
│           │   └── css              => Directory with CSS files for styling.
│           ├── views                => Directory with the JSP files for the user interface.
│           └── web.xml              => Configuration file used in Java web applications to define deployment settings and servlet mappings.
└── test
    └── java
        └── me
            └── scriptori
                └── saswebapp
                    ├── config       => Package for the Configurations test cases.
                    ├── controller   => Package for the Controller's test cases.
                    ├── handler      => Package for the Handler's test cases.
                    └── initializer  => Package for the Initializer's test cases.


```
---
### Setup and Installation
Below are the steps for the setup and the installation.<p>

#### Clone and Deploy the Web Application
<ol>
  <li><b>Clone the repository:</b>
    <pre lang="bash"><code>> git clone https://github.com/scriptori/sas-spring-security.git<br>
> cd sas-spring-security</code></pre>
  </li>
  <li><b>Build the project:</b>
    <pre lang="bash"><code>> mvn clean install</code></pre>
  </li>
  <li><b>Deploy the JAR file to your Servlet container:</b></p>
  Place the generated JAR file from <samp>target/</samp> directory into your servlet container's <samp>webapps/</samp> directory.
  </li>
</ol>

#### MySQL Database Installation and Configuration</b>
##### Installation of MySQL Server Locally:
Download and install MySQL Community Server from the [official website](https://dev.mysql.com/downloads/mysql/) directly on your local machine, following the installation instructions for your operating system. It is suitable for development purposes or if you only need a database server for personal projects. For Mac using ARM 64-bit, by the time I am writing this instruction (05/13/2024), I recommend using version 8.0.37.
* **Configure MySQL**: After the installation, configure MySQL by running the MySQL Server instance.
You may need to start the MySQL Server manually. Using the Terminal application and running commands like,<br> <pre lang="bash"><code>> sudo /usr/local/mysql/support-files/mysql.server start</code>
* **Verify Installation**: 
It's crucial to verify that MySQL Server is installed and running correctly. To do this, open a command prompt (on Windows) and type the following command:
    <pre lang="bash"><code>> mysql -u root -p</code></pre>
    When prompted, Enter the root password you set during installation.
    If MySQL Server runs correctly, you'll log in to the command-line client.
* **Reinstall MySQL (if necessary)**: If MySQL was not installed correctly or if you continue to encounter issues, consider reinstalling MySQL following the installation instructions provided by MySQL.

That's it! You've successfully installed MySQL Server locally on your machine. You can now use MySQL to create databases, tables, and other operations.

#### Installation of MySQL Workbench Locally:
Download and install MySQL Workbench directly on your local machine. For Mac using ARM 64-bit, by the time I am writing this instruction (05/13/2024), I recommend using version 8.0.33, available on the [archived version page](https://downloads.mysql.com/archives/workbench/).
* **Creation of the Screma (database) *<samp>sas-security</samp>***:
A database schema organizes and defines the relationships between tables, views, stored procedures, and other elements within a specific database.<br>
To create the two tables (***<samp>users</samp>*** and ***<samp>authority</samp>***) required by the default configuration, a schema called ***<samp>sas-security</samp>*** must be created.
* **Creation of the Tables (*<samp>users</samp>* and *<samp>authority</samp>*):**
The default Spring Security configuration used in this project requires the creation of two tables:
   * **The *<samp>users</samp>* table:** <br>
    Steps to create a table called ***<samp>users</samp>*** with the ***<samp>username</samp>***, ***<samp>password</samp>***, and ***<samp>enabled</samp>*** columns:
        <ol>
            <li><b>Open MySQL Workbench</b>: Start MySQL Workbench and connect to your database.</li>
            <li><b>Select Database</b>: Choose the <i><b><samp>sas-security</samp></b></i> schema from the Schemas section on the left side where you want to create your table.</li>
            <li><b>Open SQL Editor</b>: Click the "File" menu and select "New Query Tab" to open a new SQL editor.</li>
            <li><b>Write the SQL Query</b>: In the SQL editor, type the following SQL statement to create the <i><b><samp>users</samp></b></i> table:
            <pre lang="SQL"><code>CREATE TABLE users (
        username VARCHAR(45) NOT NULL,
        password VARCHAR(256) NOT NULL,
        enabled VARCHAR(5),
        PRIMARY KEY (username)
     );</code></pre></li>
            Notice the <i><b><samp>password</samp></b></i> column must be sized enough to store an encoded password. In this case, 256 characters are being used.</li>
            <li><b>Execute the Query</b>: Click the lightning bolt icon ("Execute the selected portion of the script" or "Execute the entire script") to run your SQL command.</li>
            <li><b>Verify the Table Creation</b>: You can verify that the table was created by expanding your schema in the Schemas section and checking under the "Tables" directory to see if the <i><b><samp>users</samp></b></i> table appears.</li>
        </ol>
          
        These steps above will create a table named ***<samp>users</samp>*** with three columns: ***code>username</samp>***, ***<samp>password</samp>***, and ***<samp>enabled</samp>***. The ***<samp>username</samp>*** column is also set as the primary key to ensure that each ***<samp>username</samp>*** is unique in the table.
   * **The *<samp>authority</samp>* table:** <br>
    Steps to create a table called ***<samp>authority</samp>*** with the ***<samp>username</samp>*** and ***<samp>authority</samp>*** columns:
        <ol>
            <li>Repeat steps *a* to *c* above.</li>
            <li>Repeat step *d*, using the following SQL statement to create the <i><b><samp>authority</samp></b></i> table:<br>SQL statement to create the <i><b><samp>authority</samp></b></i> table:
            <pre lang="SQL"><code>CREATE TABLE authority (
        username VARCHAR(45) NOT NULL,
        authority VARCHAR(45) NOT NULL,
        PRIMARY KEY (username)
     );</code></pre></li>
            <li>Repeat steps *e* and *f* above, checking under the "Tables" directory to see if the authority table appears.</li>
        </ol>
            
        These steps above will create a table named <i><b><samp>authority</samp></b></i> with two columns: <i><b><samp>username</samp></b></i> and <i><b><samp>authority</samp></b></i>. The <i><b><samp>username</samp></b></i> column is also the primary key to ensure that each <i><b><samp>username</samp></b></i> is unique in the table.
* **Configuration of the <samp>dataSource</samp> in the <samp>SASDataSourceConfig</samp> class:**
The following information is needed to set the ***<samp>dataSource</samp>*** properties in the ***<samp>SASDataSourceConfig</samp>*** class: username, password, URL, and driver class name for the MySQL database (schema) you created. Here's how to find each piece of information in MySQL Workbench:
   * **Username:** <br>
       The username is often set up when the database is created. MySQL has a superuser named ***<samp>root</samp>*** by default, but other users can be created and used. <br>
       In this project, the default superuser is used. <br>
       Use the superuser in the ***<samp>dataSource.setUsername(<username>)</samp>***. <br>
   * **Password:** <br>
       The "Users and Privileges" section manages the user's password. <br>
       If you need to set or change a user's password: <br>
       * Select the user in the "Users and Privileges" window.
       * Click the "Change Password" button.
       * Use this password in the ***<samp>dataSource.setPassword(<password>)</samp>***.
   * **URL:** <br>
   The URL for your MySQL connection typically includes the host (e.g., localhost or a specific IP address), port number (the default is 3306 for MySQL), and database name.
       * To find the database name: <br>
          *  In MySQL Workbench, look at the schemas listed in the "Schemas" section on the left sidebar.
          *  Select or create the database you want to connect to. This project is called ***<samp>sas-security</samp>***.
       * Construct the URL using the following format: ***<samp>jdbc:mysql://[host]:[port]/[database-name]</samp>***.
The local database looks like this for this project: ***<samp>jdbc:mysql://localhost:3306/sas-security</samp>***.
   * **Driver Class Name:** <br>
       * When using Connector/J (the official JDBC driver for MySQL), the driver class name for MySQL is ***<samp>com.mysql.cj.jdbc.Driver</samp>***.
       * Ensure you have the MySQL Connector/J jar file in your project dependencies to use this driver class.
* **Confirming the Connection to the Database**
Once all these properties have been set in ***<samp>SASDataSourceConfig</samp>***, the connection can be tested directly from the code or using tools like MySQL Workbench to ensure the settings are correct and the database is accessible:
   * **Testing from Code**: <br>
       When you start the project application, the ***<samp>SASDataSourceConfig<samp>*** attempts to connect to the database using the configured ***<samp>DriverManagerDataSource</samp>***. The application's initial page (***<samp>index.xml</samp>***) should be displayed with no error (typically the 404 error).
   * **MySQL Workbench**: <br>
       Use the connection details to connect to the database directly through the Workbench's home screen by setting up a new connection with the exact details.
  </li>
</ol>

---
### Running the Application
* Start your servlet container.
* Access the Web Application at [http://localhost:8080/sas-spring-security/](http://localhost:8080/sas-spring-security/).

---
### Contributions
Contributions are welcome! Please submit pull requests or open issues to discuss proposed changes or enhancements.

---
### License
Copyright 2024 Scriptori - Claudio de Souza

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the “Software”), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

