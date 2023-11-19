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


// https://mvnrepository.com/artifact/com.google.code.gson/gson
    implementation("com.google.code.gson:gson:2.10.1")



}

tasks.test {
    useTestNG()
}