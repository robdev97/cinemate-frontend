# CineMate – Frontend (Vaadin)

CineMate to aplikacja webowa do planowania wspólnego oglądania filmów i dzielenia się opiniami. Frontend został stworzony z użyciem frameworka Vaadin i łączy się z osobnym backendem REST.

👉 Repozytorium aplikacji backendowej (Spring Boot REST API):  
https://github.com/robdev97/cinemate-backend.git

---

## 🔧 Jak uruchomić projekt

### Wymagania:
- Java 21+
- Gradle
- Backend REST API (musisz uruchomić go osobno)

### Konfiguracja build.gradle
plugins {
    id 'java'
    id 'org.springframework.boot' version '3.2.5'
    id 'io.spring.dependency-management' version '1.1.4'
    id 'com.vaadin' version '24.3.4'
}

group = 'com.cinemate'
version = '0.0.1-SNAPSHOT'

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-web'
    testRuntimeOnly 'org.junit.platform:junit-platform-launcher'
    implementation 'com.vaadin:vaadin-spring-boot-starter:24.3.4'
    implementation 'com.fasterxml.jackson.core:jackson-databind'
    implementation 'org.springframework.boot:spring-boot-starter-validation'
    implementation 'org.apache.commons:commons-compress:1.26.1'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
    runtimeOnly 'com.mysql:mysql-connector-j'
    compileOnly 'org.projectlombok:lombok'
    annotationProcessor 'org.projectlombok:lombok'

}

tasks.named('test') {
    useJUnitPlatform()
}


### Krok po kroku:
1. Sklonuj repozytorium:
git clone https://github.com/robdev97/cinemate-frontend.git


2. W razie potrzeby zaktualizuj adres URL backendu w klasach `*Client.java`.

3. Uruchom aplikację:
./gradlew bootRun


4. Aplikacja będzie dostępna pod adresem:  
`http://localhost:8081` (lub innym, jeśli zmodyfikujesz port)

---

## 🧰 Technologie:
- Java
- Vaadin 24
- REST Client
- Lombok
- Spring Boot
- Gradle

---

## ✍️ Autor:
Robert – uczestnik bootcampu Kodilla Java Developer  
