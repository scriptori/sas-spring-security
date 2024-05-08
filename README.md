# SAS Spring Security Web Application
### Project Overview
The SAS Spring Security Web Application is a Java-based web application designed for account management and authentication.<br>
It employs Spring Framework technologies including Spring MVC, Spring Security, and is deployed as a WAR file suitable for any Java EE web container.

### Features
* User Authentication: Login and session management using Spring Security.
* Account Management: Add and manage user accounts.
* Error Handling: Custom error responses for various scenarios.

### Prerequisites
* Eclipse IDE for Enterprise Java and Web Developers 2024-03 (4.31.0)
* Java 17 or newer
* Maven 3.6 or newer
* Servlet container (e.g., Tomcat 10 or newer)

### Project Structure and Key Directories
```md
src/
└── main/
	├── java/                        => Contains Java source files including controllers, services, and configuration.
	│	└── me/
	│	    └── scriptori/
	│           └── saswebapp/       => The Root Package of the Java Sprint and Spring Security Java Code.
	│               ├── controller/  => Package for the Controllers of the Web application.
	│               ├── service/     => Package for the Business logic services.
	│               └── config/      => Package for the Configuration files for Spring.
	└── webapp                       => The Root directory of the Web Application.
		└── WEB-INF                  => Contains JSP views, web.xml, and other web resources like CSS and assets.
			├── resources/
			│   └── css/             => Directory with CSS files for styling.
			├── views/               => Directory with the JSP files for the user interface.
			└── web.xml              => Configuration file used in Java web applications to define deployment settings and servlet mappings.
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

