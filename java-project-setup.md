
#### Install Java 
- sudo apt install default-jdk -y
- sudo apt install openjdk-17-jdk -y
- export JAVA_HOME="/usr/lib/jvm/java-21-openjdk-amd64"
- export PATH="$JAVA_HOME/bin:$PATH"
- echo $JAVA_HOME
- java -version
- sudo update-alternatives --config java


#### Install Maven
- sudo apt install maven -y
- export M2_HOME=/opt/apache-maven-3.9.9
- export PATH=${M2_HOME}/bin:${PATH}
- mvn -version
- mvn clean install

#### Spring boot
-mvn clean install
- mvn spring-boot:run
- localhost:8080
- localhost:8080/swagger-ui.html
- localhost:8080/h2-console
