# Learning Gradle with a Hello, World project

from
https://docs.gradle.org/current/userguide/tutorial_java_projects.html

Directory structure as expected by Gradle

mkdir -p src/main/java
mkdir -p src/main/resources
mkdir -p src/test/java
mkdir -p src/test/resources

gradle build - builds your project
gradle clean - deletes the build directory
gradle assemble - compiles and jars your code, but does not run the unit tests
gradle check - compiles and tests your code
gradle uploadArchives - publish the JAR file according to build.gradle file
gradle eclipse - generate the Eclipse project file

