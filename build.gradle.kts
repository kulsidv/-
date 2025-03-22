plugins {
    id("java")
    id("application")
    id("war")
}

group = "ru.kpfu.itis.kulsidv"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

application {
    mainClass = "ru.kpfu.itis.kulsidv.Main"
}

dependencies {
    implementation("org.springframework:spring-webmvc:6.2.3")
    implementation("jakarta.servlet:jakarta.servlet-api:6.1.0")
    implementation("org.json:json:20231013")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}