plugins {
    war
}

group = "com.torutk.book"

repositories {
    mavenCentral()
}

dependencies {
    providedCompile("jakarta.servlet:jakarta.servlet-api:6.0.0")
    providedCompile("jakarta.annotation:jakarta.annotation-api:2.1.1")
    runtimeOnly("com.h2database:h2:2.2.224")
}
