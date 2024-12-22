plugins {
    application
    checkstyle
    jacoco
    id("io.freefair.lombok") version "8.6"
}
application { mainClass.set("hexlet.code.App") }

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.3"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("info.picocli:picocli:4.7.6")
    implementation("com.fasterxml.jackson.core:jackson-databind:1.9.9")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:1.9.9")
}

tasks.test {
    useJUnitPlatform()

}
tasks.jacocoTestReport { reports { xml.required.set(true) } }