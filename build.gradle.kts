
plugins {
    id("java")
}

group = "br.com.iterasys"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
// https://mvnrepository.com/artifact/org.testng/testng
    testImplementation("org.testng:testng:7.7.1")

// https://mvnrepository.com/artifact/io.rest-assured/rest-assured
    testImplementation("io.rest-assured:rest-assured:5.3.0")


// https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java
    implementation("org.seleniumhq.selenium:selenium-java:4.10.0")


// https://mvnrepository.com/artifact/io.cucumber/cucumber-java
    implementation("io.cucumber:cucumber-java:7.14.0")

// https://mvnrepository.com/artifact/io.cucumber/cucumber-testng
    implementation("io.cucumber:cucumber-testng:7.14.0")

// https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager
    implementation("io.github.bonigarcia:webdrivermanager:5.5.3")


// https://mvnrepository.com/artifact/com.google.code.gson/gson
    implementation("com.google.code.gson:gson:2.10.1")


// https://mvnrepository.com/artifact/org.slf4j/slf4j-api
    implementation("org.slf4j:slf4j-api:2.0.9")

// https://mvnrepository.com/artifact/io.cucumber/cucumber-picocontainer
    implementation("io.cucumber:cucumber-picocontainer:7.14.0")



}



tasks.test {
    useTestNG()
}