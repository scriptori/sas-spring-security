# SAS Spring Security Web Application
### Project Overview
The SAS Spring Security Web Application is a Java-based web application designed for account management and authentication.<br>
It employs Spring Framework technologies including Spring MVC, Spring Security, and is deployed as a JAR file suitable for any Java EE web container.

### Features
* **User Authentication**: Login and session management using Spring Security.
* **Account Management**: Add and manage user accounts.
* **Database Support**: Store user information in the MySQL database.
* **Password encryption**: Password hash encoded before persistence.
* **Error Handling**: Custom error responses for various scenarios.

### Prerequisites
* Eclipse IDE for Enterprise Java and Web Developers 2024-03 (4.31.0)
* Java 17 or newer
* Maven 3.6 or newer
* Servlet container (e.g., Tomcat 10 or newer)

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

### Project Structure and Key Directories
```md
src
├── main
│   ├── java                         => Contains Java source files including controllers, services, and configuration.
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
                    ├── controller   => Package for the Controllers test cases.
                    ├── handler      => Package for the Handlers test cases.
                    └── initializer  => Package for the Initializers test cases.

```

### Setup and Installation
Below are the steps for the setup and the installation:
   
<ol>
  <li><b>Clone the repository:</b>
    <pre><code>
    > git clone https://github.com/scriptori/sas-spring-security.git<br>
    > cd sas-spring-security
    </code></pre>
  </li>
  <li><b>Build the project:</b>
    <pre><code>
    > mvn clean install
    </code></pre>
  </li>
  <li><b>Deploy the WAR file to your Servlet container:</b></p>
  Place the generated WAR file from <code>target/</code> directory into your servlet container's webapps directory.
  </li>
</ol>

### Running the Application
* Start your servlet container.
* Access the Web Application at [http://localhost:8080/sas-spring-security/](http://localhost:8080/sas-spring-security/).

### Contributing
Contributions are welcome! Please feel free to submit pull requests or open issues to discuss proposed changes or enhancements.

### License
Specify the license under which the project is made available, e.g., MIT, GPL, etc.

