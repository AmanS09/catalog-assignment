Steps to Run File on VS Code

## 1)Download the org.json Library:
    Go to Maven Central Repository.
    Download the latest version of the JAR file (e.g., json-20210307.jar).

## 2)Add the JAR to Your Project:
     Move the downloaded JAR file to the same directory as your Java source file4

## 3)Set Up VS Code for Java: Make sure you have the Java Extension Pack installed in VS Code, which includes tools for Java development, such as Maven, Gradle, and the Language Support for Java.

## 4)Compile and Run with the JAR in the Classpath: Open the integrated terminal in VS Code and run the following commands:

## 5)Navigate to your project directory:

    cd "C:\Users\HP\Desktop\cc"
    Compile your Java file while including the JAR in the classpath:

    javac -cp .;json-20210307.jar SecretSharing.java
    Run your Java program, also specifying the classpath:

    java -cp .;json-20210307.jar SecretSharing
