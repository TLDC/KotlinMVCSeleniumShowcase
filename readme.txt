Kotlin MVC Selenium Showcase Project:

This is a sample project for showcasing two new technologies; Kotlin and Selenium.

Kotlin is a language based on the JVM. It is completely interoperable with Java (JDK 1.6+) and provides
a number of benefits over Java. You can read through the source code in the kotlin-mvc module to
see some examples of the differences. Comments relevant for Kotlin are marked as 'KOTLIN NOTE'. There will
be some unit tests written with some additional Kotlin benefits in the future.

Selenium is a tool for smoke testing web based applications. It automates the process of a user interacting
with a web application. The selenium-bdd module contains some tests written for the different pages set
up in the kotlin-mvc project. This shows how you can test a variety of interactions such as form elements,
file uploads and interaction with more interactive JavaScript elements.

User Guide:

- Build the kotlin-mvc module using 'mvn clean install' the Kotlin compiler is brought in through a Maven plugin
 so you do not need to do anything additional.

- I have included an embedded Tomcat 7 server for running the mvc project. To do this browse to the kotlin-mvc
module in command line and type 'tomcat7:run'.

- The default address for the project is at localhost:8080/kotlin-mvc

- Once this is running you can run the Selenium tests by running RunTest.java in selenium-bdd/src/test/java/tc/selenium
  through JUnit.