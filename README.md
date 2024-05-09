# SAS Spring Security Web Application
### Project Overview
The SAS Spring Security Web Application is a Java-based account management and authentication web application.<br>
It employs Spring Framework technologies, including Spring MVC and Spring Security, and is deployed as a JAR file suitable for any Java EE web container.

### Features
* **User Authentication**: Log in and session management using Spring Security.
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
  <li><b>Deploy the JAR file to your Servlet container:</b></p>
  Place the generated JAR file from <code>target/</code> directory into your servlet container's <code>webapps/</code> directory.
  </li>
</ol>

### Running the Application
* Start your servlet container.
* Access the Web Application at [http://localhost:8080/sas-spring-security/](http://localhost:8080/sas-spring-security/).

### Contributions
Contributions are welcome! Please submit pull requests or open issues to discuss proposed changes or enhancements.

### License
Copyright 2024 Scriptori - Claudio de Souza

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the “Software”), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

